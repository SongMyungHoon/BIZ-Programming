package chap8File;

import java.io.*;

public class K26_p11L08 {
	// 파일 정제
	public static void main(String[] args) throws IOException {
		// \ 은 특수문자이므로 \\ 두 개를 사용해야 한다.
		String k26_readFilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터\\day_data\\"
				+ "THTSKS010H00.dat";
		File k26_readFile = new File(k26_readFilePath);
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_readFile));
		
		String k26_writeFilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\"
				+ "StockDailyPrice.csv";
		File k26_writeFile = new File(k26_writeFilePath);
		BufferedWriter k26_bufferedWriter = new BufferedWriter(new FileWriter(k26_writeFile));
		
		String k26_readTxt;
		
		int k26_cnt = 0; int k26_wCnt = 0;
		while((k26_readTxt = k26_bufferedReader.readLine()) != null) {
			StringBuffer k26_stringBuffer = new StringBuffer();
			String[] k26_field = k26_readTxt.split("%_%");
			
			if(k26_field.length > 2 && k26_field[2].replace("^", "").trim().substring(0,1).equals("A")) {
				k26_stringBuffer.append(k26_field[0].replace("^", "").trim());
				for(int k26_j = 1; k26_j < k26_field.length; k26_j++) {
					k26_stringBuffer.append("." + k26_field[k26_j].replace("^", "").trim());
				}
				k26_bufferedWriter.write(k26_stringBuffer.toString()); k26_bufferedWriter.newLine();
				k26_wCnt++;
				System.out.printf("write [%d][%d][%s]\n", k26_cnt, k26_wCnt, k26_stringBuffer.toString());
			}
			k26_cnt++;
		}
		k26_bufferedReader.close();
		k26_bufferedWriter.close();
		
		System.out.printf("Program End[%d][%d]records\n", k26_cnt,k26_wCnt);
	}
}
