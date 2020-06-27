package chap8File;

import java.io.*;

public class K26_p5nonBufferFileWriter {

	public static void main(String[] args) {
		try {
			// 파일을 저장할 경로와 저장할 파일의 이름
			String k26_filePath = "C:\\Users\\MHSong\\OneDrive\\Documents"
					+ "\\Developer\\HighTech\\05 Enterprise Computing"
					+ "\\BIZ프로그래밍기초\\Assignment\\Mytest.txt";
			// File instance 선언
			File k26_file = new File(k26_filePath);
			// 지정한 파일에 기록하기 위한 FileWriter instance 선언
			FileWriter k26_fileWriter = new FileWriter(k26_file);
			// Mytest.txt 파일에 "안녕 파일" 기록 후 줄 바꿈
			k26_fileWriter.write("안녕 파일\n");
			// Mytest.txt 파일에 "hello 헬로" 기록 후 줄 바꿈
			k26_fileWriter.write("hello 헬로\n");
			// FileWriter instance의 System resource 해제 및 File close
			k26_fileWriter.close();
			// Mytest.txt file open
			FileReader k26_fileReader = new FileReader(k26_file);
			// file read process의 escape condition을 저장할 int 형 변수 선언
			int k26_escapeCondition = -1;
			// 읽은 파일 내용을 저장할 char array type instance 선언
			char[] k26_readCharArray;
			// while 문 조건에 true 입력 : 무한 루프
			while(true) {
				// 읽은 파일을 저장할 char array의 size = 100으로 설정
				k26_readCharArray = new char[100];
				k26_escapeCondition = k26_fileReader.read(k26_readCharArray);
				// escapeCondition이 -1 이라면 while 반복 종료
				if(k26_escapeCondition == -1) break;
				
				for(int k26_charIndex = 0; k26_charIndex < k26_escapeCondition; k26_charIndex++) {
				// for(char c : ch) {
					System.out.printf("%c", k26_readCharArray[k26_charIndex]);
				}	// for loop end
			}	// while loop end
			// FileReader instance를 닫고 모든 System Resource를 즉시 해제한다
			k26_fileReader.close();

			System.out.printf("\nFILE READ END");
		} catch(Exception k26_error) {	// Exception이 발생시 에러 문구를 출력
			System.out.printf("나 에러[%s]\n", k26_error);
		}	// try - catch end
	}	// main method end
}	// K26_p5nonBufferFileWriter Class end
