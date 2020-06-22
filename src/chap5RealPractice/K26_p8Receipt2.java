package chap5RealPractice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class K26_p8Receipt2 {
	public static void main(String[] args) {
		String itemName1, itemName2;	// 항목명
		String itemCode1, itemCode2;	// 항목코드
		int price1, price2;		// 단가
		int num1, num2;			// 수량
		/*------ item1 Info ------*/
		itemName1 = "풀무원샘물";		// 항목명
		itemCode1 = "8809169718205";// 항목코드
		price1 = 600;	// 단가
		num1 = 999;		// 수량
		/*------ item2 Info ------*/
		itemName2 = "드링킹요구르트(딸기외2종)";	// 항목명
		itemCode2 = "8801155822828";		// 항목코드
		price2 = 1600;	// 단가
		num2 = 999;		// 수량
		
		// 전체 주문 금액	
		int k26_orderPrice = price1 * num1 + price2 * num2;
				
		double k26_taxRate = 0.1;	// 부가세율
		// 과세액 (= 세전금액) : 버림처리
		double k26_taxation = k26_orderPrice / (1 + k26_taxRate);
		int k26_iTaxation = (int) k26_taxation;
				
		double k26_tax = k26_taxation * k26_taxRate;	// 부가세액 (항상 올림 처리)
		int k26_iTax;
		/* 실수형 전체 환전 수수료 -> 정수로 형변환 -> 다시 실수형으로 형변환 했을 때 
		 * 원상복귀가 된다는 것은 소수점 이하 숫자가 존재한다는 뜻*/
		if (k26_tax != (double) ((int) k26_tax)) {	// 소수점 이하 숫자가 있다면
			k26_iTax = (int) k26_tax + 1;			// 올림 처리해준다.
		} else {	// 소수점 이하 숫자가 없다면 == 정수
			k26_iTax = (int) k26_tax;	// 정수형으로 형변환
		}
		
		/* DecimalFormat 클래스는 format method를 사용해 특정 패턴으로 값을 포맷할 수 있다
		 * 반환값의 type = String, 패턴형식의 지정은 '0', '#'을 사용해서 가능하다.
		 * "0.###", "000.###", "00.#" 등으로 패턴 지정 가능 
		 * 예를 들어 78.53981633 의 경우
		 * "0.###" : 78.54, "000.##" : 078.54, "00.#" : 78.5 
		 * "###,###,###,###,###" : 100조까지 3자리 단위로 ","를 끊어 표시하기 */
		DecimalFormat k26_dFormat = new DecimalFormat("###,###,###,###,###");
		
		Calendar k26_calTime = Calendar.getInstance();	// System의 현재 시간을 얻기 위한 Calendar instance 생성
		
		/* "YYYYMMdd HHmmss" 형식으로 date를 출력하기 위한 
		 * SimpleDateFormat class의 instance, sdfY4M2d2H2m2s2Space1 생성 */
		SimpleDateFormat k26_sdfY4M2d2H2m2s2Space1 = new SimpleDateFormat("YYYYMMdd HHmmss");
		
		/* "YYYYMMddHHmmss" 형식으로 date를 출력하기 위한 
		 * SimpleDateFormat class의 instance, sdfY4M2d2H2m2s2Space0 생성 */
		SimpleDateFormat k26_sdfY4M2d2H2m2s2Space0 = new SimpleDateFormat("YYYYMMddHHmmss");
		
		/* "YYYY/MM/dd" 형식으로 date를 출력하기 위한 
		 * SimpleDateFormat class의 instance, sdfY4M2d2 생성 */
		SimpleDateFormat k26_sdfY4M2d2 = new SimpleDateFormat("YYYY/MM/dd");
		
		// 결제에 사용된 카드번호 저장
		String k26_cardNumber = "5522-20**-****-BADD";
		
		// 가로 전체 길이 : 41
		/*------------ <HEADER> ------------*/
		System.out.printf("충주(양평)휴게소\n");
		System.out.printf("충북충주시가금면용전리380-4\n");
		System.out.printf("최병권 677-85-00239 TEL:043-857-9229\n");
		System.out.printf("\n\n");
		
		// "[정상등록]현재날짜(YYYYMMdd) 현재시각(HHmmss)    POS번호: 0002" 출력
		System.out.printf("[정상등록]%s%3sPOS번호: 0002\n"
				, k26_sdfY4M2d2H2m2s2Space1.format(k26_calTime.getTime())," ");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("품목코드%12s단가%s수량%8s금액\n"," "," "," "); // 8+12+4+1+4+5+4 = 41
		System.out.printf("-----------------------------------------\n");
		/*------------ </HEADER> ------------*/
		/*------------- <BODY> -------------*/
		// item1의 정보를 출력
		System.out.printf("%.20s\n", itemName1);	// 물품명 20글자까지 출력
		// 단가 11글자까지, 수량 5글자까지, 금액 12글자까지
		System.out.printf("%s%11.11s%5.5s%12.12s\n", itemCode1,k26_dFormat.format(price1)
				, k26_dFormat.format(num1), k26_dFormat.format(price1 * num1));
		// item2의 정보를 출력
		System.out.printf("%.20s\n", itemName2);	// 물품명 20글자까지 출력
		// 단가 11글자까지, 수량 5글자까지, 금액 12글자까지
		System.out.printf("%s%11.11s%5.5s%12.12s\n", itemCode2,k26_dFormat.format(price2)
				, k26_dFormat.format(num2), k26_dFormat.format(price2 * num2));
		System.out.printf("\n");
		// 과세 27 글자까지 출력
		System.out.printf("과세 물품 합계%27.27s\n", k26_dFormat.format(k26_iTaxation)); // 41 - 14 = 27
		// 부가세액 27 글자까지
		System.out.printf("부%4s가%4s세%27.27s\n"," ", " ", k26_dFormat.format(k26_iTax)); // 41 - 14 = 27
		// 전체합계 27 글자까지
		System.out.printf("합%10s계%27.27s\n", " ", k26_dFormat.format(k26_orderPrice));
		System.out.printf("026-비씨카드사%27.27s\n","00/00A");
		System.out.printf("카%2s드%2s번%2s호 :%25.25s\n"," "," "," ",k26_cardNumber);	// 카드번호 25글자까지
		// 25 글자까지 출력
		System.out.printf("카%2s드%2s매%2s출 :%25.25s\n"," "," "," ",k26_dFormat.format(k26_orderPrice));
		System.out.printf("거%2s래%2s구%2s분 :%22.22s\n"," "," "," ","일시불");
		System.out.printf("승%2s인%2s번%2s호 : 04-KICC%17d\n"," "," "," ",75549250);
		System.out.printf("가 맹 점 번 호 :\n");
		// 전체 받은 금액 25 글자까지 출력 가능
		System.out.printf("받%2s은%2s금%2s액 :%25.25s\n"," "," "," ",k26_dFormat.format(k26_orderPrice));
		System.out.printf("거%4s스%4s름 :%25.25s\n"," "," ",k26_dFormat.format(0));
		/*------------- </BODY> -------------*/
		/*------------- <TAIL> -------------*/
		System.out.printf("-----------------------------------------\n");
		System.out.printf("주문번호:%11.11s\n","0920");
		System.out.printf("-----------------------------------------\n");
		// %02d : 정수를 포함하여 2칸의 공간을 확보. 빈 공간은 0으로 채운다
		System.out.printf("판매원 : %06d %s\n",2,"편의점2");
		// "현재날짜(2020/06/22)-0002-0922" 출력
		System.out.printf("%s-0002-0922\n",k26_sdfY4M2d2.format(k26_calTime.getTime()));
		// "연동모듈:[00138705  현재날짜및시간(20200622135306)]" 출력
		System.out.printf("연동모듈:[00138705%2s%s]\n"," ",k26_sdfY4M2d2H2m2s2Space0.format(k26_calTime.getTime()));
		/*------------- </TAIL> -------------*/
	}
}