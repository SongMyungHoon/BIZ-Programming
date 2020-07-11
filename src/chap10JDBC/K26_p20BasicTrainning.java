package chap10JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class K26_p20BasicTrainning {
//	static ArrayList<K26_p20StudentInfo> k26_studentInfoArray = new ArrayList<>();
	
	static int k26_pageSumKor = 0;	// page 별 국어 총점을 저장할 int형 class field 선언
	static int k26_pageSumEng = 0;	// page 별 영어 총점을 저장할 int형 class field 선언
	static int k26_pageSumMat = 0;	// page 별 수학 총점을 저장할 int형 class field 선언
	static int k26_pageTotalSum = 0;// page 별 전 과목 총점을 저장할 int형 class field 선언
	
	static int k26_totalSumKor = 0; // 국어 누적 총점을 저장할 int형 class field 선언
	static int k26_totalSumEng = 0;	// 영어 누적 총점을 저장할 int형 class field 선언
	static int k26_totalSumMat = 0;	// 수학 누적 총점을 저장할 int형 class field 선언
	static int k26_totalSum = 0;	// 전 과목 누적 총점을 저장할 int형 class field 선언
	
	static int k26_iPerson = 1000;	// 집계할 학생의 수를 저장할 int 형 class field 선언
	static K26_p20DAO k26_dao = new K26_p20DAO();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<K26_p20StudentInfo> k26_studentInfoArray = new ArrayList<>();
		k26_dao.k26_connectDB();
		k26_dao.k26_setDB();
//		dao.k26_createTable();
		// K26_p20StudentInfo type data를 선언하고 field 값을 임의로 저장
//		k26_dataSet(dao);
		List<K26_p20StudentInfo> k26_studentInfoList = k26_dao.k26_studentInfoLoadRequest("select * from student_info;");
		int k26_numCount = 0;	// 누적 집계 학생 수를 저장할 int형 변수 선언
		int k26_page = 1;		// page 수를 count할 int형 변수 선언
		boolean k26_whileIteration = true;	// while문 반복 조건
		int k26_forIterationLimit = 0;		// for문 반복 횟수
		int k26_numberPerPage = 30;			// page 당 출력되는 학생 수
		int k26_pageStartStudentNum = 0;	// page에서 첫 번째 줄에 해당하는 학생의 id 

		// while문의 조건절에 true 들어감 : 무한 루프
		while(k26_whileIteration) {
			k26_headerPrint(k26_page);	// HEADER를 출력
			k26_pageStartStudentNum = k26_numCount + 1;
			// k26_numberPerPage 명 당 1page로 집계한다. 남은 학생이 30명 이상이라면
			if((double) (k26_iPerson - k26_numCount) / k26_numberPerPage >= 1) {
				k26_forIterationLimit = k26_numberPerPage;	// for문 반복 횟수를 30번으로 지정
				// 남은 학생 수가 k26_numberPerPage 명 미만이고, 0명이 아니라면
			} else if((k26_iPerson - k26_numCount) % k26_numberPerPage != 0) {
				// 남은 학생 수를 for loop 반복 횟수로 지정
				k26_forIterationLimit = (k26_iPerson - k26_numCount) % k26_numberPerPage;
			} else {	// 남은 학생 수가 0명이라면, error 메시지 출력
				System.out.println("Error occur] forIterationLimit == 0");
				break;	// while 반복 종료
			}
			
			for(int k26_recordCnt = 0; k26_recordCnt < k26_forIterationLimit; k26_recordCnt++) {
				k26_bodyPrint(k26_numCount, k26_studentInfoList);	// 학생의 정보를 출력하고
				k26_numCount++;	// numCount 값을 1 증가한다.
			}	// for loop end
//			// page 별 국어 점수 총 합계를 집계 학생 국어 총점에 누적한다
//			sql = String.format("select sum(kor) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount);
//			k26_totalSumKor += Integer.parseInt(dao.selectQueryRequest(sql).get(0));
//			
//			// page 별 영어 점수 총 합계를 집계 학생 영어 총점에 누적한다
//			sql = String.format("select sum(eng) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount);
//			k26_totalSumEng += Integer.parseInt(dao.selectQueryRequest(sql).get(0));
//			
//			// page 별 수학 점수 총 합계를 집계 학생 수학 총점에 누적한다
//			sql = String.format("select sum(mat) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount);
//			k26_totalSumMat += Integer.parseInt(dao.selectQueryRequest(sql).get(0));
//			
//			// page 별 총 점수를 집계 전체 총점에 누적한다
//			sql = String.format("select sum(kor+eng+mat) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount);
//			k26_totalSum += Integer.parseInt(dao.selectQueryRequest(sql).get(0));
			
			// TAIL 부분을 출력한다
			k26_tailPrint(k26_forIterationLimit, k26_pageStartStudentNum, k26_numCount);
			k26_page++;				// page를 1 증가시킨다
			
			if(k26_numCount >= k26_iPerson) {	// 집계 인원이 전체 인원에 해당하면
				break;	// while loop break
			} else {	// 아니라면, 줄바꿈을 수행한다.
				System.out.printf("\n");
			}
		}	// while loop end
	}	// main method end
	
	// 데이터 만들기
	public static List<K26_p20StudentInfo> k26_dataSet(K26_p20DAO k26_dao) throws SQLException {
		// studentInfo object를 저장할 List 선언
		List<K26_p20StudentInfo> k26_studentInfoList = new ArrayList<>();
		// 전체 학생 수만큼 for loop 반복 설정
		for(int k26_i = 0; k26_i < k26_iPerson; k26_i++) {
			String k26_name = String.format("홍길%02d", k26_i + 1);	// 이름 만들기
			int k26_kor = (int) (Math.random() * 100);			// 국어점수 만들기
			int k26_eng = (int) (Math.random() * 100);			// 영어점수 만들기
			int k26_mat = (int) (Math.random() * 100);			// 수학점수 만들기
		
			// 하나의  OneRec 클래스를 생성 후 ArrayList에 집어넣었다.
			k26_studentInfoList.add(new K26_p20StudentInfo(k26_i + 1,k26_name,k26_kor,k26_eng,k26_mat)); 
		}	// for loop end
		// dao의 insertData method로 MySQL에 Data insert
		k26_dao.k26_insertData(k26_studentInfoList);
		return k26_studentInfoList;
	}	// k26_dataSet end
		
	// HEADER 출력
	public static void k26_headerPrint(int k26_page) {
		
		// Date type의 format을 지정하기 위한 SimpleDateFormat instance 생성
		SimpleDateFormat k26_sdfY4M1d2HHmmssColon = new SimpleDateFormat("YYYY.M.dd HH:mm:ss");
		
		// System의 현재 시간을 얻기 위한 Calendar instance 생성
		Calendar k26_calendar = Calendar.getInstance();	
		System.out.printf("%23s성적집계표\n\n", " ");
		System.out.printf("PAGE: %-21s출력일자 : %s\n", k26_page	// page 수, 출력 일자를 출력
				,k26_sdfY4M1d2HHmmssColon.format(k26_calendar.getTime()));
		System.out.printf("========================================================\n");
		System.out.printf("번호%5s이름%9s국어%3s영어%3s수학%4s총점%4s평균\n"," "," "," "," "," "," ");
		System.out.printf("========================================================\n");
	}	// k26_headerPrint method end
	
	// 내용 인쇄
	public static void k26_bodyPrint(int k26_i, List<K26_p20StudentInfo> k26_studentInfoList) {
		K26_p20StudentInfo k26_personalInfo;	// K26_OneRec class type instance 선언
		
		// ArrayOneRec의 i번째 data를 k26_record에 저장
		k26_personalInfo = k26_studentInfoList.get(k26_i);
		
		if(k26_i < 999 ) {	// index가 999 미만이라면(번호 1000 미만이라면)
			
			// student_id, name, kor, eng, mat, sum, ave 순서로 출력
			System.out.printf("%03d%6s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_personalInfo.k26_student_id()," ",k26_personalInfo.k26_name()," ",k26_personalInfo.k26_kor()," "
					,k26_personalInfo.k26_eng()," ",k26_personalInfo.k26_mat()," ",k26_personalInfo.k26_sum()," ", (int) k26_personalInfo.k26_ave());
		
		} else if(k26_i < 9999) {	// index가 9999 미만라면(번호 10000 미만이라면)
			
			// student_id, name, kor, eng, mat, sum, ave 순서로 출력
			System.out.printf("%d%5s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_personalInfo.k26_student_id()," ",k26_personalInfo.k26_name()," ",k26_personalInfo.k26_kor()," "
					,k26_personalInfo.k26_eng()," ",k26_personalInfo.k26_mat()," ",k26_personalInfo.k26_sum()," ", (int) k26_personalInfo.k26_ave());
		
		} else if(k26_i < 99999) {	// index가 99999 미만이라면(번호 100000 미만이라면)
			
			// student_id, name, kor, eng, mat, sum, ave 순서로 출력
			System.out.printf("%d%4s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_personalInfo.k26_student_id()," ",k26_personalInfo.k26_name()," ",k26_personalInfo.k26_kor()," "
					,k26_personalInfo.k26_eng()," ",k26_personalInfo.k26_mat()," ",k26_personalInfo.k26_sum()," ", (int) k26_personalInfo.k26_ave());
		}
	}	// k26_bodyPrint method end
	
	// TAIL 출력
	public static void k26_tailPrint(int k26_forIterationLimit, int k26_pageStartStudentNum, int k26_numCount) {
		
		System.out.printf("========================================================\n");
		System.out.println("현재페이지");
		
		// page 당 국어 점수 총 합계, page 당 영어 점수 총 합계, 
		// page 당 수학 점수 총 합계, page 당 총 점 합계, page 당 과목 총점 평균 순으로 화면에 출력한다  
		System.out.printf("합계%16s%6d%s%6d%s%6d%s%7d%s%7d\n"," ",k26_pageSumKor," ",k26_pageSumEng
				," ",k26_pageSumMat," ",k26_pageTotalSum," ",k26_pageTotalSum/3);
		
		// 해당 page에서 국어 평균 점수, 영어 평균 점수, 수학 평균 점수, 총점 평균 점수, 평균 점수 순으로 화면에 출력한다
		System.out.printf("평균%16s%6.1f%s%6.1f%s%6.1f%s%7.1f%s%7.1f\n"
				// dao의 selectQueryRequest method로 집계함수 sum을 where절로 조건 걸어서 페이지당 국어 점수 합계 계산해 return 받아 출력
				," ",Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(kor) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount)).get(0))/k26_forIterationLimit
				// dao의 selectQueryRequest method로 집계함수 sum을 where절로 조건 걸어서 페이지당 영어 점수 합계 계산해 return 받아 출력
				," ",Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(eng) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount)).get(0))/k26_forIterationLimit
				// dao의 selectQueryRequest method로 집계함수 sum을 where절로 조건 걸어서 페이지당 수학 점수 합계 계산해 return 받아 출력
				," ",Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(mat) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount)).get(0))/k26_forIterationLimit
				// dao의 selectQueryRequest method로 집계함수 sum을 where절로 조건 걸어서 페이지당 (국어 + 영어 + 수학) 점수 합계 계산해 return 받아 출력
				," ",Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(kor + eng + mat) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount)).get(0))/k26_forIterationLimit
				// 페이지당 총 점수 합계를 과목수인 3으로 나누어 페이지당 과목별 평균 점수 출력
				," ",Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(kor + eng + mat) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount)).get(0))/k26_forIterationLimit/3);
		System.out.printf("========================================================\n");
		System.out.println("누적페이지");
//		sql = String.format("select sum(mat) from student_info where student_id between %d and %d;", k26_pageStartStudentNum,k26_numCount);
		// 누적 국어 점수 총 합계, 누적 영어 점수 총 합계, 
		// 누적 수학 점수 총 합계, 누적 총 점 합계, 누적 과목별 총점 평균 순으로 화면에 출력한다.
		System.out.printf("합계%22d%7d%7d%8d%8d\n"
				,Integer.parseInt(k26_dao.selectQueryRequest(String.format("select sum(kor) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))
				,Integer.parseInt(k26_dao.selectQueryRequest(String.format("select sum(eng) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))
				,Integer.parseInt(k26_dao.selectQueryRequest(String.format("select sum(mat) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))
				,Integer.parseInt(k26_dao.selectQueryRequest(String.format("select sum(kor+eng+mat) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))
				,Integer.parseInt(k26_dao.selectQueryRequest(String.format("select sum(kor+eng+mat) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))/3);
		
		// 누적 집계에서 국어 평균 점수, 영어 평균 점수, 수학 평균 점수, 총점 평균 점수, 평균 점수 순으로 화면에 출력한다
		System.out.printf("평균%22.1f%7.1f%7.1f%8.1f%8.1f\n"
				,Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(kor) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))/k26_numCount
				,Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(eng) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))/k26_numCount
				,Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(mat) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))/k26_numCount
				,Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(kor + eng + mat) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))/k26_numCount
				,Double.parseDouble(k26_dao.selectQueryRequest(String.format("select sum(kor + eng + mat) from student_info where student_id between %d and %d;",1,k26_numCount)).get(0))/k26_numCount/3);
	}	// k26_tailPrint method end
}
class K26_p20DAO {
	
	private static final String k26_ID = "root";			// DB 접속 ID
	private static final String k26_PASSWORD = "qortjf90";	// DB 접속 Password
	
	// K26_DataBaseDAO Class의 공용 Connection 객체
	private static Connection k26_connection = null;
	private static String k26_DBName = "biz_program";		// 접속할 DB name
	private static String k26_tableName = "student_info";	// 물품 정보가 저장된 table의 name
	
	// Class 내부에서 공용으로 String manipulation을 담당할 StringBuilder instance
	private static StringBuilder k26_stringBuilder = new StringBuilder();
		
	public String k26_getDBName() {
		return k26_DBName;
	}

	public void k26_setDBName(String k26_inputDBName) {
		this.k26_DBName = k26_inputDBName;
	}
	
	
	public static String k26_getTableName() {
		return k26_tableName;
	}

	public void k26_setTableName(String k26_tableName) {
		this.k26_tableName = k26_tableName;
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
		k26_connection = DriverManager.getConnection("jdbc:mysql://localhost:3306"
				+ "/koposw26?serverTimezone=UTC", "root", "qortjf90");
//		k26_connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306"
//				+ "/practice?serverTimezone=UTC", "root", "qortjf90");
		
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
		String k26_useDB_SERVER = "jdbc:mysql://localhost:3306";
		String k26_useDB_URL_Option = k26_stringBuilder.append("?useUnicode=true&characterEncoding=utf8")
					.append("&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true")
					.append("&useSSL=false").toString();
//		String k26_useDB_SERVER = "jdbc:mysql://127.0.0.1:3306";
//		String k26_useDB_URL_Option = k26_stringBuilder.append("?useUnicode=true&characterEncoding=utf8")
//				.append("&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true")
//				.append("&useSSL=false").toString();

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
			}	// try - catch end
		}	// try - catch - finally end
	}	// k26_setDB method end
	
	public void k26_createTable() {
		String createTableQuery 
			= k26_stringBuilder.append("create table if not exists ").append(k26_tableName).append("(")
							   .append("student_id int primary key,").append("name varchar(20),")
							   .append("kor int,").append("eng int,").append("mat int);").toString();
		k26_stringBuilder.setLength(0);
		/* Connection의 createStatement method로 database에 SQL statment를 보낼 Statement instance를 생성
		 * Parameter가 없는 SQL 문은 일반적으로 Statement object를 사용하여 실행된다. */	 	
	 	k26_executeQuery(createTableQuery);
	}	// k26_createTable method end
	
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
	}	// k26_executeQuery method end
	
	public static List<String> selectQueryRequest(String selectQuery) {
		List<String> result = new ArrayList<String>();
		Statement k26_statement = null;
		ResultSet k26_resultSet = null;
		ResultSetMetaData k26_rsmd = null;
		try {
			k26_statement = k26_connection.createStatement();
			if((k26_resultSet = k26_statement.executeQuery(selectQuery)) != null) {
				k26_rsmd = (ResultSetMetaData) k26_resultSet.getMetaData();
			}
			while (k26_resultSet != null && k26_resultSet.next()) {
				for(int i = 1; i <= k26_rsmd.getColumnCount(); i++) {
					result.add(k26_resultSet.getString(i));
				}
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
		return result;
	}
	
	public List<K26_p20StudentInfo> k26_studentInfoLoadRequest (String k26_selectQuery) {
		
		List<K26_p20StudentInfo> k26_result = new ArrayList<>();
		Statement k26_statement = null;
		ResultSet k26_resultSet = null;
		try {
			k26_statement = k26_connection.createStatement();
			
			/** Statement Class. excuteQuery(String query) method
		      * Executes the given SQL statement,
			  * which returns a single ResultSet object.
	
		      * Note:
			  *	This method cannot be called on a PreparedStatement or CallableStatement.
		      * @param sql an SQL statement to be sent to the database, typically a
		      *        static SQL SELECT statement
		      * @return a ResultSet object that contains the data produced by the given query;
			  * 		never null!
		      * @exception SQLException
			  * if a database access error occurs,
		      * this method is called on a closed Statement,
		      * the given SQL statement produces anything other than a single ResultSet object,
		      *  the method is called on a PreparedStatement or CallableStatement
		      * @throws SQLTimeoutException
		      * when the driver has determined that the timeout value
		      * that was specified by the setQueryTimeout method
		      * has been exceeded and has at least attempted to cancel the currently running Statement
		      */
			
			if((k26_resultSet = k26_statement.executeQuery(k26_selectQuery)) != null) {
			}
			while (k26_resultSet != null && k26_resultSet.next()) {
				K26_p20StudentInfo studentInfo = new K26_p20StudentInfo(
													  k26_resultSet.getInt("student_id")
													, k26_resultSet.getString("name")
													, k26_resultSet.getInt("kor")
													, k26_resultSet.getInt("eng")
													, k26_resultSet.getInt("mat"));
				k26_result.add(studentInfo);
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
	}	// end k26_studentInfoLoadQuery method
	
	/** k26_insertItem method
	  * DB에 새로운 Item record를 입력하는 insert query를 수행하는 method
	  * @return (int) -1 -> (k26_itemCompare method의 작동 결과,
	  * 					 k26_whileLoop method에서 -1을 return 받고 while문 escape하여
	  * 					 k26_initialMenu method로 되돌아간다.
	 * @throws SQLException 
	  */
	public static void k26_insertData(List<K26_p20StudentInfo> k26_studentInfoList) throws SQLException {
		K26_p20StudentInfo personalInfo;
		PreparedStatement k26_preStatement = null;
		ResultSet k26_resultSet = null;
		k26_connection.setAutoCommit(false);
		// 실행할 insert query 작성
		k26_stringBuilder.append("insert into ").append(k26_tableName).append(" ")
		   .append("(student_id, name, kor, eng, mat) values (?,?,?,?,?);"); 
		// 작성된 query를 실행
		k26_preStatement = k26_connection.prepareStatement(k26_stringBuilder.toString());
		// 공용 StringBuilder 사용 후 초기화
				k26_stringBuilder.setLength(0);
		for(int i = 0; i < k26_studentInfoList.size(); i++) {
			personalInfo = k26_studentInfoList.get(i);
//			System.out.printf("[%d] %s, kor: %d, eng: %d, mat: %d\n",personalInfo.k26_student_id(),personalInfo.k26_name(),personalInfo.k26_kor(),personalInfo.k26_eng(),personalInfo.k26_mat());
			k26_preStatement.setInt(1, personalInfo.k26_student_id());	// bsop_date INT
			k26_preStatement.setString(2, personalInfo.k26_name());
			k26_preStatement.setInt(3, personalInfo.k26_kor());
			k26_preStatement.setInt(4, personalInfo.k26_eng());
			k26_preStatement.setInt(5, personalInfo.k26_mat());
			k26_preStatement.addBatch();
			k26_preStatement.clearParameters();
			k26_preStatement.executeBatch();
		}
		k26_connection.commit();	
	}	// k26_insertItem method end
}	// K26_p20DAO class end

class K26_p20StudentInfo {
	// 학번을 저장할 int형 변수 선언
	private int k26_student_id;
	
	// 학생의 이름을 저장할 String형 변수 선언
	private String k26_name;
	
	// 국어 점수를 저장할 int형 변수 선언
	private int k26_kor;
	
	// 영어 점수를 저장할 int형 변수 선언
	private int k26_eng;
	
	// 수학 점수를 저장할 int형 변수 선언
	private int k26_mat;
	
	// 각 field의 data를 parameter로 입력 받는 Constructor 선언
	public K26_p20StudentInfo(int student_id, String k26_name
			, int k26_kor, int k26_eng, int k26_mat) {
		
		// parameter student_id 값을 OneRec instance의 student_id 값으로 저장 
		this.k26_student_id = student_id;
		
		// parameter name 값을 OneRec instance의 name 값으로 저장
		this.k26_name = k26_name;
		
		// parameter kor 값을 OneRec instance의 kor 값으로 저장
		this.k26_kor = k26_kor;
	
		// parameter eng 값을 OneRec instance의 eng 값으로 저장
		this.k26_eng = k26_eng;
	
		// parameter mat 값을 OneRec instance의 mat 값으로 저장
		this.k26_mat = k26_mat;
	}	// Constructor end
	
	// student_id field에 대한 getter method로 해당 class의 instacne의 student_id 값을 반환
	public int k26_student_id() {
		return this.k26_student_id;
	}	// k26_student_id method end
	
	// name field에 대한 getter method로 해당 class의 instacne의 name 값을 반환
	public String k26_name() {
		return this.k26_name;
	}	// k26_name method end
	
	// kor field에 대한 getter method로 해당 class의 instacne의 kor 값을 반환
	public int k26_kor() {
		return this.k26_kor;
	}	// k26_kor method end
	
	// eng field에 대한 getter method로 해당 class의 instacne의 eng 값을 반환
	public int k26_eng() {
		return this.k26_eng;
	}	// k26_eng method end
	
	// mat field에 대한 getter method로 해당 class의 instacne의 mat 값을 반환
	public int k26_mat() {
		return this.k26_mat;
	}	// k26_mat method end
	
	// kor, eng, mat의 합계를 return하는 method
	public int k26_sum() {
		return this.k26_kor + this.k26_eng + this.k26_mat;
	}	// k26_sum method end
	
	// kor, eng, mat의 평균을 return하는 method
	public double k26_ave() {
		// 평균은 sum을 과목수 3으로 나누어 계산한다.
		return this.k26_sum()/3.0;
	}	// k26_ave method end
}	// K26_p33OneRec Class end