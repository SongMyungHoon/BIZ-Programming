package chap5RealPractice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class K26_p9EmartReceipt {

	public static void main(String[] args) {
		String[] itemname = {"초코파이","바나나우유","건포도","오렌지주스","초코에몽"};
		int[] price = {1000,2500,3300,25000,100};
		int[] num = {2,4,1,1,10};
		boolean[] taxfree = {true,true,false,true,true};
		
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
		SimpleDateFormat k26_sdfY4M2d2H2m2Space1Hyphen = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		
		/*---------- <HEADER> ----------*/
		System.out.printf("emart\n");
		System.out.printf("이마트 죽전점 (031)888-1234\n");
		System.out.printf("206-86-50913 이갑수\n");
		System.out.printf("용인시 수지구 포은대로 552\n");
		System.out.printf("영수증 미지참시 교환/환불 불가(30일내)\n");
		System.out.printf("교환/환불 구매점에서 가능(결제카드지참)\n");
		System.out.printf("체크카드/신용카드 청구취소 반영은\n");
		System.out.printf("최대 3~5일 소요 (주말,공휴일제외)\n\n");
		System.out.printf("[구 매]%s%5sPOS:%04d-2418\n" // 7+16+5+4+4+5
				, k26_sdfY4M2d2H2m2Space1Hyphen.format(k26_calTime.getTime())
				, " ",9);
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%3s상 품 명%7s단  가%2s수량%4s금  액\n"," "," "," "," ");	// 상품명까지가 11개,
		System.out.printf("-----------------------------------------\n");
		/*---------- </HEADER> ----------*/
		/*---------- <BODY> ----------*/
		for(int i = 0; i < itemname.length; i++) {
			if(taxfree[i]) {
				System.out.printf("%02d%-2s",i,"*");
			} else {
				System.out.printf("%02d%-2s",i," ");	// 총액. 11글자까지
			}
			System.out.printf("%-10s%10s%3.3s%10.10s\n",itemname[i]
					, k26_dFormat.format(price[i])	// 단가. 11글자까지
					, k26_dFormat.format(num[i])	// 수량. 2글자까지
					, k26_dFormat.format(price[i]*num[i]));	// 총액. 11글자까지
			
//			if(itemname[i].getBytes().length == 13) {
//				System.out.printf("%-14.12s", itemname[i]);
//			} else {
//				System.out.printf("%-14.14s", itemname[i]);
//			}
//			System.out.printf("%10s", itemname[i]);
//			System.out.printf("%s%3.3s%10.10s\n"
//					, k26_dFormat.format(price[i])	// 단가. 11글자까지
//					, k26_dFormat.format(num[i])	// 수량. 2글자까지
//					, k26_dFormat.format(price[i]*num[i]));	// 총액. 11글자까지
		}
		/*---------- </BODY> ----------*/
		/*---------- <TAIL> ----------*/
		
		/*---------- </TAIL> ----------*/

	}
//	public static

}
