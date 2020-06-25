package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;

public class K26_p28ArrayLIst2 {
	public static void main(String[] args) {
		// iTest 값의 최대 범위 설정하기 위한 int 형 변수 선언
		int k26_iTestMAX = 1000000;
		// ArrayList type instance, iAL 선언
		ArrayList k26_iAL = new ArrayList();
		
		// 0 ~ (iTestMAX - 1)까지 iTestMAX 번 for문 반복
		for(int k26_i = 0; k26_i < k26_iTestMAX; k26_i++) {
			// Math.random() : 0<= x < 1 범위 무작위 난수 생성
			// 0 <= iAL(i) < iTestMAX 범위의 data object를 iAL ArrayList에 add
			k26_iAL.add( (int)(Math.random() * 1000000) );
		}	// for loop end
		// iAL.size()(=iTestMAX) 번 만큼 for문 반복 
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++) {
			// iAL의 각 data object의 index와 value를 모두 console에 출력
			System.out.printf(" ArrayList %d = %d\n", k26_i, k26_iAL.get(k26_i));
		}	// for loop end
			
		System.out.printf("*****************************\n");
		
		/* iAL의 data object가 Comparable을 implement했다면 sort method의 argument로
		 * null을 입력해 오름차순 정렬할 수 있다.
		 * iAL의 data object가 int 이므로 오름차순 정렬이 가능하다. */
		k26_iAL.sort(null);
		// iAL.size()(=iTestMAX) 번 만큼 for문 반복
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++) {
			// 오름차순 정렬된 iAL의 각 data object의 index와 value를 모두 console에 출력
			System.out.printf(" ArrayList %d = %d\n", k26_i, k26_iAL.get(k26_i));
		}	// for loop end
	}	// main method end
}	// K26_p28ArrayLiust2 Class end
