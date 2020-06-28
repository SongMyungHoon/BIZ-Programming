package chap8File;

import java.io.*;

public class K26_p12SamsungMax2015 {

	public static void main(String[] args) throws IOException {
		String k26_readFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\"
				+ "HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\"
				+ "A005930.csv";
		File k26_readFile = new File(k26_readFilePath);
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_readFile));
		
		String k26_readTxt;
		long start = System.currentTimeMillis();
		int k26_cnt = 0; int k26_wCnt = 0;
		
		int max = 0;
		while((k26_readTxt = k26_bufferedReader.readLine()) != null) {
//			System.out.println(k26_readTxt);
			String[] k26_field = k26_readTxt.split("\\.");
//			System.out.println(k26_field[1].substring(0,4));
			if(k26_field[1].substring(0, 4).equals("2015")) {
				if(max < Integer.parseInt(k26_field[3].trim())) {
					max = Integer.parseInt(k26_field[3].trim());
					k26_wCnt++;
					System.out.printf("count [%s][%d][%d][%s]\n",k26_field[1].trim(),k26_cnt, k26_wCnt, max);
				}
			}
			k26_cnt++;
		}
		long end = System.currentTimeMillis();
		System.out.println("total time taken = " + (end - start) + " ms");
		System.out.println("avg total time taken = " + (end - start)/k26_wCnt + " ms");
		k26_bufferedReader.close();
				
		System.out.printf("Program End[%d][%d]records\n", k26_cnt,k26_wCnt);
		System.out.printf("Maximum value of A005930 : %d", max);
	}

}
