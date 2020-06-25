package chap7StringByteSBArrayArrayList;

import java.io.UnsupportedEncodingException;

public class K26_p10KorCalc {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.printf("HanBlankForeword[%s]\n", k26_HanBlankForeword("�ѱ�abcd", 15));
		System.out.printf("HanBlankForeword[%s]\n", k26_HanBlankForeword("�ѱ��ѱ�aa", 15));
		System.out.printf("HanBlankBackword[%s]\n", k26_HanBlankBackword("�ѱ�aa", 15));
		System.out.printf("HanBlankBackword[%s]\n", k26_HanBlankBackword("�ѱ��ѱ�aa", 15));
		System.out.printf("�ѱ��� [%d]��\n", k26_HanCount("�ѱ��ѱ�aa"));
	}
	
	public static String k26_HanBlankForeword(String k26_string, int k26_limitByte) throws UnsupportedEncodingException {
		String k26_result = "";
		
		// Ư�� String�� byte�� count�ϱ� ���� ������ ����
		int k26_stringByte = 0;
	
		// char�� byte�� count�ϱ� ���� ������ ����
		int k26_charByte = 0;
		
		// String�� length��ŭ �ݺ�
		for(int k26_k26_i = 0; k26_k26_i < k26_string.length(); k26_k26_i++) {
			// String�� ���� �ϳ��� ���� charByte�� ����
			k26_charByte = k26_string.substring(k26_k26_i, k26_k26_i+1).getBytes("EUC-KR").length;
			// ������ byte ũ�⸦ �����ؼ� k26_stringByte�� ����
			k26_stringByte += k26_charByte;
			// k26_stringByte�� ���� ����Ʈ ũ��� ���ٸ�
			if(k26_stringByte == k26_limitByte) {
				// �ش� ���� + 1 ��ŭ�� String�� ��ȯ(������ ���� �ѱ��� �ƴ� ���)
				k26_result = k26_string.substring(0, k26_k26_i+1);
				break;
			// k26_stringByte�� ���� ����Ʈ ũ�⺸�� 1 ũ�ٸ�
			} else if(k26_stringByte == k26_limitByte + 1) {
				// �ش� ���̸�ŭ�� String�� ��ȯ(������ ���� �ѱ��� ���)
				k26_result = k26_string.substring(0, k26_k26_i); 
				break;
			} else {
				// ���� ����Ʈ ũ�⿡ �ɸ��� �ʴ� ���, �״�� ��ȯ
				k26_result = k26_string;
			}
		}	// for loop end
		
		// String ������ �����ϱ� ���� StringBuilder instance ����
		StringBuilder k26_stringBuilder = new StringBuilder();
		
		// byte ���̸� count�ϱ� ���� ������ ����
		int k26_byteWidth = k26_result.getBytes("EUC-KR").length;
		
		// ���� ����Ʈ ������ ���ڶ� ����Ʈ ��ŭ �պκп� ������ ������ stringBuilder�� ����
		for(int k26_i = 0; k26_i < k26_limitByte - k26_byteWidth; k26_i++) {
			k26_stringBuilder.append(" ");
		}	// for loop end
		
		// �տ� ������ ���鿡 string�� �ٿ��ش�.
		k26_stringBuilder.append(k26_result);
		// ���� �ϼ��� String�� StringBuilder.toString()���� ��ȯ�Ѵ�.
		return k26_stringBuilder.toString();
	}
	
	public static String k26_HanBlankBackword(String k26_string, int k26_limitByte) throws UnsupportedEncodingException {
		String k26_result = "";
		
		// Ư�� String�� byte�� count�ϱ� ���� ������ ����
		int k26_stringByte = 0;
	
		// char�� byte�� count�ϱ� ���� ������ ����
		int k26_charByte = 0;
		
		// String�� length��ŭ �ݺ�
		for(int k26_k26_i = 0; k26_k26_i < k26_string.length(); k26_k26_i++) {
			// String�� ���� �ϳ��� ���� charByte�� ����
			k26_charByte = k26_string.substring(k26_k26_i, k26_k26_i+1).getBytes("EUC-KR").length;
			// ������ byte ũ�⸦ �����ؼ� k26_stringByte�� ����
			k26_stringByte += k26_charByte;
			// k26_stringByte�� ���� ����Ʈ ũ��� ���ٸ�
			if(k26_stringByte == k26_limitByte) {
				// �ش� ���� + 1 ��ŭ�� String�� ��ȯ(������ ���� �ѱ��� �ƴ� ���)
				k26_result = k26_string.substring(0, k26_k26_i+1);
				break;
			// k26_stringByte�� ���� ����Ʈ ũ�⺸�� 1 ũ�ٸ�
			} else if(k26_stringByte == k26_limitByte + 1) {
				// �ش� ���̸�ŭ�� String�� ��ȯ(������ ���� �ѱ��� ���)
				k26_result = k26_string.substring(0, k26_k26_i); 
				break;
			} else {
				// ���� ����Ʈ ũ�⿡ �ɸ��� �ʴ� ���, �״�� ��ȯ
				k26_result = k26_string;
			}
		}	// for loop end
		
		// String ������ �����ϱ� ���� StringBuilder instance ����
		StringBuilder k26_stringBuilder = new StringBuilder();
		
		// byte ���̸� count�ϱ� ���� ������ ����
		int k26_byteWidth = k26_result.getBytes("EUC-KR").length;
		
		// �տ� ������ ���鿡 string�� �ٿ��ش�.
		k26_stringBuilder.append(k26_result);
		
		// ���� ����Ʈ ������ ���ڶ� ����Ʈ ��ŭ �պκп� ������ ������ stringBuilder�� ����
		for(int k26_i = 0; k26_i < k26_limitByte - k26_byteWidth; k26_i++) {
			k26_stringBuilder.append(" ");
		}	// for loop end
		
		// ���� �ϼ��� String�� StringBuilder.toString()���� ��ȯ�Ѵ�.
		return k26_stringBuilder.toString();
	}

	public static int k26_HanCount(String k26_string) throws UnsupportedEncodingException {
		
		return (k26_string.getBytes("EUC-KR").length - k26_string.length());
	}
}