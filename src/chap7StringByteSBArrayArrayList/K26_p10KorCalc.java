package chap7StringByteSBArrayArrayList;

import java.io.UnsupportedEncodingException;

public class K26_p10KorCalc {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.printf("HanBlankForeword[%s]\n", HanBlankForeword("�ѱ�abcd", 15));
		System.out.printf("HanBlankForeword[%s]\n", HanBlankForeword("�ѱ��ѱ�aa", 15));
		System.out.printf("HanBlankBackword[%s]\n", HanBlankBackword("�ѱ�aa", 15));
		System.out.printf("HanBlankBackword[%s]\n", HanBlankBackword("�ѱ��ѱ�aa", 15));
		System.out.printf("�ѱ��� [%d]��\n", HanCount("�ѱ��ѱ�aa"));
	}
	
	public static String HanBlankForeword(String string, int limitByte) throws UnsupportedEncodingException {
		String result = "";
		
		// Ư�� String�� byte�� count�ϱ� ���� ������ ����
		int k26_stringByte = 0;
	
		// char�� byte�� count�ϱ� ���� ������ ����
		int k26_charByte = 0;
		
		// String�� length��ŭ �ݺ�
		for(int k26_k26_i = 0; k26_k26_i < string.length(); k26_k26_i++) {
			// String�� ���� �ϳ��� ���� charByte�� ����
			k26_charByte = string.substring(k26_k26_i, k26_k26_i+1).getBytes("EUC-KR").length;
			// ������ byte ũ�⸦ �����ؼ� k26_stringByte�� ����
			k26_stringByte += k26_charByte;
			// k26_stringByte�� ���� ����Ʈ ũ��� ���ٸ�
			if(k26_stringByte == limitByte) {
				// �ش� ���� + 1 ��ŭ�� String�� ��ȯ(������ ���� �ѱ��� �ƴ� ���)
				result = string.substring(0, k26_k26_i+1);
				break;
			// k26_stringByte�� ���� ����Ʈ ũ�⺸�� 1 ũ�ٸ�
			} else if(k26_stringByte == limitByte + 1) {
				// �ش� ���̸�ŭ�� String�� ��ȯ(������ ���� �ѱ��� ���)
				result = string.substring(0, k26_k26_i); 
				break;
			} else {
				// ���� ����Ʈ ũ�⿡ �ɸ��� �ʴ� ���, �״�� ��ȯ
				result = string;
			}
		}	// for loop end
		
		// String ������ �����ϱ� ���� StringBuilder instance ����
		StringBuilder stringBuilder = new StringBuilder();
		
		// byte ���̸� count�ϱ� ���� ������ ����
		int k26_byteWidth = result.getBytes("EUC-KR").length;
		
		// ���� ����Ʈ ������ ���ڶ� ����Ʈ ��ŭ �պκп� ������ ������ stringBuilder�� ����
		for(int k26_i = 0; k26_i < limitByte - k26_byteWidth; k26_i++) {
			stringBuilder.append(" ");
		}	// for loop end
		
		// �տ� ������ ���鿡 string�� �ٿ��ش�.
		stringBuilder.append(result);
		// ���� �ϼ��� String�� StringBuilder.toString()���� ��ȯ�Ѵ�.
		return stringBuilder.toString();
	}
	
	public static String HanBlankBackword(String string, int limitByte) throws UnsupportedEncodingException {
		String result = "";
		
		// Ư�� String�� byte�� count�ϱ� ���� ������ ����
		int k26_stringByte = 0;
	
		// char�� byte�� count�ϱ� ���� ������ ����
		int k26_charByte = 0;
		
		// String�� length��ŭ �ݺ�
		for(int k26_k26_i = 0; k26_k26_i < string.length(); k26_k26_i++) {
			// String�� ���� �ϳ��� ���� charByte�� ����
			k26_charByte = string.substring(k26_k26_i, k26_k26_i+1).getBytes("EUC-KR").length;
			// ������ byte ũ�⸦ �����ؼ� k26_stringByte�� ����
			k26_stringByte += k26_charByte;
			// k26_stringByte�� ���� ����Ʈ ũ��� ���ٸ�
			if(k26_stringByte == limitByte) {
				// �ش� ���� + 1 ��ŭ�� String�� ��ȯ(������ ���� �ѱ��� �ƴ� ���)
				result = string.substring(0, k26_k26_i+1);
				break;
			// k26_stringByte�� ���� ����Ʈ ũ�⺸�� 1 ũ�ٸ�
			} else if(k26_stringByte == limitByte + 1) {
				// �ش� ���̸�ŭ�� String�� ��ȯ(������ ���� �ѱ��� ���)
				result = string.substring(0, k26_k26_i); 
				break;
			} else {
				// ���� ����Ʈ ũ�⿡ �ɸ��� �ʴ� ���, �״�� ��ȯ
				result = string;
			}
		}	// for loop end
		
		// String ������ �����ϱ� ���� StringBuilder instance ����
		StringBuilder stringBuilder = new StringBuilder();
		
		// byte ���̸� count�ϱ� ���� ������ ����
		int k26_byteWidth = result.getBytes("EUC-KR").length;
		
		// �տ� ������ ���鿡 string�� �ٿ��ش�.
		stringBuilder.append(result);
		
		// ���� ����Ʈ ������ ���ڶ� ����Ʈ ��ŭ �պκп� ������ ������ stringBuilder�� ����
		for(int k26_i = 0; k26_i < limitByte - k26_byteWidth; k26_i++) {
			stringBuilder.append(" ");
		}	// for loop end
		
		// ���� �ϼ��� String�� StringBuilder.toString()���� ��ȯ�Ѵ�.
		return stringBuilder.toString();
	}

	public static int HanCount(String string) throws UnsupportedEncodingException {
		
		return (string.getBytes("EUC-KR").length - string.length());
	}
}