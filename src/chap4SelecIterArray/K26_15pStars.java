package chap4SelecIterArray;

public class K26_15pStars {

	public static void main(String[] args) {
		// 단순비교
		// for문을 안쓰고 while 사용
		int k26_iA, k26_iB;
		// iA 변수 초기화
		k26_iA = 0;
		// while 조건에 true -> 무한 루프
		while(true) {
			// iB 변수 초기화 : 반복마다 0으로 초기화 된다
			k26_iB = 0;
			// while 조건에 true -> 무한 루프
			while(true) {
				// 먼저 별을 출력하고
				System.out.print("★");	// 별 출력
				// iA와 iB가 같으면
				if(k26_iA == k26_iB) {
					break;	// inner while loop 탈출
				}
				// iB = 출력하는 별의 개수 - 1
				k26_iB++;	//iA != iB라면 iB 1 증가
			}	// inner while loop end
			// 별 출력이 끝나면 줄바꿈
			System.out.printf("\n");	// 줄 바꿈
			// iA는 줄 - 1을 의미
			k26_iA++;
			// 0 ~ 29까지 30줄을 출력하고
			if(k26_iA == 30) {
				break;	// 31번째 출력 전에 outer while loop 탈출
			}
		}	// outer while loop end
	}	// main method end
}	// K16_15pStars Class end