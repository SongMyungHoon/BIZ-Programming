package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;

public class K26_p30Main {
	
	static ArrayList<K26_p30OneRec> ArrayOneRec = new ArrayList<>();
	static int sumKor = 0;
	static int sumEng = 0;
	static int sumMat = 0;
	static int sumSum = 0;
	static int sumAve = 0;
	static final int iPerson = 20;
	
	// 데이터 만들기
	public static void dataSet() {
		for(int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i);	// 이름 만들기
			int kor = (int) (Math.random() * 100);		// 국어점수 만들기
			int eng = (int) (Math.random() * 100);		// 영어점수 만들기
			int mat = (int) (Math.random() * 100);		// 수학점수 만들기
			// 하나의  OneRec 클래스를 생성 후 ArrayList에 집어넣었다.
			ArrayOneRec.add(new K26_p30OneRec(i,name,kor,eng,mat)); 
		}
	}
	
	// 헤더 인쇄
	public static void HeaderPrint() {
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("%2s %3s  %2s %2s %2s %2s   %2s\n"
				, "번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		
	}
	
	// 내용 인쇄
	public static void ItemPrint(int i) {
		K26_p30OneRec rec;
		
		rec = ArrayOneRec.get(i);
		System.out.printf("%4d %4s %3d %4d %4d %5d %6.2f\n"
				,rec.student_id(),rec.name(),rec.kor()
				,rec.eng(),rec.mat(),rec.sum(),rec.ave());
		
		sumKor += rec.kor();
		sumEng += rec.eng();
		sumMat += rec.mat();
		sumSum += rec.sum();
		sumAve += rec.ave();
	}
	
	// 꼬리 인쇄
	public static void TailPrint() {
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("  국어합계 %4d       국어평균: %6.2f\n", sumKor,sumKor/(double)ArrayOneRec.size());
		System.out.printf("  영어합계 %4d       영어평균: %6.2f\n", sumEng,sumEng/(double)ArrayOneRec.size());
		System.out.printf("  수학합계 %4d       수학평균: %6.2f\n", sumMat,sumMat/(double)ArrayOneRec.size());
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("  반평균합계 %4d       반평균: %6.2f\n", sumAve,sumAve/(double)ArrayOneRec.size());
	}
	
	public static void main(String[] args) {
			dataSet();		// 데이터 세팅
			HeaderPrint();	// 헤더 인쇄
			for(int i = 0; i < ArrayOneRec.size(); i++) {	// 내용 인쇄
				ItemPrint(i);
			}
			TailPrint();	// 꼬리 인쇄

	}

}
