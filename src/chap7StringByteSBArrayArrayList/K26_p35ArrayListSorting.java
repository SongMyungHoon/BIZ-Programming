package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class K26_p35ArrayListSorting {
	
	static ArrayList<K26_p30OneRec> ArrayOneRec = new ArrayList<>();
	static int sumKor = 0;
	static int sumEng = 0;
	static int sumMat = 0;
	static int sumSum = 0;
	static int sumAve = 0;
	static final int iPerson = 20;

	public static void main(String[] args) {
		dataSet();		// 데이터 생성
		dataSort();		// 데이터 정렬
		HeaderPrint();	// HEADER 출력
		for(int i = 0; i < ArrayOneRec.size(); i++) {
			ItemPrint(i);	// BODY 출력
		}
		TailPrint();	// TAIL 출력
	}
	
	public static void dataSort() {
		// 비교 기준에 사용할 Comparator type class를 익명 클래스로 생성 (anonymous class)
		Comparator<K26_p30OneRec> criteriaForComparison = new Comparator<K26_p30OneRec>() {
			// 총점 (sum())을 기준으로 sort하는 경우
			public int compare(K26_p30OneRec record1, K26_p30OneRec record2) {
				/* 문자형 비교의 경우
				 * return (String.valueOf(record1.sum().compareTo(String.valueOf(record2.sum())); 
				 * */
				return (record2.sum() - record1.sum());
			}
		};
		/* 설정한 내용대로 정렬 (sort)
		 * 반대차순 정렬의 경우, Collections.reserse(ArrayOneRec); */ 
		Collections.sort(ArrayOneRec, criteriaForComparison);
	}
	
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

}
