package chap7StringByteSBArrayArrayList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class K26_Item {	// 물품 data와 물품에 대한 method를 class로 묶음
	
	String k26_id;		// 품목 번호
	String k26_name;	// 품목 명
	int k26_unitPrice;	// 품목의 단가
	int k26_num;		// 품목의 수량
	int k26_totalPrice;	// 전체 금액
	
	/* DecimalFormat 클래스는 format method를 사용해 특정 패턴으로 값을 포맷할 수 있다
	 * 반환값의 type = String, 패턴형식의 지정은 '0', '#'을 사용해서 가능하다.
	 * "0.###", "000.###", "00.#" 등으로 패턴 지정 가능 
	 * 예를 들어 78.53981633 의 경우
	 * "0.###" : 78.54, "000.##" : 078.54, "00.#" : 78.5 
	 * "###,###,###,###,###" : 100조까지 3자리 단위로 ","를 끊어 표시하기 */
	private static DecimalFormat k26_dFormat = new DecimalFormat("###,###,###,###,###");
	
	// 입력받은 parameter의 값을 Item class instance의 field 값으로 지정하는 Constructor
	public K26_Item(String k26_id, String k26_name, String k26_unitPrice
			, String k26_num, String k26_totalPrice) {
		this.k26_id = k26_id;		// parameter로 받은 id 값을 instance의 id로 지정
		this.k26_name = k26_name;	// parameter로 받은 name 값을 instance의 name으로 지정
		
		/* parameter로 받은 unitPirce 값을 deleteComma method argument로 입력해
		 * 중간에 존재하는 Comma를 제거하고 Integer.parseInt method로 String type으로
		 * Type casting해 Item instance의 unitPirce에 지정 */
		this.k26_unitPrice = Integer.parseInt(k26_deleteComma(k26_unitPrice));
		
		/* parameter로 받은 num 값에  deleteComma method argument로 입력해
		 * 중간에 Comma가 존재한다면 Comma를 제거하고 Integer.parseInt method로
		 * String type으로 형 변환해 Item instance의 num에 지정 */
		this.k26_num = Integer.parseInt(k26_deleteComma(k26_num));
		
		/* parameter로 받은 totalPirce 값을 deleteComma method argument로 입력해
		 * 중간에 존재하는 Comma를 제거하고 Integer.parseInt method로 String type으로
		 * Type casting해 Item instance의 totalPirce에 지정 */
		this.k26_totalPrice = Integer.parseInt(k26_deleteComma(k26_totalPrice));
	}
	
	/* parameter로 입력받은 String에 Comma가 존재하는 경우
	 * Comma를 제거한 String으로 반환하는 method */
	public String k26_deleteComma(String k26_string) {
		if(k26_string.contains(",")) {	// 입력받은 parameter에 Comma 존재한다면
			
			// String addition에 사용할 StringBuilder instance 선언
			StringBuilder k26_stringBuilder = new StringBuilder();
			
			// Comma를 구분자로하여 parameter를 split해 Comma 제거
			for(String k26_element : k26_string.split(",")) {
			
				// Comma를 제거한 String을 StringBuilder로 addition 
				k26_stringBuilder.append(k26_element);
			}	// for loop end
			
			// 하나의 String으로 재조립한 결과 값을 return
			return k26_stringBuilder.toString();
		
		} else {	// 입력 받은 parameter에 Comma가 없는 경우
			return k26_string;	// 입력 받은 parameter 그대로 return
		}
	}	// k26_deleteComma method end
	
	/* Item Class의 totalPrice와 unitPrice * num 으로 계산한 total Price가 
	 * 다른 경우, 잘못된 record의 정보를 출력하고, unitPrice * num 으로 계산한
	 * 값으로 totalPrice를 수정한 후 record를 출력하는 method */
	public void k26_checkTotalPrice() {
		
		// totalPrice field 값이 unitPrice * num 과 다른 경우
		if(this.k26_unitPrice * this.k26_num != this.k26_totalPrice) {
			System.out.printf("★★★★★★★★★★★★★★★★★★★★\n");
			
			// 오류 문구와 해당 오류가 발생한 id 값을 출력
			System.out.printf("오류[%-3s", this.k26_id);	 
			System.out.printf("%11.11s%3.3s%10.10s]\n"
					// 단가를 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(this.k26_unitPrice)
					// 수량을 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(this.k26_num)
					// 품목 계산 총액을 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(this.k26_totalPrice));
			System.out.printf("★★★★★★★★★★★★★★★★★★★★\n");
			
			// 수정 문구와 해당 오류가 발생한 id 값을 출력
			System.out.printf("수정[%-3s", this.k26_id);
			System.out.printf("%11.11s%3.3s%10.10s]\n"
					// 단가를 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(this.k26_unitPrice)
					// 수량을 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(this.k26_num)
					// 품목 계산 총액을 3자리마다 콤마 넣어서 출력
					, k26_dFormat.format(this.k26_unitPrice * this.k26_num));
			System.out.printf("★★★★★★★★★★★★★★★★★★★★\n");
		}	// if end
	}	// k26_checkTotalPrice method end

}	// K26_Item Class end

public class K26_p11FieldExtract {
	
	public static void main(String[] args) {
		String[] k26_OneRec = {	// record를 저장할 String Array type 변수 선언
				"01* 이맛쌀 20kg        49,800  2    99,600", 
				"02  초코파이            1,000  4     4,000",
				"03  바나나우유          2,500  1     2,500",
				"04* 건포도              3,300  1     3,300",
				"05  오렌지주스         25,000  2    50,000",
				"06  초코에몽              100 15     1,500",
				"07* 새꼬막살 250g       6,980  1     6,980", 
				"08* 샐러드로 건강       3,980  1     3,980", 
				"09  허니버터아몬드      1,000  1     1,000", 
				"10* 당찬 사과4~7입      7,980  1     7,980", 
				"11* 국내산삼겹살구      2,380  1     1,000", 
				"12* 블랙앵거스초이      2,600  1     2,600", 
				"13  니베아 선 프로      6,900  1     6,900", 
				"14  버터와플 316g       3,280  1     3,280", 
				"15  쵸코하임18개입      3,280  1     3,200", 
				"16  팔도비빔면 4입      2,680  1     2,680", 
				"17  진비빔면156g*4      2,780  1     2,780", 
				"18  노브랜드 파인       2,980  1     2,980", 
				"19* 입판란 (30개입      4,990  1     4,000", 
				"20* 국내산 칼집 삼      2,580  1     2,580", 
				"21* 노브랜드 냉동       5,980  1     5,980", 
				"22* 국내산돈앞다리      1,280  1     1,280", 
				"23* 국내산돈등심카      1,280  1     1,000", 
				"24  깨끗한 물티슈         800  1       800", 
				"25  3겹 화장지30m3      7,900  1     7,900", 
				"26  구르 키친타올       3,980  1     3,980", 
				"27  템포 레귤러 20      9,500  1     9,500", 
				"28  유한락스 레귤       5,930  1     5,930", 
				"29  다우니 고농축      10,900  1     9,900", 
				"30  LG생활건강 테       3,900  1     3,900"};
		/* record를 한 줄씩 읽어 저장할 
		 * List type instance를 ArrayList type instance로 선언 */
		List<String> k26_strList;	
		
		/* record를 Item class로 저장해, data object로 받아 전체 item에 대한 data를 저장할
		 * List type instance를 ArrayList type instance로 선언 */
		List<K26_Item> k26_itemList = new ArrayList<K26_Item>();
		
		// String Array의 모든 data object의 수만큼 for - each 문 반복
		for(String k26_element : k26_OneRec) {
			
			/* String Array의 data object를 fieldExtract method로 
			 * 각 field를 구분자 "&"로 구분해주고 fieldExtract method의 return 값을
			 * 구분자 "&"로 split한 결과 얻어지는 Array를 Array to List로 
			 * type casting하여 strList에 저장 */
			k26_strList = Arrays.asList(k26_fieldExtract(k26_element).split("&"));
			
			/* strList의 각 element 값을 Item constructor의 argument로 입력하여 
			 * Item class type instacne를 선언해 itemList에 add */
			k26_itemList.add(new K26_Item(
								k26_strList.get(0)
								,k26_strList.get(1)
								,k26_strList.get(2)
								,k26_strList.get(3)
								,k26_strList.get(4)));
		}	// for loop end
		// itemList의 모든 item type element에 대해 for - each 문 반복
		for(K26_Item k26_item : k26_itemList) {
			// item의 checkTotalPrice method로 totalPrice값을 확인
			k26_item.k26_checkTotalPrice();
		}	// for loop end
	}	// main method end
	
	/* parameter로 입력받은 String을 공백으로 구분하여 field 별로 index를 matching해
	 * 각 field를 "&"로 구분하여 String으로 다시 재조립해 return해주는 method */
	public static String k26_fieldExtract(String k26_record) {
		// parameter를 구분자 blank로 split하여 해당 결과를 String Array를 선언해 저장
		String[] k26_splittedString = k26_record.split(" ");
		
		// String 재조립에 사용할 StringBuilder type instance 선언
		StringBuilder stringBuilder = new StringBuilder();
		
		// splittedString array의 모든 element에 대해 for - each 문 반복 
		for(String k26_element : k26_splittedString) {
			
			// element가 not empty라면
			if(!k26_element.isEmpty()) {
				// (element + "&")를 stringBuilder에 add
				stringBuilder.append(k26_element).append("&");
			}
		}	// for loop end
		// splittedString array에 empty element를 제거한 array를 저장
		k26_splittedString = stringBuilder.toString().split("&");
		// 사용한 stringBuilder 초기화
		stringBuilder.setLength(0);
		
		// field의 수가 5개보다 크다면
		if(k26_splittedString.length >= 6) {
			String[] resultStrArray = new String[5];
			resultStrArray[0] = k26_splittedString[0];	// id는 공백을 포함하지 않으므로  그대로 저장
			// totalPrice는 공백을 포함하지 않는 field이므로 그대로 저장
			resultStrArray[4] = k26_splittedString[k26_splittedString.length - 1];
			// num은 공백을 포함하지 않는 field이므로 그대로 저장
			resultStrArray[3] = k26_splittedString[k26_splittedString.length - 2];
			// unitPrice은 공백을 포함하지 않는 field이므로 그대로 저장
			resultStrArray[2] = k26_splittedString[k26_splittedString.length - 3];
			
			/* field 값 내에 공백을 포함하는 field는 name뿐이다.
			 * name field에 해당하는 index만큼만 반복 */
			for(int i = 1; i < k26_splittedString.length - 3; i++) {
				/* 공백으로 인해 split되면 안되는 내용이 split되었으므로 다시 name field 하나로 조립
				 * split된 공백을 추가해준다. */
				stringBuilder.append(k26_splittedString[i]).append(" ");
			}	// for loop end
			// name field의 값에 재조립한 name 값을 마지막 공백을 잘라주고 저장한다.
			resultStrArray[1] = stringBuilder.toString().trim();
			stringBuilder.setLength(0);	// 사용한 stringBuilder instance 초기화
			k26_splittedString = resultStrArray;	// manipulated string array
		}
		// manipulated string array를 "&"를 구분자로 구분한 string으로 다시 재조립한다.
		for(String element : k26_splittedString) {
			stringBuilder.append(element).append("&");			
		}
		// 마지막에 무의미한 구분자가 추가되었으므로 마지막 구분자를 제외한 String을 return
		return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
	}	// k26_fieldExtract method end
}	// K26_p11FieldExtract class end
