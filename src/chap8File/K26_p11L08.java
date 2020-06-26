package chap8File;

import java.io.*;

public class K26_p11L08 {
	// 파일 정제
	public static void main(String[] args) throws IOException {
		// \ 은 특수문자이므로 \\ 두 개를 사용해야 한다.
		String readFilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터\\day_data\\"
				+ "THTSKS010H00.dat";
		File f = new File(readFilePath);
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String writeFilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\"
				+ "StockDailyPrice.csv";
		File f1 = new File(writeFilePath);
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		
		String readTxt;
		
		int cnt = 0; int wCnt = 0;
		while((readTxt = br.readLine()) != null) {
			StringBuffer s = new StringBuffer();
			String[] field = readTxt.split("%_%");
			
			if(field.length > 2 && field[2].replace("^", "").trim().substring(0,1).equals("A")) {
				s.append(field[0].replace("^", "").trim());
				for(int j = 1; j < field.length; j++) {
					s.append("." + field[j].replace("^", "").trim());
				}
				bw1.write(s.toString()); bw1.newLine();
				wCnt++;
				System.out.printf("write [%d][%d][%s]\n", cnt, wCnt, s.toString());
			}
			cnt++;
		}
		br.close();
		bw1.close();
		
		System.out.printf("Program End[%d][%d]records\n", cnt,wCnt);
	}
}
