package chap5RealPractice;

import java.io.*;
import java.util.*;

public class TestClass {
	public static void main(String[] args) throws UnsupportedEncodingException {
		List<String> record = new ArrayList<>();
        List<List<String>> recordList = new ArrayList<>();
 		String filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\HighTech"
 				+ "\\05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터_update\\"; 
 		
  		String fileName = "전국무료와이파이표준데이터.csv";
        try {
            File f = new File(filePath + fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String readTxt;
            double latitude = 37.3860521;
            double longitude = 127.1214038;
            int lineCnt = 0;
            
            StringBuilder stringBuilder = new StringBuilder();
            double distance = 0;
            
            if((readTxt = bufferedReader.readLine()) == null) {
                System.out.printf("빈 파일입니다\n");
            }
            String[] field_name = readTxt.split(",");
            while((readTxt = bufferedReader.readLine()) != null) {
                // 읽은 String data 안에 쌍따옴표가 존재한다면
                if(readTxt.contains("\"")) {
                    
                    // 쌍따옴표를 기준으로 split
                    String[] strManField = readTxt.split("\"");
                     
                    // split한 결과 array의 length가 3 이상이라면
                    if(strManField.length >= 3) {
                        
                        /* 쌍따옴표 쌍의 수 = i 라 하면, String array.length = 1 + 2i
                         * maximum i = (String array.length - 1 / 2) = (int) String array.length/2
                         * 콤마 제거해야하는 array의 index = 1 + 2*i
                         */
                        for(int i = 0; i < strManField.length/2; i++) {
                            
                            /* index = 홀수 인 String array element의 콤마를 온점(dot)으로 변경
                             * 수정해야할 data가 많다면, searching algorithm을 적용해 
                             * 수정이 필요한(쌍따옴표가 존재하는) column만 replace하는 것을 고려해볼만 하다.
                             */
                            strManField[1 + i*2] = strManField[1 + i*2].replace(",", ".");
                        }	// for end
                    }	// if end
                    // readTxt 변수 초기화
                    readTxt = "";
                    
                    for(int i = 0; i < strManField.length; i++) {
                        // manipulation 후 String 재조립
                        stringBuilder.append(strManField[i]);
                    }	// for end
                    readTxt = stringBuilder.toString();
                    stringBuilder.setLength(0);
                }	// if end

                String[] field = readTxt.split(",");
                
                distance = Math.sqrt(Math.pow(Double.parseDouble(field[12]) - latitude, 2) 
                           + Math.pow(Double.parseDouble(field[13]) - longitude, 2));
                String strLineCnt = Integer.toString(lineCnt);
                System.out.printf("**[%d번째 항목]********************<br>",lineCnt);
                System.out.printf(" %s : %s\n",field_name[9],field[9]); // 9번: 지번 주소
                System.out.printf(" %s : %s\n",field_name[12],field[12]); // 12번: 위도
                System.out.printf(" %s : %s\n",field_name[13],field[13]); // 13번: 경도
                
                System.out.printf(" 현재 지점과 거리 : %f\n", distance);
                System.out.printf("**********************************\n"); // 13번: 경도
                lineCnt++;
            }   // while loop end
            bufferedReader.close();
        } catch(IOException e) {
            System.out.println(e);
        }
	}
}