package chap3Operator;

public class K26_DollarExchange2 {

	public static void main(String[] args) {
		// 수수료 포함 환전 계산(1)
		int k26_myWon = 1000000;			// 환전하려고 가져간 원화
		double k26_moneyExRate = 1238.21;	// 달러 환율 [원/달러]
		double k26_commission = 0.003;		// 환전 수수료: 0.3 %
		int k26_usd = (int) (k26_myWon / k26_moneyExRate);		// 환전한 달러, 실수로 계산 후 버림처리
		double k26_ComPerWon = k26_moneyExRate * k26_commission;// 1달러 당 환전 수수료
		double k26_totalCom = k26_usd * k26_ComPerWon;	// 전체 환전 시 수수료 '달러당 환전 수수료 x 환전한 달러'
		
		// Header 부분 출력
		System.out.printf("*******************************************************************\n");
		System.out.printf("*%27s수수료 계산%27s*\n"," "," ");
		
		// 전체 환전시 수수료, 환전한 총 달러, 1달러 당 환전 수수료 출력
		System.out.printf("총 수수료: %f원=> 미화: %d달러, 달러당 수수료: %f원\n"
				, k26_totalCom, k26_usd, k26_ComPerWon);
		
		// tail부분 출력
		System.out.printf("*******************************************************************\n");
	}	// main method end
}	// K26_DollarExchange2 Class end