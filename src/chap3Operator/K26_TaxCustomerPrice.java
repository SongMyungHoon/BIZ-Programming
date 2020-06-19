package chap3Operator;

public class K26_TaxCustomerPrice {

	public static void main(String[] args) {
		// 간단한 방정식 (소비자가 세금 계산) [slide 15]
		int k26_custom = 280;	// 소비자가
		int k26_taxRate = 3;	// 세율: 3%
		
		// 세전 가격, 실수로 계산 후 버림처리
		int k26_netVal = (int) (k26_custom / (1 + k26_taxRate/100.0));
		int k26_taxVal = k26_custom - k26_netVal;	// 세액 = 소비자가 - 세전 가격
		
		// Header 부분 출력
		System.out.printf("***********************************************\n");
		System.out.printf("*%11s소비자가 중심 세금 계산%11s*\n"," "," ");
		
		// 소비자가격, 세전 가격, 세액 출력
		System.out.printf(" 소비자가격: %d원, 세전가격: %d원, 세금: %d원\n", k26_custom, k26_netVal, k26_taxVal);
		
		// tail부분 출력
		System.out.printf("***********************************************\n");
	}	// main method end
}	// K26_CustomerPrice Class end
