package chap7StringByteSBArrayArrayList;

import java.io.*;

public class K26_p21PreviewFileWriting {
	public static void main(String[] args) throws IOException {
		// 파일을 저장할 경로와 파일 이름
		String k26_filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\a.txt";
		
		/* new FileWriter(filePath, trueOrFalse)
		 * filePath : 저장할 파일이 위치한 경로와 파일 이름
		 * trueOrFalse : 덮어쓰기 유무, 덮어쓰려면 true, 아니면 false */
		FileWriter k26_fileWriter = new FileWriter(k26_filePath, true);
		
		/* file write 작업에서 메모리 효율성, 작업 시간 감소 등을 위해
		 * writing 작업의 내용을 buffer에 저장하여 line 단위로 저장하는 BufferedWriter 선언 */ 
		BufferedWriter k26_bufferWriter = new BufferedWriter(k26_fileWriter);
		
		/* String manipulation에서 performance 향상을 위해
		 * buffer를 활용하는 StringBuffer class의 instance 선언 */
		StringBuffer k26_stringBuffer = new StringBuffer();
		
		/* file read 작업에서 performance 향상을 위해
		 * reading 작업의 내용을 buffer에 저장하여 line 단위로 받는 BufferedReader instance 선언 
		 * input은 표준 입력 (키보드 입력)으로 받는다. */
		BufferedReader k26_bufferedReader = new BufferedReader(
										new InputStreamReader(System.in));
		
		// 작업의 결과를 line 단위로 저장할 String 변수 선언
		String k26_string = "";
		
		/* 표준 입력을 line 단위로 받아 string 변수에 저장했을 때, string의 시작 글자가 
		 * "s"로 시작하지 않으면 반복, "s"로 시작하면 반복 종료 */
		while(!(k26_string = k26_bufferedReader.readLine()).startsWith("s")) {
			k26_stringBuffer.append(k26_string + "\n"); 	// 스트링버퍼에 한 줄씩 읽어 기록한다.
		}
		
		/* 스트림을 닫고 이와 관련된 모든 시스템 리소스를 해제한다.
		 * 스트림이 닫히면 추가 read (), ready (), mark (), reset () 또는 skip () 호출에서 IOException이 발생한다
		 * 이전에 닫힌 스트림은 다시 닫아도 효과가 없다. */
		k26_bufferedReader.close();
		
		// stringBuffer에 담긴 string의 내용을 String 형태로 변환하여 파일에 기록
		k26_fileWriter.write(k26_stringBuffer.toString());
		
		// 파일의 내용 변화를 저장
		k26_fileWriter.flush();
		
		// fileWriter instance의 시스템 리소스를 해제한다.
		k26_fileWriter.close();
		
		// 작업이 성공적으로 완료된 경우, "저장이 완료되었습니다." 라는 문구를 console 화면에 출력
		System.out.println("저장이 완료되었습니다.");
	}
}