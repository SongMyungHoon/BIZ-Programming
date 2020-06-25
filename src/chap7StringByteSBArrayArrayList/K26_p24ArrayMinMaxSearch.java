package chap7StringByteSBArrayArrayList;

public class K26_p24ArrayMinMaxSearch {

	public static void main(String[] args) {
		// int type 변수를 element로 받는 정수형 배열 선언하고, 값을 저장
		int[] k26_iArray = {1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		// iArray의 length 만큼 for loop의 반복 조건을 설정
		for(int k26_i = 0; k26_i < k26_iArray.length; k26_i++) {
			// iArray의 index와 해당 index에 대응하는 배열 요소의 값을 console에 출력
			System.out.printf("iArray[%d] = %d\n", k26_i, k26_iArray[k26_i]);
		}	// for loop end
		
		// iArray의 값 중 가장 큰 값을 저장하기 위한 정수형 변수 선언
		int k26_iMax = k26_iArray[0];
		// iArray의 값중 가장 큰 값의 index를 저장할 정수형 변수 선언
		int k26_iMaxPt = 0;
		// iArray의 length 만큼 for loop의 반복 조건을 설정
		for(int k26_i = 0; k26_i < k26_iArray.length; k26_i++) {
			// 앞쪽 index의 element 중 가장 큰 값보다 현재 값이 큰 경우 iMax 값 변경
			if(k26_iMax < k26_iArray[k26_i]) {
				k26_iMax = k26_iArray[k26_i];
				k26_iMaxPt = k26_i;	// 해당 element의 index값 저장
			}	// if end
		}	// for loop end
		// iMaxPt, iMax 값 console에 출력
		System.out.printf("MAX : iArray[%d] = %d\n", k26_iMaxPt, k26_iMax);
	}	// main method end
}	// K26_p24ArrayMinMaxSearch Class end
