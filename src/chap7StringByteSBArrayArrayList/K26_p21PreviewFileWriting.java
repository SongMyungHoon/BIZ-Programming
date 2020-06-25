package chap7StringByteSBArrayArrayList;

import java.io.*;

public class K26_p21PreviewFileWriting {
	public static void main(String[] args) throws IOException {
		String k26_filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\a.txt";
		/* new FileWriter(filePath, trueOrFalse)
		 * filePath : 저장할 파일이 위치한 경로와 파일 이름
		 * trueOrFalse : 덮어쓰기 유무, 덮어쓰려면 true, 아니면 false */
		FileWriter k26_fileWriter = new FileWriter(k26_filePath, true);
		
		BufferedWriter k26_bufferWriter = new BufferedWriter(k26_fileWriter);
		
		StringBuffer k26_stringBuffer = new StringBuffer();
		
		BufferedReader k26_bufferedReader = new BufferedReader(
										new InputStreamReader(System.in));
		String k26_string = "";

		while(!(k26_string = k26_bufferedReader.readLine()).startsWith("s")) {
			k26_stringBuffer.append(k26_string + "\n"); 	// 스트링버퍼에 한 줄씩 읽어 기록한다.
		}
		
		k26_bufferedReader.close();
		k26_fileWriter.write(k26_stringBuffer.toString());
		k26_fileWriter.flush();
		k26_fileWriter.close();
		System.out.println("저장이 완료되었습니다.");
	
	}
}