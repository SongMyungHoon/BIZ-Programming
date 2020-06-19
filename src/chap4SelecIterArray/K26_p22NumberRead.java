package chap4SelecIterArray;

public class K26_p22NumberRead {

	public static void main(String[] args) {
		// 일의 자리 숫자를 한글로 저장
		String[] k26_units = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
		// for loop 반복 회수 0부터 100까지 101회 설정
		for(int k26_i = 0; k26_i < 101; k26_i++) {
			
			if(k26_i >= 0 && k26_i < 10 ) {	// i가 0 이상 10 미만이라면
				// 일의 자리 출력
				System.out.printf("일의 자리 : %s\n", k26_units[k26_i]);
			} else if (k26_i >= 10 && k26_i < 100) {	// i가 10 이상 100 미만이라면
				int k26_i10, k26_i0;	// 십의 자리와 일의 자리를 구분해 저장하기 위한 int형 변수 선언
				k26_i10 = k26_i/10;	// 십의 자리 저장
				k26_i0 = k26_i %10; // 일의 자리 저장
				if(k26_i0 == 0) { // 일의 자리가 0 이라면, 한글로 읽을 때 십 영 이라고 읽지 않으므로
					// 다른 값과 달리 구분해서 출력한다
					System.out.printf("십의자리 : %s십\n", k26_units[k26_i10]);
				} else {	// 일의 자리가 0이 아닌 경우
					// 일반적으로 몇십몇 이라고 출력한다.
					System.out.printf("십의자리 : %s십%s\n", k26_units[k26_i10], k26_units[k26_i0]);
				}
			  // i 100 이상이라면
			} else System.out.printf("==> %d\n", k26_i); // i값을 아라비아 숫자로 출력한다.
		}	// for loop end
	}	// main method end
}	// K26_p22NumberRead end
