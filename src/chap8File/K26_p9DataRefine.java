package chap8File;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class K26_p9DataRefine {

	public static void main(String[] args) throws IOException {
		
//		String k26_originFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
//				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
//				+ "실습데이터\\전국무료와이파이표준데이터.csv";
		
		String k26_originFilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터\\전국무료와이파이표준데이터.csv";
		
//		k26_serviceProviderExtraction(k26_originFilePath);
		String k26_SKTfilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\FreeWifiData\\"
				+ "전국무료와이파이표준데이터_SKT.txt";
		String k26_KTfilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\FreeWifiData\\"
				+ "전국무료와이파이표준데이터_KT.txt";
		String k26_LGUfilePath = "E:\\OneDrive\\Documents\\Developer\\HighTech\\"
				+ "05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\FreeWifiData\\"
				+ "전국무료와이파이표준데이터_LGU.txt";
//		String k26_SKTfilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
//				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
//				+ "Assignment\\FreeWifiData\\전국무료와이파이표준데이터_SKT.txt";
//		String k26_KTfilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
//				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
//				+ "Assignment\\FreeWifiData\\전국무료와이파이표준데이터_KT.txt";
//		String k26_LGUfilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\"
//				+ "Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\"
//				+ "Assignment\\FreeWifiData\\전국무료와이파이표준데이터_LGU.txt";
		// originalFilePath에 위치한 파일(전국무료와이파이표준데이터.csv)을 다루기 위한 File class instance 선언
		File k26_file = new File(k26_originFilePath);
		/* 문자 입력 stream에서 문자를 버퍼링하여 문자, 배열 및 행을 효율적으로 
		 * 읽을 수 잇도록 문자를 버퍼링하는 BufferedReader instance 선언 */
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_file));
		// raw file 내용 중 service provider에 SKT(유사 글자 포함)가 포함된 내용들을 저장할 파일을 위한 File instance
		File k26_sktFile = new File(k26_SKTfilePath);
		// raw file 내용 중 service provider에 KT(유사 글자 포함)가 포함된 내용들을 저장할 파일을 위한 File instance
		File k26_ktFile = new File(k26_KTfilePath);
		// raw file 내용 중 service provider에 LGU+(유사 글자 포함)가 포함된 내용들을 저장할 파일을 위한 File instance
		File k26_lguFile = new File(k26_LGUfilePath);
		/* service provider에 SKT가 포함된 경우, 해당 record를 따로 구별된 file에 
		 * 단일 문자, 배열 및 문자열을 효율적으로 기록할 수 있도록 문자를 버퍼링하여 
		 * 문자 출력 stream에 text 저장할 BufferedWriter instance 선언 */
		BufferedWriter k26_sktBufferedWriter = new BufferedWriter(new FileWriter(k26_sktFile));
		/* service provider에 SKT가 포함된 경우, 해당 record를 따로 구별된 file에 
		 * 단일 문자, 배열 및 문자열을 효율적으로 기록할 수 있도록 문자를 버퍼링하여 
		 * 문자 출력 stream에 text 저장할 BufferedWriter instance 선언 */
		BufferedWriter k26_ktBufferedWriter = new BufferedWriter(new FileWriter(k26_ktFile));
		/* service provider에 SKT가 포함된 경우, 해당 record를 따로 구별된 file에 
		 * 단일 문자, 배열 및 문자열을 효율적으로 기록할 수 있도록 문자를 버퍼링하여 
		 * 문자 출력 stream에 text 저장할 BufferedWriter instance 선언 */
		BufferedWriter k26_lguBUfferedWriter = new BufferedWriter(new FileWriter(k26_lguFile));
		// 읽어들인 파일 내용을 기록할 String 변수 선언
		String k26_readTxt;
		// 파일에서 읽어 readTxt에 저장한 String이 null인 경우
		if((k26_readTxt = k26_bufferedReader.readLine()) == null) {
			// 빈 파일임을 알리는 문구 출력
			System.out.printf("빈 파일입니다\n");
			// method 종료
			return;
		}
		// Header의 내용을 SKT이 포함된 내용이 기록될 파일에 적고 줄 바꿈 수행
		k26_sktBufferedWriter.write(k26_readTxt);k26_sktBufferedWriter.newLine();
		// Header의 내용을 KT이 포함된 내용이 기록될 파일에 적고 줄 바꿈 수행
		k26_ktBufferedWriter.write(k26_readTxt);k26_ktBufferedWriter.newLine();
		// Header의 내용을 LGU+이 포함된 내용이 기록될 파일에 적고 줄 바꿈 수행
		k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
		
		String[] k26_fieldName = k26_readTxt.split(",");
		String[] k26_field;
		String serviceProvider = "";
		int k26_lineCnt = 0;
		
		while((k26_readTxt = k26_bufferedReader.readLine()) != null) {
			// 읽은 String data 안에 쌍따옴표가 존재한다면
			if(k26_readTxt.contains("\"")) {
				k26_readTxt = k26_commaEliminationInDoubleQuote(k26_readTxt);
			}	// if end
			
			// csv 파일이므로 ","를 구분자로 split한 결과는 각 feild의 값에 해당한다.
			k26_field = k26_readTxt.split(",");
			boolean k26_unknown = true;			
			serviceProvider = k26_field[5].trim();
			if(serviceProvider.contains("SKT")) {
				System.out.printf("matches SKT [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
				k26_sktBufferedWriter.write(k26_readTxt);k26_sktBufferedWriter.newLine();
				k26_unknown = false;
			} else if(serviceProvider.contains("SK")) {
				if(serviceProvider.contains("㈜SK텔레콤")) {
					System.out.printf("matches ㈜SK텔레콤 [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("㈜SK텔레콤", "SKT");
					k26_sktBufferedWriter.write(k26_readTxt);k26_sktBufferedWriter.newLine();
				} else if(serviceProvider.contains("SK텔레콤")) {
					System.out.printf("matches SK텔레콤 [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("SK텔레콤", "SKT");
					k26_sktBufferedWriter.write(k26_readTxt);k26_sktBufferedWriter.newLine();
				} else {
					System.out.printf("matches SK [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("SK", "SKT");
					k26_sktBufferedWriter.write(k26_readTxt);k26_sktBufferedWriter.newLine();
				}
				k26_unknown = false;
			} else if(serviceProvider.contains("sk텔레콤")) {
				System.out.printf("matches sk텔레콤 [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
				k26_readTxt = serviceProvider.replace("sk텔레콤", "SKT");
				k26_sktBufferedWriter.write(k26_readTxt);k26_sktBufferedWriter.newLine();
				k26_unknown = false;
			}
			
			if(serviceProvider.contains("KT")) {	
				if(k26_field[5].trim().contains("㈜KT")) {
					System.out.printf("matches ㈜KT [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("㈜KT", "KT");
					k26_ktBufferedWriter.write(k26_readTxt);k26_ktBufferedWriter.newLine();
				} else if(serviceProvider.contains("KT올레")) {
					System.out.printf("matches KT올레 [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("KT올레", "KT");
					k26_ktBufferedWriter.write(k26_readTxt);k26_ktBufferedWriter.newLine();
				} else if(k26_stringCompare(serviceProvider, "KT")) {
					System.out.printf("matches KT [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_ktBufferedWriter.write(k26_readTxt);k26_ktBufferedWriter.newLine();
				}			
				k26_unknown = false;
			} else if(serviceProvider.contains("㈜케이티")) {
				System.out.printf("matches ㈜케이티 [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
				k26_readTxt = serviceProvider.replace("㈜케이티", "KT");
				k26_ktBufferedWriter.write(k26_readTxt);k26_ktBufferedWriter.newLine();
				k26_unknown = false;
			}
			
			if(serviceProvider.contains("LGU+")) {
				System.out.printf("matches LGU+ [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
				k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				k26_unknown = false;
			} else if(serviceProvider.contains("LG")) {
				if(serviceProvider.contains("LGT")) {
					System.out.printf("matches LGT [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("LGT", "LGU+");
					k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				} else if(serviceProvider.contains("LGU")) {
					System.out.printf("matches LGU [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("LGU", "LGU+");
					k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				} else if(serviceProvider.contains("LG U +")) {
					System.out.printf("matches LG U + [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("LG U +", "LGU+");
					k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				} else if(serviceProvider.contains("LG U+")) {
					System.out.printf("matches LG U+ [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("LG U+", "LGU+");
					k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				} else {				
					System.out.printf("matches LG [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
					k26_readTxt = serviceProvider.replace("LG", "LGU+");
					k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				}
				k26_unknown = false;
			} else if(serviceProvider.contains("Lgu+")) {
				System.out.printf("matches Lgu+ [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
				k26_readTxt = serviceProvider.replace("Lgu+", "LGU+");
				k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				k26_unknown = false;
			} else if(serviceProvider.contains("(주)엘지유플러스")) {
				System.out.printf("matches (주)엘지유플러스 [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
				k26_readTxt = serviceProvider.replace("(주)엘지유플러스", "LGU+");
				k26_lguBUfferedWriter.write(k26_readTxt);k26_lguBUfferedWriter.newLine();
				k26_unknown = false;
			} 
			if(k26_unknown) {
				System.out.printf("알 수 없는 통신사 [%d번째 항목][%s]***\n", k26_lineCnt,serviceProvider);
			}
			k26_lineCnt++;
		}
		k26_bufferedReader.close();
		k26_sktBufferedWriter.close();
		k26_ktBufferedWriter.close();
		k26_lguBUfferedWriter.close();
	}
	
	public static Set<String> k26_serviceProviderExtraction(String k26_originFilePath)
															throws IOException {
		Set<String> k26_resultSet = new HashSet<>();
		
		File k26_file = new File(k26_originFilePath);
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_file));
		String k26_readTxt;
		
		if((k26_readTxt = k26_bufferedReader.readLine()) == null) {
			System.out.printf("빈 파일입니다\n");
			return null;
		}
		String[] k26_field;
		
		while((k26_readTxt = k26_bufferedReader.readLine()) != null) {
			// 읽은 String data 안에 쌍따옴표가 존재한다면
			if(k26_readTxt.contains("\"")) {
				k26_readTxt = k26_commaEliminationInDoubleQuote(k26_readTxt);
			}	// if end
			
			// csv 파일이므로 ","를 구분자로 split한 결과는 각 feild의 값에 해당한다.
			k26_field = k26_readTxt.split(",");
			if(!k26_field[5].trim().isBlank()) {	
				k26_resultSet.add(k26_field[5].trim());
			}
		}
		k26_bufferedReader.close();
		
		k26_resultSet.forEach(System.out::println);
		System.out.printf("Service Provider Set : %d\n", k26_resultSet.size());
		return k26_resultSet;
	}
	
	public static String k26_commaEliminationInDoubleQuote(String k26_targetStr) {
		// 쌍따옴표를 기준으로 split
		String[] k26_strManField = k26_targetStr.split("\"");
		String k26_returnStr = "";
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
		
		for(int k26_i = 0; k26_i < k26_strManField.length; k26_i++) {
			// manipulation 후 String 재조립
			k26_returnStr += k26_strManField[k26_i];
		}	// for loop end
		return k26_returnStr;
	}	// k26_commaEliminationInDoubleQuote method end
	public static boolean k26_stringCompare(String targetString, String comparedString) {
		for(int i = 0; i < targetString.length(); i++) {			
			if(targetString.charAt(i) == comparedString.charAt(0)) {
				if(i != 0) {
					if(targetString.charAt(i - 1) != 'S'
							&&targetString.charAt(i + 1) == 'T') {
						return true;
					} else {
						return false;
					}
				} else {
					if(targetString.charAt(i + 1) == 'T') {
						return true;
					} else {
						return false;
					}	// if - else end
				}	// if - else end
			}	// if - else end
		}	// for loop end
		return false;
	}	// k26_stringCompare method end
}