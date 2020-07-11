package chap8File;

import java.io.*;

public class K26_p6FIleReadWrites {
	// 대상 파일의 경로를 저장할 String type 변수 선언
	static String k26_filePath = "";
	// filePath에 위치한 파일에 내용을 기록하는 method
	public static void k26_fileWrite() throws IOException {
		// filePath에 위치한 파일을 다루기 위한 File class instance 선언
		File k26_file = new File(k26_filePath);
		/* 단일 문자, 배열 및 문자열을 효율적으로 기록할 수 있도록 문자를 버퍼링하여 
		 * 문자 출력 stream에 text 저장할 BufferedWriter instance 선언 */
		BufferedWriter k26_bufferedWriter = new BufferedWriter(new FileWriter(k26_file));
		// argument로 받은 String을 BufferedWriter instance에 저장
		k26_bufferedWriter.write("안녕 파일");
		// newLine() : 다음 줄로 넘겨주는 method, 대신 개행문자를 사용해도 된다.
		k26_bufferedWriter.newLine();
		// argument로 받은 String을 BufferedWriter instance에 저장
		k26_bufferedWriter.write("hello 헬로");
		// newLine() : 다음 줄로 넘겨주는 method, 대신 개행문자를 사용해도 된다.
		k26_bufferedWriter.newLine();
		/* 스트림을 닫고 이와 관련된 모든 시스템 리소스를 해제한다.
		 * 스트림이 닫히면 추가 read (), ready (), mark (), reset () 또는 skip () 호출에서 IOException이 발생한다
		 * 이전에 닫힌 스트림은 다시 닫아도 효과가 없다. */
		k26_bufferedWriter.close();
	}	// k26_fileWrite method end
	
	// filePath에 위치한 파일의 내용을 읽어들이는 method
	public static void k26_fileRead() throws IOException {
		// filePath에 위치한 파일을 다루기 위한 File class instance 선언
		File k26_file = new File(k26_filePath);
		/* 문자 입력 stream에서 문자를 버퍼링하여 문자, 배열 및 행을 효율적으로 
		 * 읽을 수 잇도록 문자를 버퍼링하는 BufferedReader instance 선언 */
		BufferedReader k26_bufferedReader = new BufferedReader(new FileReader(k26_file));
		// 파일 내용을 읽어서 저장할 String 변수 선언
		String k26_readTxt;
		// 파일에서 읽어 readTxt에 저장한 String이 null이 아닌 경우 while 반복
		while((k26_readTxt = k26_bufferedReader.readLine()) != null) {
			// 파일의 내용을 줄 단위로 출력
			System.out.printf("%s\n", k26_readTxt);
		}	// while loop end
		/* 스트림을 닫고 이와 관련된 모든 시스템 리소스를 해제한다.
		 * 스트림이 닫히면 추가 read (), ready (), mark (), reset () 또는 skip () 호출에서 IOException이 발생한다
		 * 이전에 닫힌 스트림은 다시 닫아도 효과가 없다. */
		k26_bufferedReader.close();
	}	// k26_fileRead method end
	public static void main(String[] args) throws IOException {
		k26_fileWrite();	// fileWrite method 실행
		k26_fileRead();		// fileRead method 실행
	}	// main method end
}	// K26_p6FileRead class end
