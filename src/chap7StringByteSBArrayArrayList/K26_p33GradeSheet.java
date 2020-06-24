package chap7StringByteSBArrayArrayList;

import java.text.SimpleDateFormat;
import java.util.*;

public class K26_p33GradeSheet {
	static ArrayList<K26_p30OneRec> ArrayOneRec = new ArrayList<>();
	static int pageSumKor = 0;
	static int sumEng = 0;
	static int sumMat = 0;
	static int pageSum = 0;
	static int pageAvg = 0;
	static int totalSum = 0;
	static int totalAvg = 0;
	static int iPerson = 200;
	
	public static void main(String[] args) {
		dataSet();
		int numCount = 0;
		int page = 1;
		boolean whileIteration = true;
		int forIterationLimit = 0;

		while(whileIteration) {
			pageSum = 0;
			pageAvg = 0;
			headerPrint(page);
			if((double) (iPerson - numCount) / 30 >= 1) {
				forIterationLimit = 30;
			} else if((iPerson - numCount) % 30 != 0) {
				forIterationLimit = (iPerson - numCount) % 30;
			} else {
				System.out.println("Error occur] forIterationLimit == 0");
				break;
			}
			for(int recordPerPage = 0; recordPerPage < forIterationLimit; recordPerPage++) {
				itemPrint(numCount);
				numCount++;
			}
			pageAvg = pageSum / forIterationLimit;
			totalSum += pageSum;
			totalAvg = totalSum / numCount;
			tailPrint();
			page++;
			if(numCount >= iPerson) {
				break;
			} else {
				System.out.printf("\n");
			}
		}
	}
	
	// 데이터 만들기
	public static void dataSet() {
		for(int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i + 1);	// 이름 만들기
			int kor = (int) (Math.random() * 100);			// 국어점수 만들기
			int eng = (int) (Math.random() * 100);			// 영어점수 만들기
			int mat = (int) (Math.random() * 100);			// 수학점수 만들기
			// 하나의  OneRec 클래스를 생성 후 ArrayList에 집어넣었다.
			ArrayOneRec.add(new K26_p30OneRec(i,name,kor,eng,mat)); 
		}
	}
	// HEADR 출력
	public static void headerPrint(int page) {
		SimpleDateFormat sdfY4M1d2HHmmssColon = new SimpleDateFormat("YYYY.M.dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		System.out.printf("%20s성적집계표\n\n", " ");
		System.out.printf("PAGE: %d%14s출력일자 : %s\n", page," "
				,sdfY4M1d2HHmmssColon.format(calendar.getTime()));
		System.out.printf("==================================================\n");
		System.out.printf("번호%3s이름%5s국어%3s영어%3s수학%3s총점%5s평균\n"," "," "," "," "," "," ");
		System.out.printf("==================================================\n");
	}
	
	// 내용 인쇄
	public static void itemPrint(int i) {
		K26_p30OneRec record;
		
		record = ArrayOneRec.get(i);
		System.out.printf("%03d%4s%-7s%s%3d%3s%4d%3s%4d%4s%3d%5s%4d\n"
				,record.student_id() + 1," ",record.name()," ",record.kor()," "
				,record.eng()," ",record.mat()," ",record.sum()," ", (int) record.ave());
		
		pageSumKor += record.kor();
		sumEng += record.eng();
		sumMat += record.mat();
		pageSum += record.sum();
	}
	
	// TAIL 출력
	public static void tailPrint() {
		
		System.out.printf("==================================================\n");
		System.out.println("현재페이지");
		System.out.printf("합계%s%d%s%d%s%d%s%d%s%d\n"," ",pageSumKor," ",sumEng," ",sumMat," "
				,pageSum," ",pageSum/3);
		System.out.printf("==================================================\n");
		System.out.println("누적페이지");
		
	}
}
