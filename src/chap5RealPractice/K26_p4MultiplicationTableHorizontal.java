package chap5RealPractice;

public class K26_p4MultiplicationTableHorizontal {
	public static void main(String[] args) {
		// 9-9 단 (진행방향: 가로)
		for(int i = 1;i < 4;i++) {
			System.out.printf("************** ************** **************\n");
			for(int j = 1; j < 4; j++) {
				System.out.printf(" 구구단  %d 단%2s",3*(i-1) + j," ");
			}
			System.out.printf("\n");
			System.out.printf("************** ************** **************\n");
			for(int k = 1; k < 10; k++) {
				for(int j = 1; j < 4; j++) {
					System.out.printf("%2s%d * %d = %2d%3s",
							" ", 3*(i-1) + j, k, (3*(i-1) + j)*k, " ");
				}
				System.out.printf("\n");
			}
		}
	}
}