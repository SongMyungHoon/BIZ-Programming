package chap5RealPractice;

public class K26_p6CalendarPrint {
	public static void main(String[] args) {
		// 달력 출력하기
		int startDayOfYear = 3;
		int startDayOfMonth = startDayOfYear;
		
		int[] lastDayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		int dayCount;
		int day;
		for(int month = 1; month < 13; month++) {
			System.out.printf("%9s%2d월\n"," ",month);
			System.out.printf("======================\n");
			System.out.printf(" 일 월 화 수 목 금 토 \n");
			dayCount = 0;
			day = 1;
			// 1월의 경우, startDayOfMonth(3) + lastDayOfMonth(31) + 1 = 35
			while(dayCount <= startDayOfMonth + lastDayOfMonth[month - 1]) {
				if(dayCount <= startDayOfMonth && startDayOfMonth != 6) {
					System.out.printf("%3s", " ");
				} else if(day <= lastDayOfMonth[month - 1]){
					System.out.printf("%3d", day);
					day++;
				} 
				if(dayCount == startDayOfMonth + lastDayOfMonth[month - 1]) {
					break;
				} else {
					dayCount++;
					if(dayCount % 7 == 0) {
						if(dayCount != startDayOfMonth + lastDayOfMonth[month - 1])
							System.out.printf("\n");
					}
				}
			}
			startDayOfMonth = dayCount % 7;
			System.out.print("\n");
			if(startDayOfMonth == 0) {
				System.out.printf("\n");
			}
		}
	}
}