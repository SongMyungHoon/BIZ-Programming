package chap5RealPractice;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TestClass {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String[] itemName = {"[19년산] 이맛쌀 20kg","초코파이","바나나우유","건포도","오렌지주스"
//				,"초코에몽","[냉장] 새꼬막살 250g","샐러드로 건강하게 한 끼 식사","허니버터아몬드 210g"
//				,"[국내산] 당찬 사과4~7입/봉","국내산삼겹살구이용100g","블랙앵거스초이스윗등심살 100g"
//				,"니베아 선 프로텍트 앤 라이트 선 세럼 90ml"};
//		cutItemName(itemName[0]);
		String itemName1, itemName2;	// 항목명
		String itemCode1, itemCode2;	// 항목코드
		int price1, price2;		// 단가
		int num1, num2;			// 수량
		/*------ item1 Info ------*/
		itemName1 = "풀무원샘물";		// 항목명
		itemCode1 = "8809169718205";// 항목코드
		price1 = 600;	// 단가
		num1 = 1;		// 수량
		/*------ item2 Info ------*/
		itemName2 = "드링킹요구르트(딸기외2종)";	// 항목명
		itemCode2 = "8801155822828";		// 항목코드
		price2 = 1600;	// 단가
		num2 = 1;		// 수량
		
		// 전체 주문 금액	
		int k26_orderPrice = price1 * num1 + price2 * num2;
				
		double k26_taxRate = 10;	// 부가세율
		// 과세액 (= 세전금액) : 버림처리
		// 부동소수점으로 인한 에러 문제 해결 : 나눗셈 분수 부분에 소수 제거
		double k26_taxation = (k26_orderPrice / (100 + k26_taxRate))*100;
		int k26_iTaxation = (int) k26_taxation;
		/* 실수형 전체 환전 수수료 -> 정수로 형변환 -> 다시 실수형으로 형변환 했을 때 
		 * 원상복귀가 된다는 것은 소수점 이하 숫자가 존재한다는 뜻*/
//		if(k26_taxation > )
//		if (k26_taxation != (double) ((int) k26_taxation)) {	// 소수점 이하 숫자가 있다면
//			k26_iTaxation = (int) k26_taxation + 1;			// 올림 처리해준다.
//		} else {	// 소수점 이하 숫자가 없다면 == 정수
//			k26_iTaxation = (int) k26_taxation;	// 정수형으로 형변환
//		}
	
		System.out.printf("taxation : %f\niTaxation : %d\nintTaxation : %d",k26_taxation,k26_iTaxation);
//		k26_korPrint("  아우디",12);
//		System.out.printf("098123 %d %d\n","아우디".getBytes("EUC-KR").length, "아우디".length());
//		k26_korPrint("뷁아우디",12);
//		System.out.printf("098123 %d %d\n","뷁아우디".getBytes("EUC-KR").length,"뷁".length());
//		k26_korPrint("벤츠",12);
//		System.out.printf("098123 %d %d\n","벤츠".getBytes("EUC-KR").length,"벤츠".length());
	}
	/* 바이트 크기 제한에 맞추어 문자를 출력해주는 method */
	public static void k26_korPrint(String k26_itemName, int k26_limitLength) throws UnsupportedEncodingException {
		// byte 길이를 count하기 위한 정수형 변수
		int k26_byteWidth = k26_cutItemName(k26_itemName, k26_limitLength).getBytes("EUC-KR").length;
		// 자른 문자열을 출력
		System.out.printf("%s",k26_cutItemName(k26_itemName, k26_limitLength));
		// 제한 바이트 수에서 모자란 바이트 만큼 뒷부분 공백을 추가 출력
		for(int k26_i = 0; k26_i < k26_limitLength - k26_byteWidth; k26_i++) {
			System.out.printf(" ");
		}
	}
	
	/* 물품 이름에 한글이 포함된 경우, 한글과 한글 외 문자를 구분하여 
	 * 바이트 크기 제한에 맞추어 문자를 잘라서 반환하는 method */
	public static String k26_cutItemName(String k26_itemName, int k26_limitLength) throws UnsupportedEncodingException {
		// 특정 String의 byte를 count하기 위한 정수형 변수
		int k26_stringByte = 0;
	
		// char의 byte를 count하기 위한 정수형 변수
		int k26_charByte = 0;
		
		// String의 length만큼 반복
		for(int k26_k26_i = 0; k26_k26_i < k26_itemName.length(); k26_k26_i++) {
			// String의 글자 하나씩 떼어 charByte에 저장
			k26_charByte = k26_itemName.substring(k26_k26_i, k26_k26_i+1).getBytes("EUC-KR").length;
			// 글자의 byte 크기를 누적해서 k26_stringByte에 저장
			k26_stringByte += k26_charByte;
			// k26_stringByte가 제한 바이트 크기와 같다면
			if(k26_stringByte == k26_limitLength) {
				// 해당 길이 + 1 만큼의 String을 반환(마지막 글자 한글이 아닌 경우)
				return k26_itemName.substring(0, k26_k26_i+1);
			// k26_stringByte가 제한 바이트 크기보다 1 크다면
			} else if(k26_stringByte == k26_limitLength + 1) {
				// 해당 길이만큼의 String을 반환(마지막 글자 한글의 경우)
				return k26_itemName.substring(0, k26_k26_i);
			}
		}
		// 제한 바이트 크기에 걸리지 않는 경우, 그대로 반환
		return k26_itemName;
	}
	
//	public static String cutItemName(String itemName) throws UnsupportedEncodingException {
//		int stringByte = 0;
//		int charByte = 0;
//		
//		System.out.printf("string.getBytes(\"EUC-KR\").length : %d\n", itemName.getBytes("EUC-KR").length);
//		for(int i = 0; i < itemName.length(); i++) {
//			charByte = itemName.substring(i, i+1).getBytes("EUC-KR").length;
//			stringByte += charByte;
//			if(stringByte == 14) {
//				System.out.printf("getBytes : %d\n", itemName.substring(0, i+1).getBytes("EUC-KR").length);
//				return itemName.substring(0, i+1);
//			} else if(stringByte == 15) {
//				System.out.printf("return getBytes : %d\n", itemName.substring(0, i).getBytes("EUC-KR").length);
//				return itemName.substring(0, i);
//			}
//		}
// 		System.out.printf("stringByte : %d\n", stringByte);
//		
//		return itemName;
//	}
}
//	nonKorLength = itemName.length() * 2 - itemName.getBytes("EUC-KR").length();
//	korLength = itemName.length - nonKorLength;
//	realWidth = korLength * 2 + nonKorLength;
	