package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class contentDAO<T, S> {
	public S connection(T t, Template<T, S, Connection> template) {
		S s;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.33:10001/board?characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false"
					, "root", "1234");
			s = (S) template.func(con, t);
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return s;
	}
	
	public S searchData(T t) {
		return connection(t, (con, t1)->{
			int i = (int) t1;
			
			String queryString = "SELECT * FROM candidate";
			PreparedStatement pstmt = con.prepareStatement(queryString);
			pstmt.setInt(1, i);			
			ResultSet result = pstmt.executeQuery();
			result.next();
			int id = result.getInt("studentId");
			Content content = new Content(id);
			pstmt.close();
			
			return content;
		});
	}
}