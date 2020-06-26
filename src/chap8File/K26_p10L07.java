package chap8File;

import java.io.*;

public class K26_p10L07 {

	public static void main(String[] args) throws IOException {
		String filePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터\\day_data\\"
				+ "THTSKS010H00.dat";
		File f = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readTxt;
		int lineCnt = 0;
		int n = -1;
		StringBuffer s = new StringBuffer();
		while(true) {
			char[] ch = new char[1000];
			
			n = br.read(ch);
			
			if(n == -1) break;
			
			for(char c : ch) {
				if(c == '\n') {
					System.out.printf("[%s]***\n", s.toString());
					s.delete(0, s.length());
				} else {
					s.append(c);
				}
			}
			lineCnt++;
		}
		System.out.printf("[%s]***\n", s.toString());
		br.close();
	}
}