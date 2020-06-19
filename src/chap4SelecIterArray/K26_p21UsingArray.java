package chap4SelecIterArray;

public class K26_p21UsingArray {

	public static void main(String[] args) {
		// slide 21] Array 이용 비교
		// 비정형 비교(룰이 애매한)는 배열을 사용하는 것도 좋은 방법. but 복잡해보이긴 한다.
		int[] k26_iLMD = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		// 배열의 시작 index는 언제나 0부터 라는 점을 반드시 기억할 것
		// iLMD[0] ~ iLMD[11] 이다
		// outer for loop: 1부터 12까지 12회 반복 설정
		for(int k26_i = 1; k26_i < 13; k26_i++) {
			
			// 1월부터 반복 회수 증가할 때마다 i+1 증가해 12월까지 출력
			System.out.printf(" %2d월 =>", k26_i);
			
			// inner for loop: 1부터 31까지 31회 반복 설정
			for(int k26_j = 1; k26_j < 32; k26_j++) {
				
				// 1부터 inner for loop 반복회수 증가할 때마다 j+1 증가해 31까지 출력
				System.out.printf("%d",k26_j);
				
				// j 값이  월별 말일 값을 저장한 iLMD[i]값과 같은 경우
				if(k26_iLMD[k26_i-1] == k26_j) {
					break;	// inner for loop 탈출
				} else {
					System.out.printf(", ");			// 마지막일 콤마 안 찍기
				}
			}	// inner for loop end
			System.out.printf("\n");	// outer for loop 반복 회수가 증가할 때마다 줄바꿈
		}	// outer for loop end
	}	// main method end
}	// K26_p21UsingArray Class end