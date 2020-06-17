package chap10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_SelectExam {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/* Class.forName("com.mysql.cj.jdbc.Driver");
		 * -> mysql의 jdbc Driver가 존재하는지 확인 */
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		/* DriverManager 클래스의 getConnection 메서드로 VM의 Linux에 앞서 forwarding한 33060 포트로 접근해
		 * mysql을 구동하고 koposw26 DB에 접근한 후 해당 데이터를 Connection instance에 저장한다.
		 * The server time zone value 'KST' is unrecognized or represents more than one time zone.
		 * 이라는 SQLException이 발생하므로 serverTimezone=UTC 옵션을 부여하여 SQ:Exception 제거
		 * mysql 계정 : root, 패스워드 : qortjf90*/
		Connection k26_connection = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33060"
				+ "/koposw26?serverTimezone=UTC", "root", "qortjf90");
		
		/* Connection의 createStatement method로 database에 SQL statment를 보낼 Statement instance를 생성
		 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다. */
		Statement k26_statement = k26_connection.createStatement();
		
		/* Statement instance의 executeQuery method의 argument로 "select * from examtable;"를 받아 
		 * SQL : select * from examtable; 를 실행하고 Query 실행 결과를 ResultSet 형태로 반환받는다.*/
		ResultSet k26_resultSet = k26_statement.executeQuery("select * from examtable;");
		
		// 이름, 학번, 국어, 영어, 수학 을 표준 출력으로 console에 출력한다
		System.out.println("  이름          학번       국어        영어          수학");
		
		/* ResultSet의 next method는 cursor를 다음 record로 이동시키며 true를 반환한다. 
		 * 다음 record가 없는 경우 next method는 false를 반환한다. */
		while(k26_resultSet.next()) {

			// select * from examtable;의 실행 결과를 return 받은 resultSet 중 
			// 1번째 field(=column)의 값은 String으로,
			System.out.printf("%4s	%6d	%3d	%3d	%3d	\n",	// 2~5번째  field의 값은 int로 받아
					k26_resultSet.getString(1)  // 표준출력으로 console 화면에 출력한다.
					, k26_resultSet.getInt(2)   // 데이터 출력의 format
					, k26_resultSet.getInt(3)	// %4s : %s의 출력 폭 6칸 지정 (출력 문자 포함)   
					, k26_resultSet.getInt(4)	// %6d : %d의 출력 폭 6칸 지정 (출력 숫자 포함)	
					, k26_resultSet.getInt(5));	// %3d : %d의 출력 폭 3칸 지정 (출력 숫자 포함)
		}
		// ResultSet object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_resultSet.close();
	
		// Statement object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_statement.close();
		
		// Connection object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_connection.close();
	}
}
