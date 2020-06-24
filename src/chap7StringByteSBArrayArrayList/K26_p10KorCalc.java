package chap7StringByteSBArrayArrayList;

import java.io.UnsupportedEncodingException;

public class K26_p10KorCalc {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.printf("HanBlankForeword[%s]\n", HanBlankForeword("한글abcd", 15));
		System.out.printf("HanBlankForeword[%s]\n", HanBlankForeword("한글한글aa", 15));
		System.out.printf("HanBlankBackword[%s]\n", HanBlankBackword("한글aa", 15));
		System.out.printf("HanBlankBackword[%s]\n", HanBlankBackword("한글한글aa", 15));
		System.out.printf("한글은 [%d]개\n", HanCount("한글한글aa"));
	}
	
	public static String HanBlankForeword(String string, int limitByte) throws UnsupportedEncodingException {
		String result = "";
		
		// 특정 String의 byte를 count하기 위한 정수형 변수
		int k26_stringByte = 0;
	
		// char의 byte를 count하기 위한 정수형 변수
		int k26_charByte = 0;
		
		// String의 length만큼 반복
		for(int k26_k26_i = 0; k26_k26_i < string.length(); k26_k26_i++) {
			// String의 글자 하나씩 떼어 charByte에 저장
			k26_charByte = string.substring(k26_k26_i, k26_k26_i+1).getBytes("EUC-KR").length;
			// 글자의 byte 크기를 누적해서 k26_stringByte에 저장
			k26_stringByte += k26_charByte;
			// k26_stringByte가 제한 바이트 크기와 같다면
			if(k26_stringByte == limitByte) {
				// 해당 길이 + 1 만큼의 String을 반환(마지막 글자 한글이 아닌 경우)
				result = string.substring(0, k26_k26_i+1);
				break;
			// k26_stringByte가 제한 바이트 크기보다 1 크다면
			} else if(k26_stringByte == limitByte + 1) {
				// 해당 길이만큼의 String을 반환(마지막 글자 한글의 경우)
				result = string.substring(0, k26_k26_i); 
				break;
			} else {
				// 제한 바이트 크기에 걸리지 않는 경우, 그대로 반환
				result = string;
			}
		}	// for loop end
		
		// String 덧셈을 수행하기 위한 StringBuilder instance 생성
		StringBuilder stringBuilder = new StringBuilder();
		
		// byte 길이를 count하기 위한 정수형 변수
		int k26_byteWidth = result.getBytes("EUC-KR").length;
		
		// 제한 바이트 수에서 모자란 바이트 만큼 앞부분에 더해줄 공백을 stringBuilder에 저장
		for(int k26_i = 0; k26_i < limitByte - k26_byteWidth; k26_i++) {
			stringBuilder.append(" ");
		}	// for loop end
		
		// 앞에 더해줄 공백에 string을 붙여준다.
		stringBuilder.append(result);
		// 최종 완성된 String을 StringBuilder.toString()으로 반환한다.
		return stringBuilder.toString();
	}
	
	public static String HanBlankBackword(String string, int limitByte) throws UnsupportedEncodingException {
		String result = "";
		
		// 특정 String의 byte를 count하기 위한 정수형 변수
		int k26_stringByte = 0;
	
		// char의 byte를 count하기 위한 정수형 변수
		int k26_charByte = 0;
		
		// String의 length만큼 반복
		for(int k26_k26_i = 0; k26_k26_i < string.length(); k26_k26_i++) {
			// String의 글자 하나씩 떼어 charByte에 저장
			k26_charByte = string.substring(k26_k26_i, k26_k26_i+1).getBytes("EUC-KR").length;
			// 글자의 byte 크기를 누적해서 k26_stringByte에 저장
			k26_stringByte += k26_charByte;
			// k26_stringByte가 제한 바이트 크기와 같다면
			if(k26_stringByte == limitByte) {
				// 해당 길이 + 1 만큼의 String을 반환(마지막 글자 한글이 아닌 경우)
				result = string.substring(0, k26_k26_i+1);
				break;
			// k26_stringByte가 제한 바이트 크기보다 1 크다면
			} else if(k26_stringByte == limitByte + 1) {
				// 해당 길이만큼의 String을 반환(마지막 글자 한글의 경우)
				result = string.substring(0, k26_k26_i); 
				break;
			} else {
				// 제한 바이트 크기에 걸리지 않는 경우, 그대로 반환
				result = string;
			}
		}	// for loop end
		
		// String 덧셈을 수행하기 위한 StringBuilder instance 생성
		StringBuilder stringBuilder = new StringBuilder();
		
		// byte 길이를 count하기 위한 정수형 변수
		int k26_byteWidth = result.getBytes("EUC-KR").length;
		
		// 앞에 더해줄 공백에 string을 붙여준다.
		stringBuilder.append(result);
		
		// 제한 바이트 수에서 모자란 바이트 만큼 앞부분에 더해줄 공백을 stringBuilder에 저장
		for(int k26_i = 0; k26_i < limitByte - k26_byteWidth; k26_i++) {
			stringBuilder.append(" ");
		}	// for loop end
		
		// 최종 완성된 String을 StringBuilder.toString()으로 반환한다.
		return stringBuilder.toString();
	}

	public static int HanCount(String string) throws UnsupportedEncodingException {
		
		return (string.getBytes("EUC-KR").length - string.length());
	}
}