package chap5RealPractice;

public class K26_p6CalendarPrint {

	public static void main(String[] args) {
		// 달력 출력하기
		int startDayOfYear = 3;
		int countDayOfYear = startDayOfYear;

		int[] lastDayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] strDayOfWeek = {"일","월","화","수","목","금","토"};
		int startDayOfMonth = 0;
		for(int month = 1; month < 13; month++) {
			System.out.printf("\n%9s%2d월\n"," ",month);
			System.out.printf("======================\n");
			System.out.printf(" 일 월 화 수 목 금 토 \n");
			for(int weekOfMonth = 1;
					weekOfMonth < (countDayOfYear + lastDayOfMonth[month - 1]) / 7;
					weekOfMonth++) {
				if(month == 1) {
					System.out.printf("%3s%3s%3s%3s%3s%3s%3s\n"," "," "," ","수","목","금","토");
				} else {
					for(int dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++) {
						System.out.printf("%2s",strDayOfWeek[dayOfWeek]);
						if(dayOfWeek == 6) {
							System.out.printf("\n");
						}
					}
				}
			}
			countDayOfYear += lastDayOfMonth[month - 1];
		}
	}

}
