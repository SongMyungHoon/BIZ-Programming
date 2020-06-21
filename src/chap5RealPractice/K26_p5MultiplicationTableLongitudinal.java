package chap5RealPractice;

public class K26_p5MultiplicationTableLongitudinal {
	public static void main(String[] args) {
		// 9-9 단 (진행방향: 세로)
		for(int k26_i = 1; k26_i < 4; k26_i++) {
			System.out.printf("************** ************** **************\n");
			for(int k26_j = 1; k26_j < 4; k26_j++) {
				System.out.printf(" 구구단  %d 단%2s",k26_i + 3*(k26_j - 1)," ");
			}
			System.out.printf("\n");
			System.out.printf("************** ************** **************\n");
			for(int k26_k = 1; k26_k < 10; k26_k++) {
				for(int k26_j = 1; k26_j < 4; k26_j++) {
					System.out.printf("%2s%d * %d = %2d%3s",
							" ", k26_i + 3*(k26_j - 1), k26_k, (k26_i + 3*(k26_j - 1))*k26_k, " ");
				}
				System.out.printf("\n");
			}
		}
	}
}
