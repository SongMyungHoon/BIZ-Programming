package chap5RealPractice;

public class K26_p6CalendarPrint {
	public static void main(String[] args) {
		// 달력 출력하기
		int startDayOfYear = 3;	// 2020년 1월 1일 : 수요일
		int startDayOfMonth = startDayOfYear;	// 20년 1월 1일 시작일로 설정
		// 매 달 말일을 int array에 저장
		int[] lastDayOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
		int dayCount;	// start day의 요일 앞의 공백을 포함하여 count하기 위한 정수형 변수
		int day;		// monthly day를 저장하는 정수형 변수
		for(int month = 1; month < 13; month++) {	// month for loop
			/*------------- <HEADER> -------------*/
			System.out.printf("%9s%2d월\n"," ",month);	// HEADER에 month를 출력
			System.out.printf("======================\n");
			System.out.printf(" 일 월 화 수 목 금 토 \n");	// 요일의 index : 0 ~ 6
			/*------------- </HEADER> -------------*/
			dayCount = 0;	// dayCount 0으로 초기화
			day = 1;		// 매달 day는 1부터 시작하므로 1로 초기화
			
			/* day while loop
			 * 1월의 경우, startDayOfMonth(2) + lastDayOfMonth(31) = 34 */
			while(dayCount <= startDayOfMonth + lastDayOfMonth[month - 1]) {
				
				/* dayCount가 startDayOfMonth 인 경우 : 전 달의 요일을 공백으로 표기하기 위한 조건
				 * startDayOfMonth != 6 : 전 달이 토요일로 끝나지 않는 경우 */
				if(dayCount <= startDayOfMonth && startDayOfMonth != 6) {
					System.out.printf("%3s", " ");	// 달력 시작일 앞 부분 공백 처리
				} else if(day <= lastDayOfMonth[month - 1]){
					System.out.printf("%3d", day);	// 달력에 날짜 출력
					day++;	// 날짜 출력 후 day 1 증가
				} 
				
				// while 반복이 종료될 때, 달력 한 달이 끝나므로 줄 바꿈
				if(dayCount == startDayOfMonth + lastDayOfMonth[month - 1]) {
					System.out.print("\n");
					break;	// 다음 달로 이동
				// day가 달의 말 일에 해당하더라도 달력 한 달이 끝나므로, 줄 바꿔주고
				} else if(day == lastDayOfMonth[month - 1] + 1) {
					System.out.print("\n");
					break;	// 다음 달로 이동
				} else {	// 달의 말 일이 아닌 경우
					dayCount++;	// dayCount를 증가시킨다
					if(dayCount % 7 == 0) {	// "dayCount % 7 == 0" : 일주일이 끝남
						System.out.printf("\n");	// 줄바꿈
					} 
				}	// if end
			}	// while loop end
			// 전월의 dayCount % 7 = 다음 월의 startDayOfMonth(요일)에 해당
			startDayOfMonth = dayCount % 7;
			System.out.print("\n");
		}	// month for loop end
	}	// main method end
}	// K26_p6CalendarPrint Class end