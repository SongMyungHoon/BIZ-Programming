package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;

public class K26_p30Main {
	
	static ArrayList<K26_p30OneRec> k26_ArrayOneRec = new ArrayList<>();
	static int k26_sumKor = 0;
	static int k26_sumEng = 0;
	static int k26_sumMat = 0;
	static int k26_sumSum = 0;
	static double k26_sumAve = 0;
	static final int k26_iPerson = 20;
	
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
		System.out.printf("  국어  합계 %6d   국어평균: %6.2f\n", k26_sumKor,k26_sumKor/(double)k26_ArrayOneRec.size());
		System.out.printf("  영어  합계 %6d   영어평균: %6.2f\n", k26_sumEng,k26_sumEng/(double)k26_ArrayOneRec.size());
		System.out.printf("  수학  합계 %6d   수학평균: %6.2f\n", k26_sumMat,k26_sumMat/(double)k26_ArrayOneRec.size());
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("  반평균합계 %4d     반  평균: %6.2f\n", (int)k26_sumAve,k26_sumAve/(double)k26_ArrayOneRec.size());
	}
	
	public static void main(String[] args) {
			k26_dataSet();		// 데이터 세팅
			k26_HeaderPrint();	// 헤더 인쇄
			for(int k26_i = 0; k26_i < k26_ArrayOneRec.size(); k26_i++) {	// 내용 인쇄
				k26_ItemPrint(k26_i);
			}
			k26_TailPrint();	// 꼬리 인쇄
	}
}
