package chap8File;

import java.io.*;

public class K26_p10L07 {

	public static void main(String[] args) throws IOException {
//		String k26_filePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
//				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터\\day_data\\"
//				+ "THTSKS010H00.dat";
		String k26_filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\"
				+ "HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터\\day_data\\"
				+ "THTSKS010H00.dat";
		
		File k26_file = new File(k26_filePath);
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_file));
		
		String k26_readTxt;
		int k26_lineCnt = 0;
		int k26_escapeCondition = -1;
		StringBuffer k26_stringBuffer = new StringBuffer();
		long start = System.currentTimeMillis();
		while(true) {
			char[] k26_readCharArray = new char[1000];
			
			k26_escapeCondition = k26_bufferedReader.read(k26_readCharArray);
			
			if(k26_escapeCondition == -1) break;
			
			for(char k26_charData : k26_readCharArray) {
				if(k26_charData == '\n') {
					System.out.printf("[%s]***\n", k26_stringBuffer.toString());
					k26_stringBuffer.delete(0, k26_stringBuffer.length());
				} else {
					k26_stringBuffer.append(k26_charData);
				}
			}
			k26_lineCnt++;
		}
		System.out.printf("[%s]***\n", k26_stringBuffer.toString());
		long end = System.currentTimeMillis();
		System.out.println("total time taken = " + (end - start) + " ms");
		System.out.println("avg total time taken = " + (end - start)/k26_lineCnt + " ms");
		k26_bufferedReader.close();
	}
}