package chap4SelecIterArray;

public class K26_p20Case {

	public static void main(String[] args) {
		// 이번 예제는 억지로 만든 것, 절대 이렇게 코딩하지 않는다.
		for(int k26_i = 1; k26_i < 13; k26_i++) {
			
			// i는 "월"을 의미
			System.out.printf(" %d월 =>", k26_i);
			
			// j for loop를 LOOP로 지정(Labeling)
			k26_LOOP:for(int k26_j = 1; k26_j < 32; k26_j++) {
				
				// j는 "일"을 의미
				System.out.printf("%d", k26_j);
				
				switch(k26_i) {
				
					// 월(i)이 4, 6, 7, 9, 11
					case 4: case 6: case 7: case 9: case 11:
						if(k26_j == 30) break k26_LOOP;	// 일(j)는 30일이다.
					
						// 이런 표현은 거의 안함
						// LOOP라는 표시자가 없으면 엉뚱한 결과 나옴
						break;
					
					case 2:	// 2 월(i)인 경우
						// 28 일(j)까지
						if(k26_j == 28) break k26_LOOP;
						break;
					// 그 외의 달(month)인 경우, 자동으로 31일
				}	// switch end
				if(k26_j == 31) {
					// day가 31인 경우, 콤마와 공백을 빼고
				} else {
					System.out.printf(", ");	// 말일이 아닌 경우, 콤마와 공백을 더해준다
				}
			}	// k26_Loop end
			// "j" loop가 끝나 "일"이 모두 출력되고, "월"이 변경되기 전, 줄바꿈
			System.out.printf("\n");
		}	// outer for loop end
	}	// main method end
}	// K26_p20Case Class end
