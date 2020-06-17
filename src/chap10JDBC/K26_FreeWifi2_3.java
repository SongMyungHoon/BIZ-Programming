package chap10JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class K26_FreeWifi2_3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection k26_connection = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33060"
				+ "/koposw26?serverTimezone=UTC", "root", "qortjf90");
		Statement k26_statement = k26_connection.createStatement();
		
		String k26_filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\실습데이터_update\\"; 
		String k26_fileName = "전국무료와이파이표준데이터.csv";
		File k26_file = new File(k26_filePath + k26_fileName);
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_file));
		
		String k26_readTxt;
		
		// 한줄을 먼저 읽어야 --> 이 줄은 DB와는 별 상관 없음
		if((k26_readTxt = k26_bufferedReader.readLine()) == null) {
			System.out.println("빈 파일입니다");
			return;
		}
		String[] k26_field_name = k26_readTxt.split(",");
		
		int k26_lineCnt = 0;
		
		while ((k26_readTxt = k26_bufferedReader.readLine()) != null) {
			if(k26_readTxt.contains("\"")) {
				String[] k26_strManField = k26_readTxt.split("\"");
				if(k26_strManField.length >= 3) {
					for(int k26_i = 0; k26_i < k26_strManField.length/2; k26_i++) {
						k26_strManField[1 + k26_i*2] = k26_strManField[1 + k26_i*2].replace(",", ".");
					}
				} else {
					System.out.println(k26_strManField.length);
				}
				k26_readTxt = "";
				for(int k26_i = 0; k26_i < k26_strManField.length; k26_i++) {
					k26_readTxt += k26_strManField[k26_i];
				}
			}
			String[] k26_field = k26_readTxt.split(",");
			String k26_QueryTxt;
			k26_QueryTxt = String.format("insert ignore into freewifi ("
					+ "inst_place, inst_place_detail, inst_city, inst_country, inst_place_flag,"
					+ "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land,"
					+ "manage_office, manage_office_phone, latitude, longitude, write_date) "
					+ "values ("
					+ "'%s', '%s', '%s', '%s', '%s',"
					+ "'%s', '%s', '%s', '%s', '%s',"
					+ "'%s', '%s', %s, %s, '%s');",
					k26_field[0], k26_field[1], k26_field[2], k26_field[3], k26_field[4],
					k26_field[5], k26_field[6], k26_field[7], k26_field[8], k26_field[9],
					k26_field[10], k26_field[11], k26_field[12], k26_field[13], k26_field[14]);
			k26_statement.execute(k26_QueryTxt);
			
			System.out.printf("%d번째 항목 Insert OK [%s]\n", k26_lineCnt, k26_QueryTxt);
			
			k26_lineCnt++;
		}
		k26_bufferedReader.close();
		k26_statement.close();
		k26_connection.close();
	}
}