package chap10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_FreeWifi2_4CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection k26_connection = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33060"
				+ "/koposw26?serverTimezone=UTC", "root", "qortjf90");
		Statement k26_statement = k26_connection.createStatement();
		
		k26_statement.execute("create table if not exists freewifi(" // freewifi로 테이블 생성
				+ "inst_place varchar(40)"				 	 		 // 설치장소명 (최대글자수: 29자)
				+ ", inst_place_detail varchar(200)"	 			 // 설치장소 상세 (최대글자수: 176자)
				+ ", inst_city varchar(10)"				 			 // 설치시도명 (최대글자수: 7자)
				+ ", inst_country varchar(20)"			 			 // 설치시군구명 (최대글자수: 8자)
				+ ", inst_place_flag varchar(20)"		 			 // 설치시설구분 (최대글자수: 10자)
				+ ", service_provider varchar(30)"		 			 // 서비스제공사명 (최대글자수: 22자)
				+ ", wifi_ssid varchar(100)"			 			 // 와이파이 SSID (최대글자수: 74자)
				+ ", inst_date varchar(15)"				 			 // 설치년월 -> 정제할 것 (최대글자수: 10자)
				+ ", place_addr_road varchar(50)"		 			 // 소재지도로명주소 (최대글자수: 44자)
				+ ", place_addr_land varchar(50)"		 			 // 소재지지번주소 (최대글자수: 40자)
				+ ", manage_office varchar(50)"			 			 // 관리기관명 (최대글자수: 26자)
				+ ", manage_office_phone varchar(20)"	 			 // 관리기관 전화번호 (최대글자수: 13자)
				+ ", latitude double"					 			 // 위도
				+ ", longitude double"					 			 // 경도
				+ ", write_date date"					 			 // 데이터기준일자
				+ ", PRIMARY KEY(inst_place, inst_place_detail, inst_city, inst_country"
				+ ", inst_place_flag, service_provider, wifi_ssid, inst_date"
				+ ", place_addr_road, place_addr_land, manage_office, manage_office_phone"
				+ ", latitude, longitude, write_date));");				 

		k26_statement.close();
		k26_connection.close();
	}
}