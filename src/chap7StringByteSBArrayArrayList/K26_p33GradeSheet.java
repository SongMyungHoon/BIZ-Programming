package chap7StringByteSBArrayArrayList;

import java.text.SimpleDateFormat;
import java.util.*;

class K26_p33OneRec {
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
	public K26_p33OneRec(int student_id, String k26_name
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

public class K26_p33GradeSheet {
	
	// OneRec Class type을 data object로 하는 ArrayList: ArrayOneRec instance 선언
	static ArrayList<K26_p33OneRec> k26_ArrayOneRec = new ArrayList<>();
	
	static int k26_pageSumKor = 0;	// page 별 국어 총점을 저장할 int형 class field 선언
	static int k26_pageSumEng = 0;	// page 별 영어 총점을 저장할 int형 class field 선언
	static int k26_pageSumMat = 0;	// page 별 수학 총점을 저장할 int형 class field 선언
	static int k26_pageTotalSum = 0;// page 별 전 과목 총점을 저장할 int형 class field 선언
	
	static int k26_totalSumKor = 0; // 국어 누적 총점을 저장할 int형 class field 선언
	static int k26_totalSumEng = 0;	// 영어 누적 총점을 저장할 int형 class field 선언
	static int k26_totalSumMat = 0;	// 수학 누적 총점을 저장할 int형 class field 선언
	static int k26_totalSum = 0;	// 전 과목 누적 총점을 저장할 int형 class field 선언
	
	static int k26_iPerson = 200;	// 집계할 학생의 수를 저장할 int 형 class field 선언
	
	public static void main(String[] args) {
		k26_dataSet();			// K26_p33OneRec type data를 선언하고 field 값을 임의로 저장
		
		int k26_numCount = 0;	// 누적 집계 학생 수를 저장할 int형 변수 선언
		int k26_page = 1;		// page 수를 count할 int형 변수 선언
		boolean k26_whileIteration = true;	// while문 반복 조건
		int k26_forIterationLimit = 0;		// for문 반복 횟수
		int k26_numberPerPage = 1;			// page 당 출력되는 학생 수
		
		// while문의 조건절에 true 들어감 : 무한 루프
		while(k26_whileIteration) {
			k26_headerPrint(k26_page);	// HEADER를 출력
			
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
				k26_itemPrint(k26_numCount);	// 학생의 정보를 출력하고
				k26_numCount++;	// numCount 값을 1 증가한다.
			}	// for loop end
			
			// page 별 국어 점수 총 합계를 집계 학생 국어 총점에 누적한다
			k26_totalSumKor += k26_pageSumKor;
			
			// page 별 영어 점수 총 합계를 집계 학생 영어 총점에 누적한다
			k26_totalSumEng += k26_pageSumEng;
			
			// page 별 수학 점수 총 합계를 집계 학생 수학 총점에 누적한다
			k26_totalSumMat += k26_pageSumMat;
			
			// page 별 총 점수를 집계 전체 총점에 누적한다
			k26_totalSum += k26_pageTotalSum;
			
			// TAIL 부분을 출력한다
			k26_tailPrint(k26_forIterationLimit, k26_numCount);
			k26_pageSumKor = 0;		// page 별 국어 총점 초기화
			k26_pageSumEng = 0;		// page 별 영어 총점 초기화
			k26_pageSumMat = 0;		// page 별 수학 총점 초기화
			k26_pageTotalSum = 0;	// page 별 총점 값 초기화
			k26_page++;				// page를 1 증가시킨다
			
			if(k26_numCount >= k26_iPerson) {	// 집계 인원이 전체 인원에 해당하면
				break;	// while loop break
			} else {	// 아니라면, 줄바꿈을 수행한다.
				System.out.printf("\n");
			}
		}	// while loop end
	}	// main method end
	
	// 데이터 만들기
	public static void k26_dataSet() {
		
		// 전체 학생 수만큼 for loop 반복 설정
		for(int k26_i = 0; k26_i < k26_iPerson; k26_i++) {
			String k26_name = String.format("홍길%02d", k26_i + 1);	// 이름 만들기
			int k26_kor = (int) (Math.random() * 100);			// 국어점수 만들기
			int k26_eng = (int) (Math.random() * 100);			// 영어점수 만들기
			int k26_mat = (int) (Math.random() * 100);			// 수학점수 만들기
		
			// 하나의  OneRec 클래스를 생성 후 ArrayList에 집어넣었다.
			k26_ArrayOneRec.add(new K26_p33OneRec(k26_i,k26_name,k26_kor,k26_eng,k26_mat)); 
		}	// for loop end
	}	// k26_dataSet end
	
	// HEADR 출력
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
	public static void k26_itemPrint(int k26_i) {
		K26_p33OneRec k26_record;	// K26_OneRec class type instance 선언
		
		// ArrayOneRec의 i번째 data를 k26_record에 저장
		k26_record = k26_ArrayOneRec.get(k26_i);
		
		if(k26_i < 999 ) {	// index가 999 미만이라면(번호 1000 미만이라면)
			
			// student_id, name, kor, eng, mat, sum, ave 순서로 출력
			System.out.printf("%03d%6s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_record.k26_student_id() + 1," ",k26_record.k26_name()," ",k26_record.k26_kor()," "
					,k26_record.k26_eng()," ",k26_record.k26_mat()," ",k26_record.k26_sum()," ", (int) k26_record.k26_ave());
		
		} else if(k26_i < 9999) {	// index가 9999 미만라면(번호 10000 미만이라면)
			
			// student_id, name, kor, eng, mat, sum, ave 순서로 출력
			System.out.printf("%d%5s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_record.k26_student_id() + 1," ",k26_record.k26_name()," ",k26_record.k26_kor()," "
					,k26_record.k26_eng()," ",k26_record.k26_mat()," ",k26_record.k26_sum()," ", (int) k26_record.k26_ave());
		
		} else if(k26_i < 99999) {	// index가 99999 미만이라면(번호 100000 미만이라면)
			
			// student_id, name, kor, eng, mat, sum, ave 순서로 출력
			System.out.printf("%d%4s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_record.k26_student_id() + 1," ",k26_record.k26_name()," ",k26_record.k26_kor()," "
					,k26_record.k26_eng()," ",k26_record.k26_mat()," ",k26_record.k26_sum()," ", (int) k26_record.k26_ave());
		}
		
		// page당 국어 총점에 해당 record의 국어 점수를 누적한다.
		k26_pageSumKor += k26_record.k26_kor();
		
		// page당 영어 총점에 해당 record의 영어 점수를 누적한다.
		k26_pageSumEng += k26_record.k26_eng();
		
		// page당 수학 총점에 해당 record의 수학 점수를 누적한다.
		k26_pageSumMat += k26_record.k26_mat();
		
		// page당 총점에 해당 record의 총 점수를 누적한다.
		k26_pageTotalSum += k26_record.k26_sum();
	}	// k26_itemPrint method end
	
	// TAIL 출력
	public static void k26_tailPrint(int k26_forIterationLimit, int k26_numCount) {
		
		System.out.printf("========================================================\n");
		System.out.println("현재페이지");
		
		// page 당 국어 점수 총 합계, page 당 영어 점수 총 합계, 
		// page 당 수학 점수 총 합계, page 당 총 점 합계, page 당 과목 총점 평균 순으로 화면에 출력한다  
		System.out.printf("합계%16s%6d%s%6d%s%6d%s%7d%s%7d\n"," ",k26_pageSumKor," ",k26_pageSumEng
				," ",k26_pageSumMat," ",k26_pageTotalSum," ",k26_pageTotalSum/3);
		
		// 해당 page에서 국어 평균 점수, 영어 평균 점수, 수학 평균 점수, 총점 평균 점수, 평균 점수 순으로 화면에 출력한다
		System.out.printf("평균%16s%6.1f%s%6.1f%s%6.1f%s%7.1f%s%7.1f\n"," ",(double)k26_pageSumKor/k26_forIterationLimit," "
				,(double)k26_pageSumEng/k26_forIterationLimit," ",(double)k26_pageSumMat/k26_forIterationLimit," "
				,(double)k26_pageTotalSum/k26_forIterationLimit," ",(double)k26_pageTotalSum/k26_forIterationLimit/3);
		System.out.printf("========================================================\n");
		System.out.println("누적페이지");
		
		// 누적 국어 점수 총 합계, 누적 영어 점수 총 합계, 
		// 누적 수학 점수 총 합계, 누적 총 점 합계, 누적 과목별 총점 평균 순으로 화면에 출력한다.
		System.out.printf("합계%22d%7d%7d%8d%8d\n",k26_totalSumKor,k26_totalSumEng
				,k26_totalSumMat,k26_totalSum,k26_totalSum/3);
		
		// 누적 집계에서 국어 평균 점수, 영어 평균 점수, 수학 평균 점수, 총점 평균 점수, 평균 점수 순으로 화면에 출력한다
		System.out.printf("평균%22.1f%7.1f%7.1f%8.1f%8.1f\n",(double)k26_totalSumKor/k26_numCount
				,(double)k26_totalSumEng/k26_numCount,(double)k26_totalSumMat/k26_numCount,(double)k26_totalSum/k26_numCount
				,(double)k26_totalSum/k26_numCount/3);
	}	// k26_tailPrint method end
}	// K26_p33GradeSheet Class end
