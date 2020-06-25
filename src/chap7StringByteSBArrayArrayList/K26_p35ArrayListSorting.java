package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class K26_p35ArrayListSorting {
	
	static ArrayList<K26_p30OneRec> k26_ArrayOneRec = new ArrayList<>();
	static int k26_sumKor = 0;
	static int k26_sumEng = 0;
	static int k26_sumMat = 0;
	static int k26_sumSum = 0;
	static double k26_sumAve = 0;
	static final int k26_iPerson = 20;

	public static void main(String[] args) {
		k26_dataSet();		// 데이터 생성
		k26_dataSort();		// 데이터 정렬
		k26_HeaderPrint();	// HEADER 출력
		for(int k26_i = 0; k26_i < k26_ArrayOneRec.size(); k26_i++) {
			k26_ItemPrint(k26_i);	// BODY 출력
		}
		k26_TailPrint();	// TAIL 출력
	}
	
	public static void k26_dataSort() {
		// 비교 기준에 사용할 Comparator type class를 익명 클래스로 생성 (anonymous class)
		Comparator<K26_p30OneRec> k26_criteriaForComparison = new Comparator<K26_p30OneRec>() {
			// 총점 (sum())을 기준으로 sort하는 경우
			public int compare(K26_p30OneRec k26_record1, K26_p30OneRec k26_record2) {
				/* 문자형 비교의 경우
				 * return (String.valueOf(record1.sum().compareTo(String.valueOf(record2.sum())); 
				 * */
				return (k26_record2.k26_sum() - k26_record1.k26_sum());
			}
		};
		/* 설정한 내용대로 정렬 (sort)
		 * 반대차순 정렬의 경우, Collections.reserse(ArrayOneRec); */ 
		Collections.sort(k26_ArrayOneRec, k26_criteriaForComparison);
	}
	
	// 데이터 만들기
	public static void k26_dataSet() {
		for(int k26_i = 0; k26_i < k26_iPerson; k26_i++) {
			String k26_name = String.format("홍길%02d", k26_i);	// 이름 만들기
			int k26_kor = (int) (Math.random() * 100);		// 국어점수 만들기
			int k26_eng = (int) (Math.random() * 100);		// 영어점수 만들기
			int k26_mat = (int) (Math.random() * 100);		// 수학점수 만들기
			// 하나의  OneRec 클래스를 생성 후 ArrayList에 집어넣었다.
			k26_ArrayOneRec.add(new K26_p30OneRec(k26_i,k26_name,k26_kor,k26_eng,k26_mat)); 
		}
	}
	
	// 헤더 인쇄
	public static void k26_HeaderPrint() {
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("%2s %3s  %2s %2s %2s %2s   %2s\n"
				, "번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		
	}
	
	// 내용 인쇄
	public static void k26_ItemPrint(int k26_i) {
		K26_p30OneRec k26_record;
		
		k26_record = k26_ArrayOneRec.get(k26_i);
		System.out.printf("%4d %4s %3d %4d %4d %5d %6.2f\n"
				,k26_record.k26_student_id(),k26_record.k26_name(),k26_record.k26_kor()
				,k26_record.k26_eng(),k26_record.k26_mat(),k26_record.k26_sum(),k26_record.k26_ave());
		
		k26_sumKor += k26_record.k26_kor();
		k26_sumEng += k26_record.k26_eng();
		k26_sumMat += k26_record.k26_mat();
		k26_sumSum += k26_record.k26_sum();
		k26_sumAve += k26_record.k26_ave();
	}
	
	// 꼬리 인쇄
	public static void k26_TailPrint() {
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("  국어합계 %4d       국어평균: %6.2f\n", k26_sumKor,k26_sumKor/(double)k26_ArrayOneRec.size());
		System.out.printf("  영어합계 %4d       영어평균: %6.2f\n", k26_sumEng,k26_sumEng/(double)k26_ArrayOneRec.size());
		System.out.printf("  수학합계 %4d       수학평균: %6.2f\n", k26_sumMat,k26_sumMat/(double)k26_ArrayOneRec.size());
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("  반평균합계 %4d       반평균: %6.2f\n", (int)k26_sumAve,k26_sumAve/(double)k26_ArrayOneRec.size());
	}
}
