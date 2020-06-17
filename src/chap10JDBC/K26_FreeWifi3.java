package chap10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_FreeWifi3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection k26_connection = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33060"
				+ "/koposw26?serverTimezone=UTC", "root", "qortjf90");
		Statement k26_statement = k26_connection.createStatement();
		
		double k26_latitude = 37.3860521;
		double k26_longitude = 127.1214038;
		String k26_QueryTxt;
		k26_QueryTxt = String.format("select * from freewifi where " 
							   	+ "SQRT(POWER(latitude-%f,2) + POWER(longitude-%f,2)) = "
							   	+ "(select MIN(SQRT(POWER(latitude-%f,2) + POWER(longitude-%f,2))) from freewifi);"
							   	, k26_latitude, k26_longitude, k26_latitude, k26_longitude);
//		k26_QueryTxt = "select * from freewifi where service_provider='SKT'";
//		k26_QueryTxt = "select * from freewifi where inst_country='수원시'";
		
		ResultSet k26_resultSet = k26_statement.executeQuery(k26_QueryTxt);
		int k26_iCnt = 0;
		while(k26_resultSet.next()) {
			System.out.printf("*(%d)************************************\n", k26_iCnt++);
			System.out.printf("설치장소명        : %s\n", k26_resultSet.getString(1));
			System.out.printf("설치장소상세      : %s\n", k26_resultSet.getString(2));
			System.out.printf("설치시도명        : %s\n", k26_resultSet.getString(3));
			System.out.printf("설치시군구명      : %s\n", k26_resultSet.getString(4));
			System.out.printf("설치시설구분      : %s\n", k26_resultSet.getString(5));
			System.out.printf("서비스제공사명   : %s\n", k26_resultSet.getString(6));
			System.out.printf("와이파이SSID  : %s\n", k26_resultSet.getString(7));
			System.out.printf("설치년월           : %s\n", k26_resultSet.getString(8));
			System.out.printf("소재지도로명주소 : %s\n", k26_resultSet.getString(9));
			System.out.printf("소재지지번주소   : %s\n", k26_resultSet.getString(10));
			System.out.printf("관리기관명        : %s\n", k26_resultSet.getString(11));
			System.out.printf("관리기관전화번호 : %s\n", k26_resultSet.getString(12));
			System.out.printf("위도                : %s\n", k26_resultSet.getString(13));
			System.out.printf("경도                : %s\n", k26_resultSet.getString(14));
			System.out.printf("데이터기준일자   : %s\n", k26_resultSet.getString(15));
			System.out.printf("*****************************************\n");
		}
		k26_resultSet.close();
		k26_statement.close();
		k26_connection.close();
	}
}