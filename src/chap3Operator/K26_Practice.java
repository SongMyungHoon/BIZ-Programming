package chap3Operator;

public class K26_Practice {

	public static void main(String[] args) {
/*-----#1. 연산 후 대입 */
		int k26_ii;		// int형 변수 k26_ii 선언
		
		k26_ii = 1 + 2;	// k26_ii 변수에 1 + 2 의 계산 결과 3 을 대입
		// #1-1 : %d\n : %d 자리에 k26_ii(=3)의 값을 치환해서 넣고 문자열 출력 후 줄바꿈 수행
		System.out.printf("#1-1 : %d\n", k26_ii);
		
		k26_ii = 1 + 2 * 3;	// k26_ii 변수에 1 + 2 * 3 의 계산 결과 7 을 대입
		// #1-2 : %d\n : %d 자리에 k26_ii의 값(=7)을 치환해서 넣고 문자열 출력 후 줄바꿈 수행
		System.out.printf("#1-2 : %d\n", k26_ii);
		
		
/*----- #2. 누적하기, 합 구하기  */
		int k26_sum;	// C는 선언부가 코드 맨 상단부로 지정되어 있으나
		// C==, java는 필요 시 선언 가능, 하지만 깔끔하지 않다.
		
		k26_sum = 0;	// 누적해주는 변수 또는 loop에 들어가는 변수는 반드시 초기화
		
		// k26_i: loop 반복 1회 당 1부터 100까지 gradual increment
		for (int k26_i = 1; k26_i < 101; k26_i++) {
			// 앞 회 루프의 k26_sum에 k26_i를 더한 값을 새로운 k26_sum으로 저장
			k26_sum = k26_sum + k26_i;
		}
		// loop 결과 계산된 k26_sum 값 출력
		System.out.printf("#2 : %d\n", k26_sum);
		// k26_sum을 100으로 나누어 계산한 평균 값 출력
		System.out.printf("#2-2 : %d\n", k26_sum/100);
		
		// Integer data를 담을 Integer type array 선언
		int[] k26_intArray = {1, 2, 3, 4, 5};
		// k26_intArray element 합을 저장할 int형 변수 k26_intArraySum 선언
		int k26_intArraySum;
		// intArraySum 초기화
		k26_intArraySum = 0;

		/* Array의 index는 0부터 시작하므로 k26_i = 0부터 시작
		 * index 0부터 시작했으므로 for loop의 종료 조건 5 미만으로 설정
		 */ 
		for (int k26_i = 0; k26_i <5; k26_i++) {
			// 앞 회 루프의 k26_sum에 증가한 k26_i 값을 더한 값 = k26_sum으로 덮어씀
			k26_intArraySum = k26_intArraySum + k26_intArray[k26_i];
		}
		/* for loop가 종료되면 k26_intArraySum에는 1, 2, 3, 4, 5 의 합이 저장된다.
		 * 최종 계산된 k26_intArraySum을 console에 표준 출력
		 */
		System.out.printf("#2-3 : %d\n", k26_intArraySum);
		
		
/*----- #3. 정수형 변수의 나눗셈은 정수범위에서 버림처리  */
		k26_ii = 1000 / 3;
		System.out.printf("#3-1 : %3d\n", k26_ii);
		
		k26_ii = 1000 % 3;
		System.out.printf("#3-2 : %3d\n", k26_ii);
		
		for(int k26_i = 0; k26_i < 20; k26_i++) {
			System.out.printf("#3-3 : %3d  ", k26_i);
			if (((k26_i + 1) % 5) == 0) {
				System.out.printf("\n");
			}
		}
		
/*----  #4. 원하는 자릿수 반올림, 버림 처리 */
		
		k26_ii = 12345;	// 12345원을 10원 이하 버려서 처리하기
		int k26_j = (k26_ii / 10) * 10;
		System.out.printf("#4-1 : %d\n", k26_j);
		
		k26_ii = 12345;	// 12345원을 10원 이하 반올림 처리하기
		k26_j = ((k26_ii + 5) / 10) * 10;
		System.out.printf("#4-2 : %d\n", k26_j);
		
		k26_ii = 12344;	// 12345원을 10원 이하 반올림 처리하기
		k26_j = ((k26_ii + 5) / 10) * 10;	// 옳은 식인지 검증
		System.out.printf("#4-2 : %d\n", k26_j);
		
/*----  #4-X. 100 원 이하 버림,올림, 1000원 이하 버림, 반올림을 구현하라 */
		
/*----  #5. 소수점 이하에서는 어떻게 할까? */
		int k26_MyVal = 14 / 5; 
		System.out.printf("#5-1 : %d\n", k26_MyVal);
		
		/* 머리를 쓰면 저놈을 실수형 (float, double 형태로 형변환) 계산을 한 후 0.5를 더한 다음
		 * 정수형 형변환을 하면 반올림 처리가 됨
		 */
		
		double k26_MyValF;
		
		k26_MyValF = 14 / 5;
		System.out.printf("#5-2 : %f\n", k26_MyValF);
		
		k26_MyValF = 14.0 / 5;				// 한 개라도 실수 형태의 표시를 해야 결과가 실수 값이 나온다
		System.out.printf("#5-3 : %f\n", k26_MyValF);
		
		k26_MyValF = (14.0) / 5 + 0.5;		// 실수형 계산에서 0.5를 더해보자
		System.out.printf("#5-4 : %f\n", k26_MyValF);
		
		k26_MyValF = ((14.0) / 5 + 0.5);	// 실수형 계산을 하고 정수형 형변환을 하자.
		System.out.printf("#5-5 : %f\n", k26_MyValF);
		
/*----  #5. 소수점 이하에서는 어떻게 할까? */
	}
}