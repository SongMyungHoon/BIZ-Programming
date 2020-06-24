package chap5RealPractice;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class K26_p9EmartReceipt {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// itemname : 물품 이름을 저장하는 String Array
		String[] k26_itemname
			= {"이맛쌀 20kg"
				,"초코파이","바나나우유","건포도","오렌지주스"						// 5
				,"초코에몽","새꼬막살 250g","샐러드로 건강하게 한 끼 식사","허니버터아몬드 210g"		// 4
				,"당찬 사과4~7입/봉","국내산삼겹살구이용100g","블랙앵거스초이스윗등심살 100g"		// 3
				,"니베아 선 프로텍트 앤 라이트 선 세럼 90ml","버터와플 316g","쵸코하임18개입284g"	// 3
				,"팔도비빔면 4입기획","진비빔면156g*4","노브랜드 파인애플 슬라이스 850g"			// 3
				,"입판란 (30개입/특란)","국내산 칼집 삼겹살 100g", "노브랜드 냉동 닭가슴살 1kg"		// 3
				,"국내산돈앞다리불고기(100g)","국내산돈등심카레용 100g(소팩)","깨끗한 물티슈 100매" // 3
				,"3겹 화장지30m30롤","구르 키친타올 230매*4입","템포 레귤러 20P"					// 3
				,"유한락스 레귤러 3.5L","다우니 고농축 섬유유연제 엑스퍼트 2L","LG생활건강 테크 울드라이 1.3L 리필"};// 3
		
		// itemname의 요소에 대응되는 물품의 가격을 저장하는 int Array
		int[] k26_price // 7480
			= {49800,1000,2500,3300,25000,100,6980,3980,10000000,7980
				,2380,2600,6900,3280,3280,2680,2780,2980,4990,2580
				,5980,1280,1280,800,7900,3980,9500,5930,10900,3900};
		
		// itemname의 요소에 대응되는 물품의 수량을 저장하는 int Array
		int[] k26_num 
			= {2,4,1,1,2,15,1,1,1,1
				,1,1,1,1,1,1,1,1,1,1
				,1,1,1,1,1,1,1,1,1,1};
		
		// itemname의 요소에 대응되는 물품의 면세 여부를 저장하는 boolean Array
		boolean[] k26_taxfree 
			= {true,false,false,true,false,false,true,true,false,true
				,true,true,false,false,false,false,false,false,true,true
				,true,true,true,false,false,false,false,false,false,false};
		
		// k26_totalPrice : 전체 주문 금액	
		int k26_totalPrice = 0;
		// k26_taxFreeVal : 전체 면세액
		int k26_taxFreeVal = 0;
		
		// 전체 주문 금액, 전체 면새액을 계산
		for(int k26_i = 0; k26_i < k26_itemname.length; k26_i++) {
			// k26_totalPrice += 각 물품의 단가 * 각 물품의 수량
			k26_totalPrice += k26_price[k26_i]*k26_num[k26_i];
			// 만약 해당 물품이 면세물품에 해당한다면,
			if(k26_taxfree[k26_i]) {
				// k26_taxFreeVal += 해당 물품의 단가 * 해당 물품의 수량
				k26_taxFreeVal += k26_price[k26_i]*k26_num[k26_i];
			}
		}
		// k26_taxRate : 부가세율 : 10 %		
		double k26_taxRate = 10;
		/* 과세액 (= 세전금액) : 버림처리 
		 * 과세액 = 전체금액 - 면세금액, 부동소수점 문제 해결 */
		double k26_taxation = ((k26_totalPrice - k26_taxFreeVal) / (100 + k26_taxRate))*100;
		int k26_iTaxation = (int) k26_taxation;
	
		double k26_tax = k26_taxation * k26_taxRate/100;	// 부가세액 (항상 올림 처리)
		int k26_iTax;	// 부가세액을 올림 처리하여 int 형 변수로 저장하기 위한 변수 선언
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
		// 전체 가로 길이 42 바이트
		System.out.printf("%15s이마트 죽전점 (031)888-1234\n"," ");
		System.out.printf("%5semart%5s%s\n"," "," ","206-86-50913 이갑수");
		System.out.printf("%15s용인시 수지구 포은대로 552\n", " ");
		System.out.printf("\n");
		System.out.printf("영수증 미지참시 교환/환불 불가(30일내)\n");
		System.out.printf("교환/환불 구매점에서 가능(결제카드지참)\n");
		System.out.printf("체크카드/신용카드 청구취소 반영은\n");
		System.out.printf("최대 3~5일 소요 (주말,공휴일제외)\n\n");
		System.out.printf("[구 매]%s%6sPOS:%04d-2418\n" // 7+16+5+4+4+5
				// 현재 날짜를 format(YYYY-MM-dd HHmm)에 맞게 출력
				, k26_sdfY4M2d2H2m2Space1Hyphen.format(k26_calTime.getTime())	
				, " ",9);
		System.out.printf("------------------------------------------\n");
		System.out.printf("%3s상 품 명%8s단  가%3s수량%4s금  액\n"," "," "," "," ");
		System.out.printf("------------------------------------------\n");
		/*---------- </HEADER> ----------*/
		
		/*---------- <BODY> ----------*/
		int k26_limitLength = 14; // byte 단위의 ring 길이 한계값 
		// k26_itemname Array의 length 수 만큼 반복
		for(int k26_i = 0; k26_i < k26_itemname.length; k26_i++) {
			if(k26_taxfree[k26_i]) {
				// 면세 대상 물품인 경우 * 포함해서 출력
				// k26_i가 0부터 시작하므로,출력 번호는 k26_i + 1
				System.out.printf("%02d%-2s",k26_i + 1, "*");
			} else {
				// 면세 대상이 아닌 경우 공백 포함해서 출력
				// k26_i가 0부터 시작하므로,출력 번호는 k26_i + 1
				System.out.printf("%02d%-2s",k26_i + 1, " ");
			}
			
			/* 물품 이름에 한글이 포함된 경우, 한글과 한글 외 문자를 구분하여 
			 * 바이트 크기 제한에 맞추어 문자를 잘라 출력해주는 method */ 
			k26_korPrint(k26_itemname[k26_i], k26_limitLength);
			
			System.out.printf("%11.11s%3.3s%10.10s\n"
					, k26_dFormat.format(k26_price[k26_i])	// 단가를 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(k26_num[k26_i])	// 수량을 3자리마다 콤마 넣어서 출력
					// 품목 계산 총액을 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(k26_price[k26_i]*k26_num[k26_i]));
			
		}	// for loop end
		// 면세액 총합을 의미하는 k26_taxFreeVal을 3글자씩 콤마로 구분하여 출력
		System.out.printf("%12s(*)면 세  물 품%15s\n"," ",k26_dFormat.format(k26_taxFreeVal));
		// 과세물품 가격 총합을 의미하는 k26_taxFreeVal을 3글자씩 콤마로 구분하여 출력
		System.out.printf("%15s과 세  물 품%15s\n"," ",k26_dFormat.format(k26_iTaxation));
		// 부가세액 총합을 의미하는 k26_taxFreeVal을 3글자씩 콤마로 구분하여 출력
		System.out.printf("%15s부   가   세%15s\n"," ",k26_dFormat.format(k26_iTax));
		// 전체 합계를 의미하는 k26_totalPrice를 3글자씩 콤마로 구분하여 출력
		System.out.printf("%15s합%8s계%15s\n"," "," ",k26_dFormat.format(k26_totalPrice));
		// 결제 대상 금액을 의미하는 k26_totalPrice를 3글자씩 콤마로 구분하여 출력
		System.out.printf("결 제 대 상 금 액%25s\n",k26_dFormat.format(k26_totalPrice));
		System.out.printf("------------------------------------------\n");
		System.out.printf("0024 하  나%31s\n","5417**8890/07850246");
		System.out.printf("카드결제%31s\n"	// 카드결제%30("일시불 / k26_toalPrice")값 출력 	
				,String.format("%s / %s", "일시불", k26_dFormat.format(k26_totalPrice)));
		/*---------- </BODY> ----------*/
		
		/*---------- <TAIL> ----------*/
		System.out.printf("------------------------------------------\n");
		System.out.printf("송*훈 고객님의 포인트 현황입니다.\n");
		/*---------- </TAIL> ----------*/
	}	// main method end
	
	/* 바이트 크기 제한에 맞추어 문자를 출력해주는 method */
	public static void k26_korPrint(String k26_itemName, int k26_limitLength) throws UnsupportedEncodingException {
		// byte 길이를 count하기 위한 정수형 변수
		int k26_byteWidth = k26_cutItemName(k26_itemName, k26_limitLength).getBytes("EUC-KR").length;
		// 자른 문자열을 출력
		System.out.printf("%s",k26_cutItemName(k26_itemName, k26_limitLength));
		// 제한 바이트 수에서 모자란 바이트 만큼 뒷부분 공백을 추가 출력
		for(int k26_i = 0; k26_i < k26_limitLength - k26_byteWidth; k26_i++) {
			System.out.printf(" ");
		}	// for loop end
	}	// k26_korPrint method end
	
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
		}	// for loop end
		// 제한 바이트 크기에 걸리지 않는 경우, 그대로 반환
		return k26_itemName;
	}	// k26_cutItemName method end
}	// K26_p9EmartReceipt Class end