package chap10JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_DBTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/* 동적 로딩 : 어떠한 클래스가 로딩될 지 모르기 때문에, Class 클래스의 forName() 메서드를 이용해
		 * 해당 클래스를 메모리에 로드하는 것
		 * Class.forName : 물리적인 클래스 파일명을 인자로 넣어주면 이에 해당하는 클래스를 반환해줌
		 * 클래스를 조사하기 위한 클래스
		 * Class.forName("com.mysql.cj.jdbc.Driver");
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
		 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다.
		 * 동일한 SQL 문이 여러 번 실행되면 PreparedStatement object를 사용하는 것이 더 효율적일 수 있다. */
		Statement k26_statement = k26_connection.createStatement();
		
		/* Statement instance의 executeQuery method의 argument로 "show databases;"를 받아 
		 * SQL : show databases; 를 실행하고 Query 실행 결과를 ResultSet 형태로 반환받는다.*/
		ResultSet k26_resultSet = k26_statement.executeQuery("show databases;");
		
		/* ResultSet의 next method는 cursor를 다음 record로 이동시키며 true를 반환한다. 
		 * 다음 record가 없는 경우 next method는 false를 반환한다. */
		while(k26_resultSet.next()) {
			/* show databases; 의 실행결과 return받은 resultSet 중 1번째 field(=column)의 데이터를 
			 * String으로 받아 표준출력으로 화면에 출력한다. */
			System.out.println("값 : " + k26_resultSet.getString(1));
		}
		// ResultSet object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_resultSet.close();
		// Statement object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_statement.close();
		// Connection object의 database 및 JDBC resource을 자동으로 닫을 때까지 기다리지 않고 즉시 해제
		k26_connection.close();
	}
}