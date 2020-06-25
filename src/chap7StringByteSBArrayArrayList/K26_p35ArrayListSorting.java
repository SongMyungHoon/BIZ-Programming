package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class K26_p35OneRec {
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
	public K26_p35OneRec(int student_id, String k26_name
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
}

public class K26_p35ArrayListSorting {
	
	// OneRec Class type을 data object로 하는 ArrayList: ArrayOneRec instance 선언
	static ArrayList<K26_p35OneRec> k26_ArrayOneRec = new ArrayList<>();
	static int k26_sumKor = 0;			// 국어 점수 총 합계를 저장할 int형 class field 선언
	static int k26_sumEng = 0;			// 영어 점수 총 합계를 저장할 int형 class field 선언
	static int k26_sumMat = 0;			// 수학 점수 총 합계를 저장할 int형 class field 선언
	static int k26_sumSum = 0;			// 전체 인원 총점 합계를 저장할 int형 class field 선언
	static double k26_sumAve = 0;		// 전체 인원의 총 평균 점수 값을 저장할 int형 class field 선언
	static final int k26_iPerson = 20;	// 총 인원 수를 Class constant로 선언해 초기화

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
		Comparator<K26_p35OneRec> k26_criteriaForComparison = new Comparator<K26_p35OneRec>() {
			// 총점 (sum())을 기준으로 sort하는 경우
			@Override
			public int compare(K26_p35OneRec k26_record1, K26_p35OneRec k26_record2) {
				/* 문자형 비교의 경우
				 * return (String.valueOf(record1.sum().compareTo(String.valueOf(record2.sum())); 
				 * */
				return (k26_record2.k26_sum() - k26_record1.k26_sum());
			}
		};
		/* 설정한 내용대로 정렬 (sort)
		 * 반대차순 정렬의 경우, Collections.reserse(ArrayOneRec); */ 
		Collections.sort(k26_ArrayOneRec, k26_criteriaForComparison);
	}	// k26_dataSort method end
	
	// 데이터 만들기
	public static void k26_dataSet() {
		// 총 인원수 만큼 for문 반복
		for(int k26_i = 0; k26_i < k26_iPerson; k26_i++) {
			String k26_name = String.format("홍길%02d", k26_i);	// // 총 인원수 만큼 for문 반복
			int k26_kor = (int) (Math.random() * 100);			// 국어점수 난수로 만들기
			int k26_eng = (int) (Math.random() * 100);			// 영어점수 난수로 만들기
			int k26_mat = (int) (Math.random() * 100);			// 수학점수 난수로 만들기
			
			// 하나의  OneRec 클래스를 생성 후 ArrayList에 add한다.
			k26_ArrayOneRec.add(new K26_p35OneRec(k26_i,k26_name,k26_kor,k26_eng,k26_mat)); 
		}	// for loop end
	}	// k26_dataSet method end
	
	// HEAR부분을 출력하는 method
	public static void k26_HeaderPrint() {
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		System.out.printf("%2s %3s  %2s %2s %2s %2s   %2s\n"
				, "번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
	}	// k26_HeaderPrint method end
	
	// 내용부븐을 출력하는 method
	public static void k26_ItemPrint(int k26_i) {
		K26_p35OneRec k26_record;	// 출력할 OneRec class type instance 선언
		
		// static memory에 있는 class field인 ArrayOneRec의 i번째 data object를 불러와 record 변수에 저장
		k26_record = k26_ArrayOneRec.get(k26_i);
		System.out.printf("%4d %4s %3d %4d %4d %5d %6.2f\n"	// 번호, 이름, 국어, 영어, 수학, 합계, 평균 순으로 값을 출력한다.
				,k26_record.k26_student_id(),k26_record.k26_name(),k26_record.k26_kor()
				,k26_record.k26_eng(),k26_record.k26_mat(),k26_record.k26_sum(),k26_record.k26_ave());
		
		k26_sumKor += k26_record.k26_kor();	// record의 국어 점수를 class field인 sumKor에 누적 덧셈한다.
		k26_sumEng += k26_record.k26_eng();	// record의 영어 점수를 class field인 sumEng에 누적 덧셈한다.
		k26_sumMat += k26_record.k26_mat();	// record의 수학 점수를 class field인 sumMat에 누적 덧셈한다.
		k26_sumSum += k26_record.k26_sum();	// record의 총 점수를 class field인 sumSum에 누적 덧셈한다.
		k26_sumAve += k26_record.k26_ave();	// record의 평균 점수를 class field인 sumAve에 누적 덧셈한다.
	}	// k26_ItemPrint method end
	
	// TAIL 출력
	public static void k26_TailPrint() {
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		
		// 모든 학생의 국어 총점, 평균 값 출력
		System.out.printf("  국어합계 %4d       국어평균: %6.2f\n", k26_sumKor,k26_sumKor/(double)k26_ArrayOneRec.size());
		// 모든 학생의 영어 총점, 평균 값 출력
		System.out.printf("  영어합계 %4d       영어평균: %6.2f\n", k26_sumEng,k26_sumEng/(double)k26_ArrayOneRec.size());
		// 모든 학생의 수학 총점, 평균 값 출력
		System.out.printf("  수학합계 %4d       수학평균: %6.2f\n", k26_sumMat,k26_sumMat/(double)k26_ArrayOneRec.size());
		System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		// 과목 별 반 전체 총점 평균 값, 학생 별 전체 평균 값 출력 
		System.out.printf("  반평균합계 %4d       반평균: %6.2f\n", (int)k26_sumAve,k26_sumAve/(double)k26_ArrayOneRec.size());
	}// k26_TailPrint method end
}	// K26_p35ArrayListSorting Class end
