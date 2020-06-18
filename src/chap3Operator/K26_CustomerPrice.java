package chap3Operator;

public class K26_CustomerPrice {

	public static void main(String[] args) {
		
		int k26_custom = 280;
		int k26_taxRate = 3;
		
		int k26_netVal = (int) (k26_custom / (1 + k26_taxRate/100.0));
		int k26_taxVal = k26_custom - k26_netVal;
		
		System.out.printf("*****************************************\n");
		System.out.printf("*        소비자가 중심 세금 계산                *\n");
		
		System.out.printf(" 소비자가격: %d  세전가격:  %d   세금: %d\n", k26_custom, k26_netVal, k26_taxVal);
		System.out.printf("*****************************************\n");
	}

}
