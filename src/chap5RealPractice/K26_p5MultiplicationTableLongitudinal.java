package chap5RealPractice;

public class K26_p5MultiplicationTableLongitudinal {
	public static void main(String[] args) {
		// 9-9 단 (진행방향: 세로)
		// 1 줄의 raw 에 3 개의 단 출력 : 3 줄의 raw
		for(int k26_i = 1; k26_i < 4; k26_i++) {
			/*--------------- <HEADER> --------------- */
			System.out.printf("************** ************** **************\n");
			for(int k26_j = 1; k26_j < 4; k26_j++) {
				// i + 3*(j - 1) : 구구단의 단 수를 의미 (1, 4, 7; 2, 5, 8; 3, 6, 9)
				System.out.printf(" 구구단  %d 단%2s",k26_i + 3*(k26_j - 1)," ");
			}	// for loop end
			System.out.printf("\n");
			System.out.printf("************** ************** **************\n");
			/*--------------- </HEADER> --------------- */
			/*--------------- <BODY> --------------- */
			// k : 단 수에 곱해지는 1 ~ 9의 숫자
			for(int k26_k = 1; k26_k < 10; k26_k++) {
				// 1 줄의 raw 에 3 개의 단 출력 : 3 줄의 raw (j = 1 ~ 3)
				for(int k26_j = 1; k26_j < 4; k26_j++) {
					System.out.printf("%2s%d * %d = %2d%3s",
							/* i = 1, 2, 3; j = 1, 2, 3;
							 * j - 1 = 0, 1, 2
							 * i + 3*(j - 1) = (i, j)
							 * => (1, 1) = 1, (1, 2) = 4, (1, 3) = 7;
							 * => (2, 1) = 2, (2, 2) = 5, (2, 3) = 8;
							 * => (3, 1) = 3, (3, 2) = 6, (3, 3) = 9; */
							" ", k26_i + 3*(k26_j - 1)
							, k26_k		// k = 1, 2, 3, ... ,9;
							, (k26_i + 3*(k26_j - 1))*k26_k, " ");
				}	// for loop end
				System.out.printf("\n");
			}	// for loop end
			/*--------------- </BODY> --------------- */
		}	// for loop end
	}	// main method end
}	// K26_p4MultiplicationTableLongitudinal Class end