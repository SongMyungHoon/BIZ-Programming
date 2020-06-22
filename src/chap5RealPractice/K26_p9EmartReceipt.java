package chap5RealPractice;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class K26_p9EmartReceipt {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String[] itemname = {"[19년산] 이맛쌀 20kg","초코파이","바나나우유","건포도","오렌지주스"
				,"초코에몽","[냉장] 새꼬막살 250g","샐러드로 건강하게 한 끼 식사","허니버터아몬드 210g"
				,"[국내산] 당찬 사과4~7입/봉","국내산삼겹살구이용100g","블랙앵거스초이스윗등심살 100g"
				,"니베아 선 프로텍트 앤 라이트 선 세럼 90ml"};
		int[] price = {49800,1000,2500,3300,25000
				,100,6980,3980,7480
				,7980,2380,2600
				,6900};
		int[] num = {2,4,1,1,10
				,15,1,1,1
				,1,1,1
				,1};
		boolean[] taxfree = {true,false,false,true,false
				,false,true,true,false
				,true,true,true
				,false};
		
		// 전체 주문 금액	
		int k26_totalPrice = 0;
		int taxFreeVal = 0;
		
		for(int i = 0; i < price.length; i++) {
			k26_totalPrice += price[i]*num[i];
			if(taxfree[i]) {
				taxFreeVal += price[i]*num[i];
			}
		}
				
		double k26_taxRate = 0.1;	// 부가세율
		// 과세액 (= 세전금액) : 버림처리
		// 34,546
		double k26_taxation = (int) ((k26_totalPrice - taxFreeVal) / (1 + k26_taxRate));
		int k26_iTaxation = (int) k26_taxation;
	
		double k26_tax = k26_iTaxation * k26_taxRate;	// 부가세액 (항상 올림 처리)
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
				System.out.printf("%02d%s",i+1,"*");
			} else {
				System.out.printf("%02d%s",i+1," ");	// 총액. 11글자까지
			}
			korPrint(itemname[i]);
			System.out.printf("%11.11s%3.3s%10.10s\n"
					, k26_dFormat.format(price[i])	// 단가. 11글자까지
					, k26_dFormat.format(num[i])	// 수량. 2글자까지
					, k26_dFormat.format(price[i]*num[i]));	// 총액. 11글자까지
		}
		System.out.printf("%12s(*)면 세  물 품%14s\n"," ",k26_dFormat.format(taxFreeVal));
		System.out.printf("%15s과 세  물 품%14s\n"," ",k26_dFormat.format(k26_taxation));
		System.out.printf("%15s부   가   세%14s\n"," ",k26_dFormat.format(k26_iTax));
		System.out.printf("%15s합%8s계%14s\n"," "," ",k26_dFormat.format(k26_totalPrice));
		System.out.printf("결 제 대 상 금 액%24s\n",k26_dFormat.format(k26_totalPrice));
		/*---------- </BODY> ----------*/
		/*---------- <TAIL> ----------*/
		System.out.printf("-----------------------------------------\n");
		/*---------- </TAIL> ----------*/

	}
	public static void korPrint(String itemName) throws UnsupportedEncodingException {
		int realWidth = itemName.getBytes("EUC-KR").length;
		System.out.printf("%s",itemName);
		for(int i = 0; i < 14 - realWidth; i++) {
			System.out.printf(" ");
		}
	}
	
	public String cutItemName(String itemName, int byteLen, int sizePerLetter) {
		int cutLengthCount = 0;
		int tempSize = 0;
		if(itemName == null || "".equals(itemName)) {
			itemName = "";
		}
		
		for(int i = 0; i < itemName.length(); i++) {
			if(itemName.charAt(i) > 127) {
				if(byteLen >= tempSize + sizePerLetter) {
					tempSize += sizePerLetter;
					cutLengthCount++;
				}
			} else {
				if(byteLen > tempSize) {
					tempSize++;
					cutLengthCount++;
				}
			}
		}
		return itemName.substring(0, cutLengthCount);
	}
}