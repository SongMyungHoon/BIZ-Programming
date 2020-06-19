package chap4SelecIterArray;

public class K26_p17SearchRange {

	public static void main(String[] args) {
		// 범위를 주어서 찾기
		int k26_iVal;	// int type k26_iVal 변수 선언
		
		// for loop 300회 반복 설정
		for(int k26_i = 0; k26_i < 300; k26_i++) {
			
			k26_iVal = 5 * k26_i; // 반복 횟수에 5를 곱한 값을 k26_iVal에 저장
			
			// k26_iVal이 0 이상 10 미만인 경우, 가장 큰 자리 수인 "일"을 출력
			if(k26_iVal >= 0 && k26_iVal < 10) System.out.printf("일 %d\n", k26_iVal);
			
			// k26_iVal이 10 이상 100 미만인 경우, 가장 큰 자리 수인 "십"을 출력
			else if(k26_iVal >= 10 && k26_iVal < 100) System.out.printf("십 %d\n", k26_iVal);
			// k26_iVal이 100 이상 1000 미만인 경우, 가장 큰 자리 수인 "백"을 출력
			
			else if(k26_iVal >= 100 && k26_iVal < 1000) System.out.printf("백 %d\n", k26_iVal);
			
			// k26_i가 0부터 299까지이므로 else는 k26_iVal이 1000 이상에 해당한다
			// 가장 큰 자리 수인 "천"을 출력
			else System.out.printf("천 %d\n", k26_iVal);
		}	// for loop end
	}	// main method end
}	// k26_p17SearchRange Class end