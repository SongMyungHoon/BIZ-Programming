package chap8File;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class K26_p9DataRefine {

	public static void main(String[] args) throws IOException {
		String originFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
				+ "실습데이터\\전국무료와이파이표준데이터.csv";
		String sKTFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
				+ "Assignment\\FreeWifiData\\전국무료와이파이표준데이터_SKT.txt";
		String kTFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
				+ "Assignment\\FreeWifiData\\전국무료와이파이표준데이터_KT.txt";
		String lGUFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
				+ "Assignment\\FreeWifiData\\전국무료와이파이표준데이터_LGU.txt";
		File f = new File(originFilePath);
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		File f1 = new File(sKTFilePath);
		File f2 = new File(kTFilePath);
		File f3 = new File(lGUFilePath);
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));
		
		String readTxt;
		if((readTxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다\n");
			return;
		}
		
		bw1.write(readTxt);bw1.newLine();
		bw2.write(readTxt);bw2.newLine();
		bw3.write(readTxt);bw3.newLine();
		
		String[] fieldName = readTxt.split(",");
		String[] field;
		int LineCnt = 0;
		Set<String> serviceProvider = new HashSet<String>();
		while((readTxt = br.readLine()) != null) {
			// 읽은 String data 안에 쌍따옴표가 존재한다면
			if(readTxt.contains("\"")) {
				
				// 쌍따옴표를 기준으로 split
				String[] k26_strManField = readTxt.split("\"");
				
				// split한 결과 array의 length가 3 이상이라면
				if(k26_strManField.length >= 3) {
					
					/* 쌍따옴표 쌍의 수 = i 라 하면, String array.length = 1 + 2i
					 * maximum i = (String array.length - 1 / 2) = (int) String array.length/2
					 * 콤마 제거해야하는 array의 index = 1 + 2*i	*/
					for(int k26_i = 0; k26_i < k26_strManField.length/2; k26_i++) {
						
						/* index = 홀수 인 String array element의 콤마를 온점(dot)으로 변경
						 * 수정해야할 data가 많다면, searching algorithm을 적용해 
						 * 수정이 필요한(쌍따옴표가 존재하는) column만 replace하는 것을 고려해볼만 하다.	*/
						k26_strManField[1 + k26_i*2] = k26_strManField[1 + k26_i*2].replace(",", ".");
					}	// for loop end
				}	// if end

				// k26_readTxt 변수 초기화
				readTxt = "";
				
				for(int k26_i = 0; k26_i < k26_strManField.length; k26_i++) {
					// manipulation 후 String 재조립
					readTxt += k26_strManField[k26_i];
				}	// for loop end
			}	// if end
			
			// csv 파일이므로 ","를 구분자로 split한 결과는 각 feild의 값에 해당한다.
			field = readTxt.split(",");
			if(serviceProvider.contains(field[5].trim())) {
				
			}
			serviceProvider.add(field[5].trim());
			
			
			if(field[5].trim().contains("SK")) {
				System.out.printf("matches SK [%d번째 항목][%s]***\n", LineCnt,field[5]);
				bw1.write(readTxt);bw1.newLine();
			} else if(field[5].trim().contains("KT")) {
				System.out.printf("matches KT [%d번째 항목][%s]***\n", LineCnt,field[5]);
				bw2.write(readTxt);bw2.newLine();
			} else if(field[5].trim().contains("LGU+")) {
				System.out.printf("matches LGU+ [%d번째 항목][%s]***\n", LineCnt,field[5]);
				bw3.write(readTxt);bw3.newLine();
			} else if(field[5].trim().contains("LG U+")) {
				System.out.printf("matches LG U+ [%d번째 항목][%s]***\n", LineCnt,field[5]);
				field[5].replace("LG U+", "LGU+");
				bw3.write(readTxt);bw3.newLine();
			} else if(field[5].trim().contains("LG")) {
				System.out.printf("matches LG [%d번째 항목][%s]***\n", LineCnt,field[5]);
				field[5].replace("LG", "LGU+");
				bw3.write(readTxt);bw3.newLine();
			} else if(field[5].trim().equals("안산시")) {
			} else if(field[5].trim().equals("화성시")) {
			} else if(field[5].trim().equals("동탄1동")) {
			} else if(field[5].trim().equals("서대문구")) {
			} else if(field[5].trim().equals("경상남도 함양군")) {
			} else {
				System.out.printf("알 수 없는 통신사 [%d번째 항목][%s]***\n", LineCnt,field[5]);
				break;
			}
			LineCnt++;
		}
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();
	}
}
