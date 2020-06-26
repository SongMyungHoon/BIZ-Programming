package chap8File;

import java.io.*;

public class K26_p6FIleReadWrites {
	static String filePath = "";
	
	public static void FileWrite() throws IOException {
		
		File f = new File(filePath);
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("안녕 파일");
		// 다음 줄로 넘겨주는 method, 대신 개행문자를 사용해도 된다.
		bw.newLine();
		bw.write("hello 헬로");
		// 다음 줄로 넘겨주는 method, 대신 개행문자를 사용해도 된다.
		bw.newLine();
		
		bw.close();
	}
	
	public static void FileRead() throws IOException {
		File f = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readTxt;
		
		while((readTxt = br.readLine()) != null) {
			System.out.printf("%s\n", readTxt);
		}
		
		br.close();
	}
	public static void main(String[] args) throws IOException {
		FileWrite();
		FileRead();
	}
}
