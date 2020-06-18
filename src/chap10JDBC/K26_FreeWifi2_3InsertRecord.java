package chap10JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_FreeWifi2_3InsertRecord {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		/* Class.forName("com.mysql.cj.jdbc.Driver");
		 * -> mysql의 jdbc Driver가 존재하는지 확인 */
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		/* DriverManager 클래스의 getConnection 메서드로 VM의 Linux에 앞서 forwarding한 33060 포트로 접근해
		 * mysql을 구동하고 koposw26 DB에 접근한 후 해당 데이터를 Connection instance에 저장한다.
		 * The server time zone value 'KST' is unrecognized or represents more than one time zone.
		 * 이라는 SQLException이 발생하므로 serverTimezone=UTC 옵션을 부여하여 SQLException 제거
		 * mysql 계정 : root, 패스워드 : qortjf90*/
		Connection k26_connection = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33060"
				+ "/koposw26?serverTimezone=UTC", "root", "qortjf90");
		
		/* Connection의 createStatement method로 database에 SQL statement를 보낼 Statement instance를 생성
		 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다. */
		Statement k26_statement = k26_connection.createStatement();
		
		// 읽어들일 파일이 위치한 경로
		String k26_filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터_update\\"; 
		
		// 읽어들일 파일의 이름 (.csv)
		String k26_fileName = "전국무료와이파이표준데이터.csv";
		
		// 전국무료와이파이표준데이터.csv 파일을 File 클래스 생성자의 argument로 받아 File instance 생성
		File k26_file = new File(k26_filePath + k26_fileName);
		
		// 앞에서 생성한 File instance를 FileReader Class의 
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_file));
		
		// 파일 내용을 읽어서 저장할 String 변수 선언
		String k26_readTxt;
		
		/* 한줄을 먼저 읽어야 --> 이 줄은 DB와는 별 상관 없음
		 * 첫번째 줄은 헤더 : 각 field가 무엇을 의미하는지 적어놓은 String
		 * 첫번째 줄을 읽은 결과 return 값이 null인 경우 : 파일 내용이 비어있다는 의미 */
		if((k26_readTxt = k26_bufferedReader.readLine()) == null) {
			
			// 빈 파일이라는 것을 console에 표준출력하고
			System.out.println("빈 파일입니다");
			
			// 프로그램 종료
			return;
		}
		
		// csv 파일이므로 ","를 구분자로 하여 읽어들인 헤더를 각각의 field의 name으로 저장(String array 형태로)
		String[] k26_field_name = k26_readTxt.split(",");
		
		// 읽어들인 String Line의 수를 Count하기 위한 int 변수 선언 및 초기화
		int k26_lineCnt = 0;
		
		// 파일을 line 단위로 읽은 결과과 null이 아니라면 while 반복
		while ((k26_readTxt = k26_bufferedReader.readLine()) != null) {
			
			// 읽은 String data 안에 쌍따옴표가 존재한다면
			if(k26_readTxt.contains("\"")) {
				
				// 쌍따옴표를 기준으로 split
				String[] k26_strManField = k26_readTxt.split("\"");
				
				// split한 결과 array의 length가 3 이상이라면
				if(k26_strManField.length >= 3) {
					
					/* 쌍따옴표 쌍의 수 = i 라 하면, String array.length = 1 + 2i
					 * maximum i = (String array.length - 1 / 2) = (int) String array.length/2
					 * 콤마 제거해야하는 array의 index = 1 + 2*i
					 */
					for(int k26_i = 0; k26_i < k26_strManField.length/2; k26_i++) {
						
						/* index = 홀수 인 String array element의 콤마를 온점(dot)으로 변경
						 * 수정해야할 data가 많다면, searching algorithm을 적용해 
						 * 수정이 필요한(쌍따옴표가 존재하는) column만 replace하는 것을 고려해볼만 하다.
						 */
						k26_strManField[1 + k26_i*2] = k26_strManField[1 + k26_i*2].replace(",", ".");
					}
				} 

				// k26_readTxt 변수 초기화
				k26_readTxt = "";
				
				for(int k26_i = 0; k26_i < k26_strManField.length; k26_i++) {
					// manipulation 후 String 재조립
					k26_readTxt += k26_strManField[k26_i];
				}
			}
			
			// csv 파일이므로 ","를 구분자로 split한 결과는 각 feild의 값에 해당한다.
			String[] k26_field = k26_readTxt.split(",");
			
			// Query를 저정할 String 변수 선언
			String k26_QueryTxt;
			
			/* "insert into freewifi (...) values (...);" Query를 String 변수에 저장
			 * 각 column에 앞에서 읽어들인 csv 파일의 데이터를 서식 지정자 형태로 지정 */
			k26_QueryTxt = String.format("insert ignore into freewifi ("
					+ "inst_place, inst_place_detail, inst_city, inst_country, inst_place_flag,"
					+ "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land,"
					+ "manage_office, manage_office_phone, latitude, longitude, write_date) "
					+ "values ("
					+ "'%s', '%s', '%s', '%s', '%s',"
					+ "'%s', '%s', '%s', '%s', '%s',"
					+ "'%s', '%s', %s, %s, '%s');",	// latitude와 longitude != varchar(== double)
					// varchar는 query에 혿따옴표가 들어가야하고 double은 홑따옴표가 빠져야한다.
					
					k26_field[0], k26_field[1], k26_field[2], k26_field[3], k26_field[4],
					k26_field[5], k26_field[6], k26_field[7], k26_field[8], k26_field[9],
					k26_field[10], k26_field[11], k26_field[12], k26_field[13], k26_field[14]);
			
			/* Statement instance의 execute method의 argument로 
			 * "insert into freewifi (...) values (...);" Query를 받아 SQL 문을 실행하고
			 * Query 실행 결과를 boolean 형태로 반환 받는다.
			 * 일부 (흔하지 않은) 상황에서 단일 SQL 문은 여러 resultset 및/또는 update 횟수를 반환한다.
			 * 일반적으로 (1) 여러 결과를 반환 할 수있는 stored procedure를 실행하거나 
			 *         (2) 알 수없는 SQL 문자열을 동적으로 실행하지 않는 한, 이를 무시할 수 있다.
			 * 첫번째 결과가 ResultSet object인 경우는 true, 업데이트 횟수이거나 결과가 없는 경우 false를 반환한다.*/
			k26_statement.execute(k26_QueryTxt);
			
			// count 수와 Query를 console 화면에 표준 출력한다
			System.out.printf("%d번째 항목 Insert OK [%s]\n", k26_lineCnt, k26_QueryTxt);
			
			// count를 1 증가
			k26_lineCnt++;
		}
		
		/* 스트림을 닫고 이와 관련된 모든 시스템 리소스를 해제한다.
		 * 스트림이 닫히면 추가 read (), ready (), mark (), reset () 또는 skip () 호출에서 IOException이 발생한다
		 * 이전에 닫힌 스트림은 다시 닫아도 효과가 없다. */
		k26_bufferedReader.close();
		
		// Statement object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_statement.close();
		
		// Connection object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_connection.close();
	}
}