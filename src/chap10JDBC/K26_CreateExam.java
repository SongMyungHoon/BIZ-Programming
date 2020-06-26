package chap10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_CreateExam {
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
		
		/* Statement instance의 execute method의 argument로 "create table ... " 문을 받아 
		 * SQL 문을 실행하고 Query 실행 결과를 boolean 형태로 반환 받는다.
		 * 일부 (흔하지 않은) 상황에서 단일 SQL 문은 여러 resultset 및/또는 update 횟수를 반환한다.
		 * 일반적으로 (1) 여러 결과를 반환 할 수있는 stored procedure를 실행하거나 
		 *         (2) 알 수없는 SQL 문자열을 동적으로 실행하지 않는 한, 이를 무시할 수 있다.
		 * 첫번째 결과가 ResultSet object인 경우는 true, 업데이트 횟수이거나 결과가 없는 경우 false를 반환한다.*/
		k26_statement.execute("create table if not exists examtable("
					 + "name varchar(20)"
					 + ", studentid int not null primary key"
					 + ", kor int"
					 + ", eng int"
					 + ", mat int);");
		
		// Statement object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_statement.close();
		
		// Connection object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_connection.close();
	}
}