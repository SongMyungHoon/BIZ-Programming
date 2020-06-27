package chap8File;

import java.io.*;

public class K26_p6FIleReadWrites {
	static String k26_filePath = "";
	
	public static void k26_fileWrite() throws IOException {
		
		File k26_file = new File(k26_filePath);
		BufferedWriter k26_bufferedWriter = new BufferedWriter(new FileWriter(k26_file));
		
		k26_bufferedWriter.write("안녕 파일");
		// 다음 줄로 넘겨주는 method, 대신 개행문자를 사용해도 된다.
		k26_bufferedWriter.newLine();
		k26_bufferedWriter.write("hello 헬로");
		// 다음 줄로 넘겨주는 method, 대신 개행문자를 사용해도 된다.
		k26_bufferedWriter.newLine();
		
		k26_bufferedWriter.close();
	}
	
	public static void k26_fileRead() throws IOException {
		File k26_file = new File(k26_filePath);
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_file));
		
		String k26_readTxt;
		
		while((k26_readTxt = k26_bufferedReader.readLine()) != null) {
			System.out.printf("%s\n", k26_readTxt);
		}
		
		k26_bufferedReader.close();
	}
	public static void main(String[] args) throws IOException {
		k26_fileWrite();
		k26_fileRead();
	}
}
