package chap4SelecIterArray;

public class K26_p23NumberReadAdvance {
	public static void main(String[] args) {
		
		// 읽을 숫자를 저장한다
		int k26_iNumVal = 1000000000;
		
		// 정수형 k26_iNumVal를 String으로 변환한다
		String k26_sNumVal = String.valueOf(k26_iNumVal);
		
		// k26_iNumVal의 한글 발음을 저장하기 위한 String type 변수 선언
		String k26_sNumVoice = "";
		
		/* 읽을 숫자를 아라비아 숫자로 출력
		 *자리수를 String에서 length method를 사용하여 문자열 개수를 읽어 구해 출력한다. */
		System.out.printf("==> %s [%d자리]\n", k26_sNumVal, k26_sNumVal.length());
		
		// 일의 자리 숫자, 십의 자리 숫자를 count하기 위한 정수형 변수 i, j 선언
		int k26_i, k26_j;
		
		// 일의 자리 숫자를 한글로 저장
		String[] k26_units = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
		
		// 십의 자리 이상의 자리수를 한글로 저장
		String[] k26_unitX = {"", "십", "백", "천", "만", "십", "백", "천", "억", "십"};
		
		// 일의 자리를 한글로 저장받은 String array의 index count를 위해 i = 0 으로 초기화
		k26_i = 0;
		
		/* 일의 자리 외의 자리 수는 전체 자리수 - 일의 자리 수이므로 전체 String의 길이 - 1 해준다.
		 * i는 0부터, j는 가장 큰 수부터 서로 증감 방향이 반대방향으로 진행
		 * 숫자를 읽을 땐 큰 자리수 숫자부터 읽기 때문 */
		k26_j = k26_sNumVal.length() - 1;
		
		// while의 조건절에 true -> 무한 루프
		while(true) {
		
			// i가 자리수보다 크다면 while loop 탈출
			if(k26_i >= k26_sNumVal.length()) break;
			
			// 각 자리의 숫자를 숫자[한글]숫자[한글].. 형태로 표기
			System.out.printf("%s[%s]",
							// String type의 아라비아 숫자를 담고있는 문자열에서 앞부분 한글자씩 떼어낸다.
							k26_sNumVal.substring(k26_i, k26_i + 1),
							/* String type의 아라비아 숫자를 앞부분부터 한글자씩 떼어 Integer로 parse한 값을
							 * 일의 자리 숫자를 한글로 저장한 String array k26_units의 index로 넣어
							 * 해당하는 숫자의 한글 발음을 불러 온다 */
							k26_units[Integer.parseInt(k26_sNumVal.substring(k26_i, k26_i + 1))]);
			
			/* String type 아라비아 숫자를 담는 sNumVal에서 앞부분부터 한 글자 씩 떼어 냈을 때
			 * 해당 글자가 "0" 이라면 */
			if(k26_sNumVal.substring(k26_i, k26_i+1).contentEquals("0")) {
			
				/* 해당 자리가 0일 땐 단위 값을 안붙이는데 억과 만 자리는 붙인다.
				 * 이백 사만 이십.. 이백 만 원..
				 * 억, 만 자리가 아니라면 아무 것도 안함
				 * 십의 자리 이상의 한글 발음을 저장하고 있는 unitX의 index로 
				 * 가장 큰 수의 자리 수부터 넣었을 때 해당 자리수가 "만" 또는 "억"인 경우 */
				if(k26_unitX[k26_j].equals("만") || k26_unitX[k26_j].equals("억")) {
					
					// k26_sNumVoice의 마지막 글자가 "억"이 아니라면,
					if(!k26_sNumVoice.endsWith("억")) {
						// 숫자의 한글 발음을 누적해서 더한 sNumVoice에 "만" 또는 "억"을 더해준다.
						k26_sNumVoice = k26_sNumVoice + "" + k26_unitX[k26_j];
					}
				} else {
					// 아무 것도 하지 않는다.
				}
				
			/* String type 아라비아 숫자를 담는 sNumVal에서 앞 부분부터 한 글자 씩 떼어냈을 때
			 * 해당 글자가 "0" 이 아닌 경우 */
			} else {
				
				// 숫자의 한글발음[아라비아숫자][자리수 한글발음]을 누적해서 더해준다
				k26_sNumVoice = k26_sNumVoice
						+ k26_units[Integer.parseInt(k26_sNumVal.substring(k26_i, k26_i+1))]
						+ k26_unitX[k26_j];
			}

			if(k26_sNumVoice.isEmpty()) {
				// k26_sNumVoice에 값이 아무 것도 저장되지 않으면, "영"을 저장한다.
				k26_sNumVoice = k26_units[0];
			}
			/* 일의 자리는 증가, 십의자리 이상은 감소 
			 * 숫자를 읽을 땐 큰 자리수 숫자부터 읽기 때문 */
			k26_i++; k26_j--;	
		}
		
		// 아라비아 숫자 전체[한글발음 전체]를 화면에 출력한다.
		System.out.printf("\n%s[%s]\n", k26_sNumVal,k26_sNumVoice);

	}	// main method end
}	// K26_p23NumberReadAdvance Class end