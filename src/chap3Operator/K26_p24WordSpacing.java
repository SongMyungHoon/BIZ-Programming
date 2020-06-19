package chap3Operator;

public class K26_p24WordSpacing {

	public static void main(String[] args) {
		// 띄어쓰기 연습
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < i; j++) {
				System.out.printf(" ");
			}
			System.out.printf("%d\n", i);
		}
	}
}