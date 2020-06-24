package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;

public class K26_p27ArrayList {

	public static void main(String[] args) {
		ArrayList iAL = new ArrayList();
		iAL.add("abc");
		iAL.add("abcd");
		iAL.add("efga");
		iAL.add("가나다0");
		iAL.add("1234");
		iAL.add("12rk34");
		/* iAL.add(356)
		 * : ArrayList에 String을 element로 넣으려고 하면
		 * */ 
		
		System.out.printf("*****************************\n");
		System.out.printf(" 시작 Array Size %d\n", iAL.size());
		for(int i = 0; i < iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.set(3, "가라라라");	// 3번 ArrayList element 변경
		System.out.printf("*****************************\n");
		System.out.printf(" 내용변경 Array Size %d\n", iAL.size());
		for(int i = 0; i < iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.remove(4);	// 4번 ArrayList element 삭제
		System.out.printf("*****************************\n");
		System.out.printf(" 내용변경 Array Size %d\n", iAL.size());
		for(int i = 0; i < iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.sort(null);
		System.out.printf("*****************************\n");
		System.out.printf(" List Sort Array Size %d\n", iAL.size());
		for(int i = 0; i < iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.clear();	// ArrayList 삭제
		System.out.printf("*****************************\n");
		System.out.printf(" 전부 삭제 Array Size %d\n", iAL.size());
		for(int i = 0; i < iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
	}
}