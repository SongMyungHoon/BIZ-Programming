package chap10JDBC;

import java.io.*;
import java.sql.*;
import java.util.*;

public class K26_p21AdvantageTraining {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {		
		K26_DAO k26_dao = new K26_DAO();
//		k26_dao.k26_connectDBtest();
		k26_dao.k26_connectDB();				// k26_dbDAO 객체의 connection 객체 생성
		k26_dao.k26_setDB();					// k26_dbName과 동일한 이름의 DB를 탐색하고, 없는 경우 DB 생성해 use
		k26_dao.k26_createTable();

	}
}

class K26_DAO {
	
	private static final String k26_ID = "root";			// DB 접속 ID
	private static final String k26_PASSWORD = "qortjf90";	// DB 접속 Password
	
	// K26_DataBaseDAO Class의 공용 Connection 객체
	private static Connection k26_connection = null;
	private static String k26_DBName = "koposw26";		// 접속할 DB name
	private static String k26_tableName = "stockInfo";	// 물품 정보가 저장된 table의 name
	
	// Class 내부에서 공용으로 String manipulation을 담당할 StringBuilder instance
	private static StringBuilder k26_stringBuilder = new StringBuilder();
		
	public String k26_getDBName() {
		return k26_DBName;
	}

	public void k26_setDBName(String k26_inputDBName) {
		k26_DBName = k26_inputDBName;
	}
	
	
	public static String k26_getTableName() {
		return k26_tableName;
	}

	public void k26_setTableName(String k26_tableName) {
		K26_DAO.k26_tableName = k26_tableName;
	}
	public void k26_connectDBtest() throws ClassNotFoundException, SQLException {
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
		k26_connection = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33060"
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
	/**k26_connectDB method
	 * DB와의 connection을 수행하는 method로 K26_DataBaseDAO Class의 공용 connection instance에
	 * connection 정보를 저장하고 해당 공용 connection을 공유하는 형태로 DAO class 설계
	 * @return void	 */
	public void k26_connectDB () {
		String k26_useDB_SERVER = "jdbc:mysql://192.168.23.110:33060";
		String k26_useDB_URL_Option = k26_stringBuilder.append("?useUnicode=true&characterEncoding=utf8")
					.append("&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true")
					.append("&useSSL=false").toString();

		k26_stringBuilder.setLength(0);
		
		String k26_DB_URL = k26_stringBuilder.append(k26_useDB_SERVER)
				.append("/").append(k26_useDB_URL_Option).toString();
		k26_stringBuilder.setLength(0);
		
		try {
			/* Class.forName("com.mysql.cj.jdbc.Driver");
			 * -> mysql의 jdbc Driver가 존재하는지 확인 */
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException k26_Error) {
		    System.out.println("ERROR] JDBC Driver load: \n" + k26_Error.getMessage());
		    k26_Error.printStackTrace();
		}
		
		
		try {
			/* DriverManager 클래스의 getConnection 메서드로 VM의 Linux에 앞서 forwarding한 33060 포트로 접근해
			 * mysql을 구동하고 koposw26 DB에 접근한 후 해당 데이터를 Connection instance에 저장한다.
			 * The server time zone value 'KST' is unrecognized or represents more than one time zone.
			 * 이라는 SQLException이 발생하므로 serverTimezone=UTC 옵션을 부여하여 SQLException 제거
			 * mysql 계정 : root, 패스워드 : qortjf90*/
			k26_connection = DriverManager.getConnection(k26_DB_URL, k26_ID, k26_PASSWORD);
		} catch (SQLException k26_Error) {
			System.out.println("Error] Connection fail: \n" + k26_Error.getMessage());
			k26_Error.printStackTrace();
		}
	}
	
	/**k26_setDB method
	 * 설정된 k26_DBName과 동일한 DB가 존재하는지 확인하고, 없는 경우
	 * k26_DBName으로 DB 생성 후 DB 사용 전환
	 * @return void	 */
	public void k26_setDB() {
		PreparedStatement k26_preStatement = null;
		ResultSet k26_resultSet = null;
		try {
			// MySQL에서 접근 가능한 DB 중 k26_DBNAme에 해당하는 DB를 select로 조회
			String k26_DBSql = "SELECT * FROM Information_schema.SCHEMATA WHERE SCHEMA_NAME = ?";
			k26_preStatement = k26_connection.prepareStatement(k26_DBSql);
			k26_preStatement.setString(1, k26_DBName);
			/**
		     * Executes the SQL query in this PreparedStatement object
		     * and returns the ResultSet object generated by the query.
		     *
		     * @return a ResultSet object that contains the data produced by the query;
		     * 		   never null
		     * @exception SQLException if a database access error occurs;
		     * this method is called on a closed PreparedStatement
			 * or the SQL statement does not return a ResultSet object
		     * @throws 
		     * SQLTimeoutException when the driver has determined that
			 * the timeout value that was specified by the setQueryTimeout method
			 * has been exceeded and has at least attempted to cancel
		     * the currently running Statement */
			k26_resultSet = k26_preStatement.executeQuery();
			
			//데이터베이스가 없다면 데이터베이스 생성
			if(!k26_resultSet.next()){
				Statement k26_statement = k26_connection.createStatement();
				System.out.println("database not found");
				System.out.println("create new database " + k26_DBName);
				String k26_dbSql = "create database if not exists " + k26_DBName;
				
				/* statement.execute(sql)
				 * return true if the first result is a ResultSet object 
			     * return false if it is an update count or there are no results 
			     * create database db_name query는 row의 count를 반환하므로 
			     * return true인 경우 DB 생성 실패를 의미한다. */ 
				if(k26_statement.execute(k26_dbSql)) {
					System.out.println("데이터베이스 생성 실패");
				}
				k26_statement.close();
			} 
			//데이터베이스를 변환 (use database)
			k26_connection.setCatalog(k26_DBName);
		} catch (Exception k26_Error) {
			System.out.println("CreateOrChangeDatabase error : " + k26_Error);
		} finally {
			try{
				if(k26_resultSet != null) {
					k26_resultSet.close();
				}
				if(k26_preStatement != null) {
					k26_preStatement.close();
				}
				if(k26_connection != null) {
					k26_preStatement.close();
				}
			} catch (Exception k26_Error) {
				System.out.println("Close error : " + k26_Error);
				k26_Error.printStackTrace();
			}
		}
	}
	
	public void k26_createTable() {
		String createTableQuery 
			= k26_stringBuilder.append("create table if not exists ").append(k26_tableName).append("(")
							   .append("stnd_iscd VARCHAR(20),")
							   .append("bsop_date INT,")
							   .append("shrn_iscd VARCHAR(20),")
							   .append("stck_prpr INT,")
							   .append("stck_oprc INT,")
							   .append("stck_hgpr INT,")
							   .append("stck_lwpr INT,")
							   .append("prdy_vrss_sign VARCHAR(20),")
							   .append("prdy_vrss INT,")
							   .append("prdy_ctrt FLOAT,")
							   .append("prdy_vol BIGINT,")
							   .append("acml_vol BIGINT,")
							   .append("acml_tr_pbmn BIGINT,")
							   .append("askp1 INT,")
							   .append("bidp1 INT,")
							   .append("total_askp_rsqn BIGINT,")
							   .append("total_bidp_rsqn BIGINT,")
							   .append("seln_cntg_smtn BIGINT,")
							   .append("shnu_cntg_smtn BIGINT,")
							   .append("seln_tr_pbmn BIGINT,")
							   .append("shnu_tr_pbmn BIGINT,")
							   .append("seln_cntg_csnu INT,")
							   .append("shnu_cntg_csnu INT,")
							   .append("w52_hgpr INT,")
							   .append("w52_lwpr INT,")
							   .append("w52_hgpr_date INT,")
							   .append("w52_lwpr_date INT,")
							   .append("ovtm_untp_bsop_hour INT,")
							   .append("ovtm_untp_prpr INT,")
							   .append("ovtm_untp_prdy_vrss INT,")
							   .append("ovtm_untp_prdy_vrss_sign VARCHAR(20),")
							   .append("ovtm_untp_askp1 INT,")
							   .append("ovtm_untp_bidp1 INT,")
							   .append("ovtm_untp_vol BIGINT,")
							   .append("ovtm_untp_tr_pbmn BIGINT,")
							   .append("ovtm_untp_oprc INT,")
							   .append("ovtm_untp_hgpr INT,")
							   .append("ovtm_untp_lwpr INT,")
							   .append("mkob_otcp_vol BIGINT,")
							   .append("mkob_otcp_tr_pbmn BIGINT,")
							   .append("mkfa_otcp_vol BIGINT,")
							   .append("mkfa_otcp_tr_pbmn BIGINT,")
							   .append("mrkt_div_cls_code VARCHAR(20),")
							   .append("pstc_dvdn_amt BIGINT,")
							   .append("lstn_stcn BIGINT,")
							   .append("stck_sdpr INT,")
							   .append("stck_fcam FLOAT,")
							   .append("wghn_avrg_stck_prc DOUBLE,")
							   .append("issu_limt_rate FLOAT,")
							   .append("frgn_limt_qty BIGINT,")
							   .append("oder_able_qty BIGINT,")
							   .append("frgn_limt_exhs_cls_code VARCHAR(20),")
							   .append("frgn_hldn_qty BIGINT,")
							   .append("frgn_hldn_rate FLOAT,")
							   .append("hts_frgn_ehrt FLOAT,")
							   .append("itmt_last_nav FLOAT,")
							   .append("prdy_last_nav FLOAT,")
							   .append("trc_errt FLOAT,")
							   .append("dprt FLOAT,")
							   .append("ssts_cntg_qty BIGINT,")
							   .append("ssts_tr_pbmn BIGINT,")
							   .append("frgn_ntby_qty BIGINT,")
							   .append("flng_cls_code VARCHAR(20),")
							   .append("prtt_rate FLOAT,")
							   .append("acml_prtt_rate FLOAT,")
							   .append("stdv FLOAT,")
							   .append("beta_cfcn FLOAT,")
							   .append("crlt_cfcn FLOAT,")
							   .append("bull_beta FLOAT,")
							   .append("bear_beta FLOAT,")
							   .append("bull_dvtn FLOAT,")
							   .append("bear_dvtn FLOAT,")
							   .append("bull_crlt FLOAT,")
							   .append("bear_crlt FLOAT,")
							   .append("stck_mxpr INT,")
							   .append("stck_llam INT,")
							   .append("icic_cls_code VARCHAR(20),")
							   .append("itmt_vol BIGINT,")
							   .append("itmt_tr_pbmn BIGINT,")
							   .append("fcam_mod_cls_code VARCHAR(20),")
							   .append("revl_issu_reas_code VARCHAR(20),")
							   .append("orgn_ntby_qty BIGINT,")
							   .append("adj_prpr INT,")
							   .append("fn_oprc INT,")
							   .append("fn_hgpr INT,")
							   .append("fn_lwpr INT,")
							   .append("fn_prpr INT,")
							   .append("fn_acml_vol BIGINT,")
							   .append("fn_acml_tr_pbmn BIGINT,")
							   .append("fn_prtt_rate FLOAT,")
							   .append("fn_flng_cls_code VARCHAR(20),")
							   .append("buyin_nor_prpr INT,")
							   .append("buyin_nor_prdy_vrss INT,")
							   .append("buyin_nor_vol BIGINT,")
							   .append("buyin_nor_tr_pbmn BIGINT,")
							   .append("buyin_tod_prpr INT,")
							   .append("buyin_tod_prdy_vrss INT,")
							   .append("buyin_tod_vol BIGINT,")
							   .append("buyin_tod_tr_pbmn BIGINT);").toString();
		k26_stringBuilder.setLength(0);
		/* Connection의 createStatement method로 database에 SQL statment를 보낼 Statement instance를 생성
		 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다. */	 	
	 	k26_executeQuery(createTableQuery);
	}
	public void k26_executeQuery(String k26_query) {
		Statement k26_statement = null;
		try {
			/* Connection의 createStatement method로 database에 SQL statment를 보낼 Statement instance를 생성
			 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다. */	 	
			k26_statement = k26_connection.createStatement();
			 
			/** Statement class. excuteUpdate(String query) method
		      * Executes the given SQL statement, which may be 
		      * an INSERT, UPDATE, or DELETE statement or 
		      * an SQL statement that returns nothing, such as an SQL DDL statement.
			  *
		      * Note:
			  * This method cannot be called on a PreparedStatement or CallableStatement.
			  * 
		      * @param sql an SQL Data Manipulation Language (DML) statement,
		      * such as INSERT, UPDATE or DELETE;
			  * or an SQL statement that returns nothing, such as a DDL statement.
		      *
		      * @return either 
		      * 			  (1) the row count for SQL Data Manipulation Language (DML) statements
		      *            or (2) 0 for SQL statements that return nothing
		      *
		      * @exception 
		      * SQLException if a database access error occurs,
		      * this method is called on a closed Statement,
		      * the given SQL statement produces a ResultSet object,
			  * the method is called on a PreparedStatement or CallableStatement
		      * @throws
		      * SQLTimeoutException when the driver has determined that 
		      * the timeout value that was specified by the setQueryTimeout method
		      * has been exceeded and has at least attempted to cancel the currently running Statement
		      */
			if(k26_statement != null && k26_statement.executeUpdate(k26_query) >= 0) {
			} else {
				System.out.println("Error] Execute fail");
			}
		} catch (SQLException k26_Error) {
			System.out.println(k26_Error.getMessage());
			k26_Error.printStackTrace();
		} finally {
			try {
				if(k26_statement != null) {
					k26_statement.close();
				}	
			} catch(SQLException k26_Error) {
				System.out.println(k26_Error.getMessage());
				k26_Error.printStackTrace();
			}	// end finally try 
		}	// end try
	}
	
	public static List<List<String>> k26_dataPrintQuery (String k26_query) {
		List<List<String>> k26_result = new ArrayList<>();
		Statement k26_statement = null;
		ResultSet k26_resultSet = null;
		ResultSetMetaData k26_rsmd = null;
		try {
			k26_statement = k26_connection.createStatement();
			if((k26_resultSet = k26_statement.executeQuery(k26_query)) != null) {
				k26_rsmd = (ResultSetMetaData) k26_resultSet.getMetaData();
			}
			while (k26_resultSet != null && k26_resultSet.next()) {
				List<String> tempList = new ArrayList<>();
				for(int i = 1; i <= k26_rsmd.getColumnCount(); i++) {
					String k26_tempStr = k26_resultSet.getString(i);
					System.out.print(" " + k26_tempStr);
					tempList.add(k26_resultSet.getString(i));
				}
				System.out.println();
				k26_result.add(tempList);
			}	// end while
		} catch (SQLException k26_Error) {
			System.out.println(k26_Error.getMessage());
			k26_Error.printStackTrace();
		} finally {
			try {
				if(k26_statement != null) {
					k26_statement.close();
				}
			} catch(SQLException k26_Error) {
				System.out.println(k26_Error.getMessage());
				k26_Error.printStackTrace();
			}	// end finally try 
		}	// end try
		return k26_result;
	}
	
	public void k26_dataInsert() throws SQLException, IOException {
		/* Connection의 createStatement method로 database에 SQL statement를 보낼 Statement instance를 생성
		 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다. */
		Statement k26_statement = k26_connection.createStatement();
	}
	
//	public List<K26_Item> k26_itemDataLoadQuery (String k26_query) {
//	List<K26_Item> k26_result = new ArrayList<>();
//	Statement k26_statement = null;
//	ResultSet k26_resultSet = null;
//	try {
//		k26_statement = k26_connection.createStatement();
//		
//		/** Statement Class. excuteQuery(String query) method
//	      * Executes the given SQL statement,
//		  * which returns a single ResultSet object.
//
//	      * Note:
//		  *	This method cannot be called on a PreparedStatement or CallableStatement.
//	      * @param sql an SQL statement to be sent to the database, typically a
//	      *        static SQL SELECT statement
//	      * @return a ResultSet object that contains the data produced by the given query;
//		  * 		never null!
//	      * @exception SQLException
//		  * if a database access error occurs,
//	      * this method is called on a closed Statement,
//	      * the given SQL statement produces anything other than a single ResultSet object,
//	      *  the method is called on a PreparedStatement or CallableStatement
//	      * @throws SQLTimeoutException
//	      * when the driver has determined that the timeout value
//	      * that was specified by the setQueryTimeout method
//	      * has been exceeded and has at least attempted to cancel the currently running Statement
//	      */
//		
//		if((k26_resultSet = k26_statement.executeQuery(k26_query)) != null) {
//		}
//		while (k26_resultSet != null && k26_resultSet.next()) {
//			K26_Item k26_item = new K26_Item(
//					  k26_resultSet.getInt("no")
//					, k26_resultSet.getString("name")
//					, k26_resultSet.getInt("weight")
//					, k26_resultSet.getDouble("display_size")
//					, k26_resultSet.getInt("disk_volume")
//					, k26_resultSet.getString("etc")
//					, k26_resultSet.getInt("price"));
//			k26_result.add(k26_item);
//		}	// end while
//	} catch (SQLException k26_Error) {
//		System.out.println(k26_Error.getMessage());
//		k26_Error.printStackTrace();
//	} finally {
//		try {
//			if(k26_statement != null) {
//				k26_statement.close();
//			}
//		} catch(SQLException k26_Error) {
//			System.out.println(k26_Error.getMessage());
//			k26_Error.printStackTrace();
//		}	// end finally try 
//	}	// end try
//	return k26_result;
//}
}
//class K26_StockData {
//	String stnd_iscd;
//	int bsop_date;
//	String shrn_iscd;
//	int stck_prpr;
//	int stck_oprc;
//	int stck_hgpr;
//	int stck_lwpr;
//	String prdy_vrss_sign;
//	int prdy_vrss;
//	double prdy_ctrt;
//	prdy_vol BIGINT,
//	acml_vol BIGINT,
//	acml_tr_pbmn BIGINT,
//	askp1 INT,
//	bidp1 INT,
//	total_askp_rsqn BIGINT,
//	total_bidp_rsqn BIGINT,
//	seln_cntg_smtn BIGINT,
//	shnu_cntg_smtn BIGINT,
//	seln_tr_pbmn BIGINT,
//	shnu_tr_pbmn BIGINT,
//	seln_cntg_csnu INT,
//	shnu_cntg_csnu INT,
//	w52_hgpr INT,
//	w52_lwpr INT,
//	w52_hgpr_date INT,
//	w52_lwpr_date INT,
//	ovtm_untp_bsop_hour INT,
//	ovtm_untp_prpr INT,
//	ovtm_untp_prdy_vrss INT,
//	ovtm_untp_prdy_vrss_sign VARCHAR(20),
//	ovtm_untp_askp1 INT,
//	ovtm_untp_bidp1 INT,
//	ovtm_untp_vol BIGINT,
//	ovtm_untp_tr_pbmn BIGINT,
//	ovtm_untp_oprc INT,
//	ovtm_untp_hgpr INT,
//	ovtm_untp_lwpr INT,
//	mkob_otcp_vol BIGINT,
//	mkob_otcp_tr_pbmn BIGINT,
//	mkfa_otcp_vol BIGINT,
//	mkfa_otcp_tr_pbmn BIGINT,
//	mrkt_div_cls_code VARCHAR(20),
//	pstc_dvdn_amt BIGINT,
//	lstn_stcn BIGINT,
//	stck_sdpr INT,
//	stck_fcam FLOAT,
//	wghn_avrg_stck_prc DOUBLE,
//	issu_limt_rate FLOAT,
//	frgn_limt_qty BIGINT,
//	oder_able_qty BIGINT,
//	frgn_limt_exhs_cls_code VARCHAR(20),
//	frgn_hldn_qty BIGINT,
//	frgn_hldn_rate FLOAT,
//	hts_frgn_ehrt FLOAT,
//	itmt_last_nav FLOAT,
//	prdy_last_nav FLOAT,
//	trc_errt FLOAT,
//	dprt FLOAT,
//	ssts_cntg_qty BIGINT,
//	ssts_tr_pbmn BIGINT,
//	frgn_ntby_qty BIGINT,
//	flng_cls_code VARCHAR(20),
//	prtt_rate FLOAT,
//	acml_prtt_rate FLOAT,
//	stdv FLOAT,
//	beta_cfcn FLOAT,
//	crlt_cfcn FLOAT,
//	bull_beta FLOAT,
//	bear_beta FLOAT,
//	bull_dvtn FLOAT,
//	bear_dvtn FLOAT,
//	bull_crlt FLOAT,
//	bear_crlt FLOAT,
//	stck_mxpr INT,
//	stck_llam INT,
//	icic_cls_code VARCHAR(20),
//	itmt_vol BIGINT,
//	itmt_tr_pbmn BIGINT,
//	fcam_mod_cls_code VARCHAR(20),
//	revl_issu_reas_code VARCHAR(20),
//	orgn_ntby_qty BIGINT,
//	adj_prpr INT,
//	fn_oprc INT,
//	fn_hgpr INT,
//	fn_lwpr INT,
//	fn_prpr INT,
//	fn_acml_vol BIGINT,
//	fn_acml_tr_pbmn BIGINT,
//	fn_prtt_rate FLOAT,
//	fn_flng_cls_code VARCHAR(20),
//	buyin_nor_prpr INT,
//	buyin_nor_prdy_vrss INT,
//	buyin_nor_vol BIGINT,
//	buyin_nor_tr_pbmn BIGINT,
//	buyin_tod_prpr INT,
//	buyin_tod_prdy_vrss INT,
//	buyin_tod_vol BIGINT,
//	buyin_tod_tr_pbmn BIGINT);
//}