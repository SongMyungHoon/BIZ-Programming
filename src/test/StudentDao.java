package test;

import java.sql.*;
import java.util.List;

public class StudentDao {
	private static Connection connection;
	private StudentDao() {}
	private static class LazyHolder {
		private static final StudentDao INSTANCE = new StudentDao();
	}
	
	public static StudentDao getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	public static void dbConnect() {
		if(connection == null) {
			final String id = "koposw26";
			final String password = "qortjf90";
			final String accessURL = "jdbc:mysql://192.168.23.110:33060/"
					+ "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul"
					+ "&allowPublicKeyRetrieval=true&useSSL=false";
			final String dbName = "koposw26";
			
			try {
				connection = DriverManager.getConnection(accessURL, id, password);
				connection.setCatalog(dbName);
			} catch(SQLException exception) {
				exception.printStackTrace();
			}
		}
	}
	
	public static void connectTest() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rset = stmt.executeQuery("show databases;");
			while(rset.next()) {
				System.out.println(rset.getString(1));
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void connectionClose() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//	// C
//	public void create(Student student) {
//		
//	}
//	
//	// R
//	public Student selectOne(int studentId) {
//		return null;
//	}
//	
//	public List<Student> selectAll() {
//		return null;
//	}
//	
//	public List<Student> selectAll(int cntCount, int startNum) {
//		return null;
//	}
//	
//	// U
//	public void update(Student student) {
//		
//	}
//	
//	// D
//	public void delete(int studentId) {
//		
//	}
}
