package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;

public class K26_p27ArrayList {

	public static void main(String[] args) {
		ArrayList k26_iAL = new ArrayList();
		k26_iAL.add("abc");
		k26_iAL.add("abcd");
		k26_iAL.add("efga");
		k26_iAL.add("가나다0");
		k26_iAL.add("1234");
		k26_iAL.add("12rk34");
		/* iAL.add(356)
		 * : ArrayList에 String을 element로 넣으려고 하면
		 * */ 
		
		System.out.printf("*****************************\n");
		System.out.printf(" 시작 Array Size %d\n", k26_iAL.size());
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.set(3, "가라라라");	// 3번 ArrayList element 변경
		System.out.printf("*****************************\n");
		System.out.printf(" 내용변경 Array Size %d\n", k26_iAL.size());
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.remove(4);	// 4번 ArrayList element 삭제
		System.out.printf("*****************************\n");
		System.out.printf(" 내용변경 Array Size %d\n", k26_iAL.size());
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.sort(null);
		System.out.printf("*****************************\n");
		System.out.printf(" List Sort Array Size %d\n", k26_iAL.size());
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
		
		k26_iAL.clear();	// ArrayList 삭제
		System.out.printf("*****************************\n");
		System.out.printf(" 전부 삭제 Array Size %d\n", k26_iAL.size());
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++)
			System.out.printf(" ArrayList %d = %s\n", k26_i, k26_iAL.get(k26_i));
	}
}