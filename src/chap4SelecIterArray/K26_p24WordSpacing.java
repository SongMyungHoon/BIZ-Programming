package chap4SelecIterArray;

public class K26_p24WordSpacing {

	public static void main(String[] args) {
		// 띄어쓰기 연습
		// i: 0 ~ 9 까지 for loop 10 회 반복
		for(int k26_i = 0; k26_i < 10; k26_i++) {
			// j가 outer for loop의 i 가 같을 때까지 inner for loop 반복
			// j = 1; 2; 3; 4; 5; 6; 7;...
			// outer for loop의 반복 횟수가 증가할 수록 j 값도 커진다
			for(int k26_j = 0; k26_j < k26_i; k26_j++) {
				// 줄이 바뀔 때마다 앞에 붙는 공백이 증가
				System.out.printf(" ");
			}	// for loop end
			// 숫자 출력될 때마다 앞의 공백이 늘어나 출력의 형태는 대각선 모양이 된다.
			System.out.printf("%d\n", k26_i);
		}	// for loop end
	}	// main method end
}	// K26_p24WordSpacing Class end