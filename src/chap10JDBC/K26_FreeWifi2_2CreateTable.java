package chap10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_FreeWifi2_2CreateTable {

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
		
		/* Connection의 createStatement method로 database에 SQL statment를 보낼 Statement instance를 생성
		 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다. */
		Statement k26_statement = k26_connection.createStatement();
				
		/* Statement instance의 execute method의 argument로 "create table (..);" Query를 받아 
		 * SQL 문을 실행하고 Query 실행 결과를 boolean 형태로 반환 받는다.
		 * 일부 (흔하지 않은) 상황에서 단일 SQL 문은 여러 resultset 및/또는 update 횟수를 반환한다.
		 * 일반적으로 (1) 여러 결과를 반환 할 수있는 stored procedure를 실행하거나 
		 *         (2) 알 수없는 SQL 문자열을 동적으로 실행하지 않는 한, 이를 무시할 수 있다.
		 * 첫번째 결과가 ResultSet object인 경우는 true, 업데이트 횟수이거나 결과가 없는 경우 false를 반환한다.*/
		k26_statement.execute("create table freewifi("	// freewifi로 테이블 생성
				+ "  inst_place 		 varchar(29)"	// 설치장소명
				+ ", inst_place_detail 	 varchar(176)"	// 설치장소 상세
				+ ", inst_city 			 varchar(7)"	// 설치시도명
				+ ", inst_country 		 varchar(8)"	// 설치시군구명
				+ ", inst_place_flag 	 varchar(10)"	// 설치시설구분
				+ ", service_provider 	 varchar(22)"	// 서비스제공사명
				+ ", wifi_ssid 			 varchar(74)"	// 와이파이 SSID
				+ ", inst_date 			 varchar(15)"	// 설치년월 -> 정제할 것
				+ ", place_addr_road 	 varchar(44)"	// 소재지도로명주소
				+ ", place_addr_land 	 varchar(40)"	// 소재지지번주소
				+ ", manage_office 		 varchar(26)"	// 관리기관명
				+ ", manage_office_phone varchar(13)"	// 관리기관 전화번호
				+ ", latitude double"					// 위도
				+ ", longitude double"					// 경도
				+ ", write_date date);");				// 데이터기준일자
								 
		// Statement object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_statement.close();
				
		// Connection object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_connection.close();
	}
}
