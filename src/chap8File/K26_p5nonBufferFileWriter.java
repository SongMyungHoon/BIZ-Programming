package chap8File;

import java.io.*;

public class K26_p5nonBufferFileWriter {

	public static void main(String[] args) {
		try {
			String filePath = "C:\\Users\\MHSong\\OneDrive\\Documents"
					+ "\\Developer\\HighTech\\05 Enterprise Computing"
					+ "\\BIZ프로그래밍기초\\Assignment\\Mytest.txt";
			File f = new File(filePath);
			FileWriter fw = new FileWriter(f);
			
			fw.write("안녕 파일\n");
			fw.write("hello 헬로\n");
			
			fw.close();
			
			FileReader fr = new FileReader(f);
			
			int n = -1;
			char[] ch;
			
			while(true) {
				ch = new char[100];
				n = fr.read(ch);
				
				if(n == -1) break;
				
				for(int i = 0; i < n; i++) {
				// for(char c : ch) {
					System.out.printf("%c", ch[i]);
				}
			}
			
			fr.close();
			
			System.out.printf("\nFILE READ END");
		} catch(Exception e) {
			System.out.printf("나 에러[%s]\n", e);
		}
	}
}
