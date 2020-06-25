package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;

public class K26_p27ArrayList {

	public static void main(String[] args) {
		ArrayList k26_iAL = new ArrayList();	// ArrayList type의 instance 선언
		k26_iAL.add("abc");		// iAL에 "abc" 저장
		k26_iAL.add("abcd");	// iAL에 "abcd" 저장
		k26_iAL.add("efga");	// iAL에 "efga" 저장
		k26_iAL.add("가나다0");	// iAL에 "가나다0" 저장
		k26_iAL.add("1234");	// iAL에 "1234" 저장
		k26_iAL.add("12rk34");	// iAL에 "12rk34" 저장
		/* iAL.add(356)
		 * : ArrayList에 저장되는 element의 type은 하나만 가능 (String만) */ 
		
		System.out.printf("*****************************\n");
		System.out.printf(" 시작 Array Size %d\n", k26_iAL.size());	// iAL의 Size를 출력
		// ArrayList의 index와 해당 index의 element 값 모두 출력
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.set(3, "가라라라");	// ArrayList의 index = 3의 element 변경
		System.out.printf("*****************************\n");
		System.out.printf(" 내용변경 Array Size %d\n", k26_iAL.size());	// iAL의 Size를 출력
		// ArrayList의 index와 해당 index의 element 값 모두 출력
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.remove(4);	// 4번 ArrayList element 삭제
		System.out.printf("*****************************\n");
		System.out.printf(" 내용변경 Array Size %d\n", k26_iAL.size());	// iAL의 Size를 출력
		// ArrayList의 index와 해당 index의 element 값 모두 출력
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.sort(null);
		System.out.printf("*****************************\n");
		System.out.printf(" List Sort Array Size %d\n", k26_iAL.size());	// iAL의 Size를 출력
		// ArrayList의 index와 해당 index의 element 값 모두 출력
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.clear();	// ArrayList 삭제
		System.out.printf("*****************************\n");
		System.out.printf(" 전부 삭제 Array Size %d\n", k26_iAL.size());	// iAL의 Size를 출력
		// iAL의 내용이 모두 삭제되었으므로 iAL.size() == 0 이고, for문은 실행되지 않는다.
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)	// for 문 실행 안됨
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
	}
}