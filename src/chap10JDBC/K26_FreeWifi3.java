package chap10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_FreeWifi3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
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
		
		// 검색할 위도 값 k26_latitude 변수에 저장
		double k26_latitude = 37.3860521;
		// 검색할 경도 값 k26_longitude 변수에 저장
		double k26_longitude = 127.1214038;
		
		// Query를 저정할 String 변수 선언
		String k26_QueryTxt;
		
		// k26_latitude, k26_longitude 값에서 가장 가까운 위치에 존재하는 record 조회
//		k26_QueryTxt = String.format("select * from freewifi where " 
//							// where square root (위도 제곱 + 경도 제곱)
//							// = MIN(square root (위도 제곱 + 경도 제곱)) (subquery)
//							// 인 record의 data 출력 
//							+ "SQRT(POWER(latitude-%f,2) + POWER(longitude-%f,2)) = "
//							+ "(select MIN(SQRT(POWER(latitude-%f,2) + POWER(longitude-%f,2))) from freewifi);"
//							, k26_latitude, k26_longitude, k26_latitude, k26_longitude);
		// 전부 출력하기
//		k26_QueryTxt = "select * from freewifi;";
		
		// 서비스 공급자가 SKT 인 경우의 data를 조회하기 위한 Query
//		k26_QueryTxt = "select * from freewifi where service_provider='SKT'";
		
		// 설치된 도시가 수원시 인 경우의 data를 조회하기 위한 Query
		k26_QueryTxt = "select * from freewifi where inst_country='수원시'";
		
		/* Statement instance의 executeQuery method의 argument로 k26_QueryTxt 를 받아 
		 * Query를 실행하고 결과를 ResultSet 형태로 반환받는다.*/ 
		ResultSet k26_resultSet = k26_statement.executeQuery(k26_QueryTxt);
		// query 실행 결과 반환 받은 record count를 위한 int형 변수 선언
		int k26_iCnt = 0;
		while(k26_resultSet.next()) {
			// query 실행 결과 반환 받은 resultSet 내용 출력
			System.out.printf("*(%d)************************************\n", k26_iCnt++);
			System.out.printf("설치장소명         : %s\n", k26_resultSet.getString(1));
			System.out.printf("설치장소상세      : %s\n", k26_resultSet.getString(2));
			System.out.printf("설치시도명         : %s\n", k26_resultSet.getString(3));
			System.out.printf("설치시군구명      : %s\n", k26_resultSet.getString(4));
			System.out.printf("설치시설구분      : %s\n", k26_resultSet.getString(5));
			System.out.printf("서비스제공사명    : %s\n", k26_resultSet.getString(6));
			System.out.printf("와이파이SSID    : %s\n", k26_resultSet.getString(7));
			System.out.printf("설치년월            : %s\n", k26_resultSet.getString(8));
			System.out.printf("소재지도로명주소 : %s\n", k26_resultSet.getString(9));
			System.out.printf("소재지지번주소    : %s\n", k26_resultSet.getString(10));
			System.out.printf("관리기관명         : %s\n", k26_resultSet.getString(11));
			System.out.printf("관리기관전화번호 : %s\n", k26_resultSet.getString(12));
			System.out.printf("위도                 : %s\n", k26_resultSet.getString(13));
			System.out.printf("경도                 : %s\n", k26_resultSet.getString(14));
			System.out.printf("데이터기준일자   : %s\n", k26_resultSet.getString(15));
			System.out.printf("*****************************************\n");
		}
		// ResultSet object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_resultSet.close();
		// Statement object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_statement.close();
		// Connection object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_connection.close();
	}	// main method end
}	// K26_FreeWifi3 Class end