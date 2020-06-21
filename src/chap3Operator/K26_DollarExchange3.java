package chap3Operator;

public class K26_DollarExchange3 {

	public static void main(String[] args) {
		// 수수료 포함 환전 계산(2)
		// 당연히 수수료는 받아야 할 돈이니 올림처리
		int k26_myWon = 1000000;			// 환전하려고 가져간 원화
		double k26_moneyExRate = 1238.21;	// 달러 환율 [원/달러]
		double k26_commission = 0.003;		// 환전 수수료: 0.3 %
		
		// 환전한 달러, 실수로 계산 후 버림처리
		int k26_usd = (int) (k26_myWon / k26_moneyExRate);		
		
		// 잔돈 계산, 잔돈 = 전체 환전원화 - 달러로 환전한 원화 (환전 수수료 미포함), 실수로 계산 후 버림처리
		int k26_remain = (int) (k26_myWon - k26_usd * k26_moneyExRate);
		
		double k26_ComPerWon = k26_moneyExRate * k26_commission;	// 1달러 당 환전 수수료
		double k26_totalCom = k26_usd * k26_ComPerWon;	// 전체 환전 시 수수료 '달러당 환전 수수료 x 환전한 달러'
				
		int k26_i_totalCom;	// 실수형 전체 환전 수수료를 정수형으로 변경하기 위한 변수
		
		/* 실수형 전체 환전 수수료 -> 정수로 형변환 -> 다시 실수형으로 형변환 했을 때 
		 * 원상복귀가 된다는 것은 소수점 이하 숫자가 존재한다는 뜻*/
		if (k26_totalCom != (double) ((int) k26_totalCom)) {	// 소수점 이하 숫자가 있다면
			k26_i_totalCom = (int) k26_totalCom + 1;			// 올림 처리해준다.
		} else {	// 소수점 이하 숫자가 없다면 == 정수
			k26_i_totalCom = (int) k26_totalCom;	// 정수형으로 형변환
		}
		
		// Header 부분 출력
		System.out.printf("***************************************************************************\n");
		System.out.printf("*%29s수수료 적용환전%29s*\n"," "," ");
		
		// 정수형으로 처리한 전체 환전 수수료, 환전해 받은 달러, 1달러당 환전 수수료를 출력
		System.out.printf("총 수수료: %d원=> 미화: %d달러, 달러당 수수료: %f원\n"
				, k26_i_totalCom, k26_usd, k26_ComPerWon);
		
		// 잔돈 계산, 잔돈 = 전체 환전원화 - 달러로 환전한 원화 - 전체 환전 수수료, 실수로 계산 후 버림처리
		k26_remain = (int) (k26_myWon - k26_usd * k26_moneyExRate - k26_i_totalCom);
		
		// 환전하려고 가져온 원화, 환전 결과 받은 달러, 정수형 처리된 전체 수수료, 잔돈 출력
		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 수수료징수:%d원, 잔돈:%d원\n"
				, k26_myWon, k26_usd, k26_i_totalCom, k26_remain);
		
		// tail부분 출력
		System.out.printf("***************************************************************************\n");
	}	// main method end
}	// K26_DollarExchange3 Class end