package chap5RealPractice;

public class K26_p4MultiplicationTableHorizontal {
	public static void main(String[] args) {
		// 9-9 단 (진행방향: 가로)
		// 1 줄의 raw 에 3 개의 단 출력 : 3 줄의 raw
		for(int k26_i = 1; k26_i < 4; k26_i++) {
			/*--------------- <HEADER> --------------- */
			System.out.printf("************** ************** **************\n");
			for(int k26_j = 1; k26_j < 4; k26_j++) {
				// 3*(i - 1) + j : 구구단의 단 수를 의미 (1, 2, 3; 4, 5, 6; 7, 8, 9)
				System.out.printf(" 구구단  %d 단%2s",3*(k26_i - 1) + k26_j," ");
			}	// for loop end
			System.out.printf("\n");
			System.out.printf("************** ************** **************\n");
			/*--------------- </HEADER> --------------- */
			/*--------------- <BODY> --------------- */
			// k : 단 수에 곱해지는 1 ~ 9의 숫자
			for(int k26_k = 1; k26_k < 10; k26_k++) {
				// 1 줄의 raw 에 3 개의 단 출력 : 3 줄의 raw (j = 1 ~ 3)
				for(int k26_j = 1; k26_j < 4; k26_j++) {
					System.out.printf("%2s%d * %d = %2d%3s"
							// 3 * (k26_i - 1) + k26_j : 곱셈의 첫번째 값
							, " ", 3 * (k26_i - 1) + k26_j	// 1,2,3, ... ,9
							, k26_k		// k26_k : 곱셈의 두번째 값 (1,2,3, ... ,9)
							// (3 * (k26_i - 1) + k26_j) * k26_k : 곱셈의 결과 값
							, (3 * (k26_i - 1) + k26_j) * k26_k, " ");
				}	// for loop end
				System.out.printf("\n");
			}	// for loop end
			/*--------------- </BODY> --------------- */
		}	// for loop end
	}	// main method end
}	// K26_p4MultiplicationTableHorizontal Class end