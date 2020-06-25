package chap7StringByteSBArrayArrayList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class K26_p36GradeSheetSort {

	static ArrayList<K26_p30OneRec> k26_ArrayOneRec = new ArrayList<>();
	static int k26_pageSumKor = 0;
	static int k26_pageSumEng = 0;
	static int k26_pageSumMat = 0;
	static int k26_pageTotalSum = 0;
	static int k26_pageAvg = 0;
	static int k26_totalSumKor = 0;
	static int k26_totalSumEng = 0;
	static int k26_totalSumMat = 0;
	static int k26_totalSum = 0;
	static double k26_totalAvg = 0;
	static int k26_iPerson = 200;
	
	public static void main(String[] args) {
		k26_dataSet();
		k26_dataSort();
		int k26_numCount = 0;
		int k26_page = 1;
		boolean k26_whileIteration = true;
		int k26_forIterationLimit = 0;

		while(k26_whileIteration) {
			k26_pageTotalSum = 0;
			k26_pageAvg = 0;
			k26_headerPrint(k26_page);
			if((double) (k26_iPerson - k26_numCount) / 30 >= 1) {
				k26_forIterationLimit = 30;
			} else if((k26_iPerson - k26_numCount) % 30 != 0) {
				k26_forIterationLimit = (k26_iPerson - k26_numCount) % 30;
			} else {
				System.out.println("Error occur] forIterationLimit == 0");
				break;
			}
			for(int k26_recordPerPage = 0; k26_recordPerPage < k26_forIterationLimit; k26_recordPerPage++) {
				k26_itemPrint(k26_numCount);
				k26_numCount++;
			}
			
			k26_pageAvg = k26_pageTotalSum / k26_forIterationLimit;
			
			k26_totalSumKor += k26_pageSumKor;
			k26_totalSumEng += k26_pageSumEng;
			k26_totalSumMat += k26_pageSumMat;
			
			k26_totalSum += k26_pageTotalSum;
			k26_totalAvg = k26_totalSum / k26_forIterationLimit;
			k26_tailPrint(k26_forIterationLimit, k26_numCount);
			k26_pageSumKor = 0;
			k26_pageSumEng = 0;
			k26_pageSumMat = 0;
			k26_page++;
			if(k26_numCount >= k26_iPerson) {
				break;
			} else {
				System.out.printf("\n");
			}
		}
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
			String k26_name = String.format("홍길%02d", k26_i + 1);	// 이름 만들기
			int k26_kor = (int) (Math.random() * 100);			// 국어점수 만들기
			int k26_eng = (int) (Math.random() * 100);			// 영어점수 만들기
			int k26_mat = (int) (Math.random() * 100);			// 수학점수 만들기
			// 하나의  OneRec 클래스를 생성 후 ArrayList에 집어넣었다.
			k26_ArrayOneRec.add(new K26_p30OneRec(k26_i,k26_name,k26_kor,k26_eng,k26_mat)); 
		}
	}
	// HEADR 출력
	public static void k26_headerPrint(int k26_page) {
		SimpleDateFormat k26_sdfY4M1d2HHmmssColon = new SimpleDateFormat("YYYY.M.dd HH:mm:ss");
		Calendar k26_calendar = Calendar.getInstance();
		System.out.printf("%23s성적집계표\n\n", " ");
		System.out.printf("PAGE: %-21s출력일자 : %s\n", k26_page
				,k26_sdfY4M1d2HHmmssColon.format(k26_calendar.getTime()));
		System.out.printf("========================================================\n");
		System.out.printf("번호%5s이름%9s국어%3s영어%3s수학%4s총점%4s평균\n"," "," "," "," "," "," ");
		System.out.printf("========================================================\n");
	}
	
	// 내용 인쇄
	public static void k26_itemPrint(int k26_i) {
		K26_p30OneRec k26_record;
		
		k26_record = k26_ArrayOneRec.get(k26_i);
		if(k26_i < 999 ) {
			System.out.printf("%03d%6s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_record.k26_student_id() + 1," ",k26_record.k26_name()," ",k26_record.k26_kor()," "
					,k26_record.k26_eng()," ",k26_record.k26_mat()," ",k26_record.k26_sum()," ", (int) k26_record.k26_ave());
		} else if(k26_i < 9999) {
			System.out.printf("%d%5s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_record.k26_student_id() + 1," ",k26_record.k26_name()," ",k26_record.k26_kor()," "
					,k26_record.k26_eng()," ",k26_record.k26_mat()," ",k26_record.k26_sum()," ", (int) k26_record.k26_ave());
		} else if(k26_i < 99999) {
			System.out.printf("%d%4s%-8s%4s%3d%3s%4d%3s%4d%5s%3d%4s%4d\n"
					,k26_record.k26_student_id() + 1," ",k26_record.k26_name()," ",k26_record.k26_kor()," "
					,k26_record.k26_eng()," ",k26_record.k26_mat()," ",k26_record.k26_sum()," ", (int) k26_record.k26_ave());
		}
		
		k26_pageSumKor += k26_record.k26_kor();
		k26_pageSumEng += k26_record.k26_eng();
		k26_pageSumMat += k26_record.k26_mat();
		k26_pageTotalSum += k26_record.k26_sum();
	}
	
	// TAIL 출력
	public static void k26_tailPrint(int k26_forIterationLimit, int k26_numCount) {
		
		System.out.printf("========================================================\n");
		System.out.println("현재페이지");
		System.out.printf("합계%16s%6d%s%6d%s%6d%s%7d%s%7d\n"," ",k26_pageSumKor," ",k26_pageSumEng
				," ",k26_pageSumMat," ",k26_pageTotalSum," ",k26_pageTotalSum/3);
		System.out.printf("평균%16s%6.1f%s%6.1f%s%6.1f%s%7.1f%s%7.1f\n"," ",(double)k26_pageSumKor/k26_forIterationLimit," "
				,(double)k26_pageSumEng/k26_forIterationLimit," ",(double)k26_pageSumMat/k26_forIterationLimit," "
				,(double)k26_pageTotalSum/k26_forIterationLimit," ",(double)k26_pageTotalSum/k26_forIterationLimit/3);
		System.out.printf("========================================================\n");
		System.out.println("누적페이지");
		System.out.printf("합계%22d%7d%7d%8d%8d\n",k26_totalSumKor,k26_totalSumEng
				,k26_totalSumMat,k26_totalSum,k26_totalSum/3);
		System.out.printf("평균%22.1f%7.1f%7.1f%8.1f%8.1f\n",(double)k26_totalSumKor/k26_numCount
				,(double)k26_totalSumEng/k26_numCount,(double)k26_totalSumMat/k26_numCount,(double)k26_totalSum/k26_numCount
				,(double)k26_totalSum/k26_numCount/3);
	}
}
