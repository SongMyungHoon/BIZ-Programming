package chap4SelecIterArray;

class K26_p19UnstructuedComp {

	public static void main(String[] args) {
		
		for(int k26_i = 1; k26_i < 13; k26_i++) {
			// i는 "월"을 의미
			System.out.printf(" %d월 =>", k26_i);
			for(int k26_j = 1; k26_j < 32; k26_j++) {
				// j는 "일"을 의미
				// 월(i)이 4, 6, 7, 9, 11
				System.out.printf("%d", k26_j);	// 일 출력
				if(k26_i == 4 || k26_i == 6|| k26_i == 7 || k26_i ==9 || k26_i == 11) {
					if(k26_j == 30) break;	// 30번 반복 시 inner for loop 탈출
				}
				// 2 월(i)인 경우
				if(k26_i == 2) {
					if(k26_j == 28)	break;	// 28번 반복 시 inner for loop 탈출
				}
				if(k26_j == 31) {
					// 31일 인 경우 콤마 안붙임
				} else {	// 말일이 아닌 경우 일 뒤에 콤마와 공백 붙임
					System.out.printf(", ");
				}
			}	// inner for loop end
			// "j" loop가 끝나 "일"이 모두 출력되고, "월"이 변경되기 전, 줄바꿈
			System.out.printf("\n");
		}	// outer for loop end
	}	// main method end
}	// K26_p19UnstructuredComp Class end