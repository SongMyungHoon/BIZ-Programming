package chap3Operator;

public class K26_TaxCalc {
	// 세금 계산 및 올림, 내림 처리 해주는 method
	public static int k26_taxCal(int k26_val, int k26_rate) {
		// 유효숫자 처리의 중요성 및 돈 문제 [slide 13]
		int k26_ret;	// return할 값을 저정할 변수 선언
		/* int 형 paramter를 double type으로 type casting하여 세액 계산
		 * double type 계산 결과가 int type 계산 결과와 동일하면 -> 소수 점 이하 숫자 없음 */
		if(((double)k26_val*(double)k26_rate/100.0)== k26_val*k26_rate/100) {
			k26_ret = k26_val*k26_rate/100;
		} else {
			// 실수 연산과 정수 연산이 다르다면, 소수점 이하 숫자 존재하므로 올림 처리한다. 
			k26_ret = k26_val*k26_rate/100 + 1;
		}	
		return k26_ret; // 계산 결과를 반환
	}	// k26_taxCal method end
	
	public static void main(String[] args) {
		int k26_val = 271;	// 세전 가격
		int k26_rate = 3;	// 세율 3 %
		// 세전 가격과 세율을 k26_taxCal method에 넣고 세금 계산 및 올림, 내림 처리
		int k26_tax = k26_taxCal(k26_val, k26_rate);
		// header 출력
		System.out.printf("*****************************************\n");
		System.out.printf("*             단순 세금 계산                     *\n");
		// 하나라도 double 형식으로 연산하면 실수로 형변환 된다(implicit type casting)
		// 실제 실수로 계산했을 때 세액을 출력
		System.out.printf("  실제 세금계산: %f\n", k26_val*k26_rate/100.0);
		// 세전가격, 올림과 내림처리한 세액, 소비자가격(세후가격) 출력
		System.out.printf("  세전가격: %d, 세금: %d, 세금포함가격: %d\n", k26_val, k26_tax, k26_val + k26_tax);
		// tail 출력
		System.out.printf("*****************************************\n");
	}	// main method end
}	// K26_TaxCalc Class end
