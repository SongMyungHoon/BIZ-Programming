package chap4SelecIterArray;

public class K26_p18MonthlyDay {
	public static void main(String[] args) {
		/* 괜히 몇 줄 아끼려고 하는 것보다 직관적인 것이 좋다 
		 * 문장을 쓰는 것처럼 생각하고 프로그래밍 할 것.
		 * 코드의 가독성은 언제나 강조해도 지나치지 않다. */
		for(int k26_i = 1; k26_i < 13; k26_i++) {
			// i는 "월"을 의미, 1부터 12까지 12회 반복 설정\
			System.out.printf(" %d월 =>", k26_i);
			for(int k26_j = 1; k26_j < 32; k26_j++) {
				// j는 "일"을 의미, 1부터 31까지 31회 반복 설정
				if(k26_i == 1 && k26_j == 31) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 1(i) 월은 31(j)일까지
				} else if(k26_i == 2  && k26_j == 28) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 2(i) 월은 28(j)일까지
				} else if (k26_i == 3  && k26_j == 31) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 3(i) 월은 31(j)일까지
				} else if(k26_i == 4  && k26_j == 30) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 4(i) 월은 30(j)일까지
				} else if(k26_i == 5  && k26_j == 31) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 5(i) 월은 31(j)일까지
				} else if(k26_i == 6  && k26_j == 30) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 6(i) 월은 30(j)일까지
				} else if(k26_i == 7  && k26_j == 31) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 7(i) 월은 31(j)일까지
				} else if(k26_i == 8  && k26_j == 31) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 8(i) 월은 31(j)일까지
				} else if(k26_i == 9  && k26_j == 30) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 9(i) 월은 30(j)일까지
				} else if(k26_i == 10 && k26_j == 31) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 10(i)월은 31(j)일까지
				} else if(k26_i == 11 && k26_j == 30) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 11(i)월은 30(j)일까지
				} else if(k26_i == 12 && k26_j == 31) {
					System.out.printf("%d", k26_j);	// 말일이면 콤마 뺌
					break;	// 12(i)월은 31(j)일까지
				} 
				System.out.printf("%d, ", k26_j);	// 말일이 아니면 콤마 붙임
			}	// inner for loop end
			// "j" loop가 끝나 "일"이 모두 출력되고, "월"이 변경되기 전, 줄바꿈
			System.out.printf("\n");
		}	// outer for loop end
	}	// main method end
}	// K26_p18MonthlyDay Class end