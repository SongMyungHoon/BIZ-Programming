package chap3Operator;

public class K26_DollarExchange1 {

	public static void main(String[] args) {
		// 단순 환전 계산
		int k26_myWon = 1000000;			// 환전하려고 가져간 원화
		double k26_moneyExRate = 1238.21;	// 달러 환율 [원/달러]
		double k26_commission = 0.003;		// 환전 수수료: 0.3 %
		
		int k26_usd = (int) (k26_myWon / k26_moneyExRate);	// 환전한 달러, 실수로 계산 후 버림처리
		
		// 잔돈 계산, 잔돈 = 전체 환전원화 - 달러로 환전한 원화 (환전 수수료 미포함), 실수로 계산 후 버림처리
		int k26_remain = (int) (k26_myWon - k26_usd * k26_moneyExRate);
		
		// Header 부분 출력
		System.out.printf("*******************************************************\n");
		System.out.printf("*%19s수수료없이 계산%19s*\n"," "," ");
		
		// 환전하려고 가져간 원화, 환전한 달러, 잔돈 출력
		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 잔돈: %d원\n"
				, k26_myWon, k26_usd, k26_remain);
		
		// tail부분 출력
		System.out.printf("*******************************************************\n");
	}	// main method end
}	// K26_DollarExchanger1 Class end