package chap3Operator;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class K26_DollarExchangeCalendarDatePrac {

	public static void main(String[] args) {
		
		// 돈은 영어 기준 세자리마다 콤마를 찍는다.
		int k26_myWon = 1000000;			// 환전하려고 가져간 원화
		double k26_moneyExRate = 1238.21;	// 달러 환율 [원/달러]
		double k26_commission = 0.003;		// 환전 수수료: 0.3 %
		double k26_ComPerWon = k26_moneyExRate * k26_commission;	// 1달러 당 환전 수수료[원/달러]
		// 환전한 달러, 실수로 계산 후 버림처리
		int k26_usd = (int) (k26_myWon / (k26_moneyExRate + k26_ComPerWon));
		double k26_totalCom = k26_usd * k26_ComPerWon;	// 전체 환전 시 수수료 '달러당 환전 수수료 x 환전한 달러'
		int k26_i_totalCom;	// 실수형 전체 환전 수수료를 정수형으로 변경하기 위한 변수
		
		/* 실수형 전체 환전 수수료 -> 정수로 형변환 -> 다시 실수형으로 형변환 했을 때 
		 * 원상복귀가 된다는 것은 소수점 이하 숫자가 존재한다는 뜻*/
		if (k26_totalCom != (double) ((int) k26_totalCom)) {	// 소수점 이하 숫자가 있다면
			k26_i_totalCom = (int) k26_totalCom + 1;			// 올림 처리해준다.
		} else {	// 소수점 이하 숫자가 없다면 == 정수
			k26_i_totalCom = (int) k26_totalCom;	// 정수형으로 형변환
		}
		
		/* DecimalFormat 클래스는 format method를 사용해 특정 패턴으로 값을 포맷할 수 있다
		 * 반환값의 type = String, 패턴형식의 지정은 '0', '#'을 사용해서 가능하다.
		 * "0.###", "000.###", "00.#" 등으로 패턴 지정 가능 
		 * 예를 들어 78.53981633 의 경우
		 * "0.###" : 78.54, "000.##" : 078.54, "00.#" : 78.5 
		 * "###,###,###,###,###" : 100조까지 3자리 단위로 ","를 끊어 표시하기 */
		DecimalFormat k26_dFormat = new DecimalFormat("###,###,###,###,###");
		
		// Header 부분 출력
		System.out.printf("********************************************************************************\n");
		System.out.printf("*%30s콤마찍기, 날짜적용%30s*\n"," "," ");

		System.out.printf(" 총 수수료: %s원=> 미화: %s달러, 달러당 수수료: %f원\n"
				, k26_dFormat.format(k26_i_totalCom) // k26_dFormat으로 k26_i_totalCom 값을 출력하도록 지정
				, k26_dFormat.format(k26_usd)	// k26_dFormat으로 k26_usd 값을 출력하도록 지정
				, k26_ComPerWon);				// 실수형이므로 DecimalFormat 미사용
		
		// 잔돈 계산, 잔돈 = 전체 환전원화 - 달러로 환전한 원화 - 전체 환전 수수료, 실수로 계산 후 버림처리
		int k26_remain = (int) (k26_myWon - k26_usd * k26_moneyExRate - k26_i_totalCom);
		System.out.printf(" 총 한화환전금액: %s원 => 미화: %s달러, 수수료징수:%s원, 잔돈:%s원\n"
				, k26_dFormat.format(k26_myWon)		// k26_dFormat으로 k26_myWon 값을 출력하도록 지정
				, k26_dFormat.format(k26_usd)		// k26_dFormat으로 k26_usd 값을 출력하도록 지정
				, k26_dFormat.format(k26_i_totalCom)// k26_dFormat으로 k26_i_totalCom 값을 출력하도록 지정
				, k26_dFormat.format(k26_remain));	// k26_dFormat으로 k26_remain 값을 출력하도록 지정
		
		Calendar k26_calTime = Calendar.getInstance();	// System의 현재 시간을 얻기 위한 Calendar instace 생성
		
		// Date type의 format을 지정하기 위한 SimpleDateFormat instance 생성
		SimpleDateFormat k26_simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		
		// Calender Class의 getTime method로 System 상 현재 시간을 k26_simpleDateFormat 형태로 출력
		System.out.printf(" 최종실행시간: %s\n", k26_simpleDateFormat.format(k26_calTime.getTime()));
		
		// tail부분 출력
		System.out.printf("********************************************************************************\n");
	}	// main method end
}	// K26_CalendarDatePrac Class end