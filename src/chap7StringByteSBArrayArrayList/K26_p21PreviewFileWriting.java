package chap7StringByteSBArrayArrayList;

import java.io.*;

public class K26_p21PreviewFileWriting {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\HighTech\\05 Enterprise Computing\\BIZ프로그래밍기초\\Assignment\\a.txt";
		/* new FileWriter(filePath, trueOrFalse)
		 * filePath : 저장할 파일이 위치한 경로와 파일 이름
		 * trueOrFalse : 덮어쓰기 유무, 덮어쓰려면 true, 아니면 false */
		FileWriter fileWriter = new FileWriter(filePath, true);
		
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		
		StringBuffer stringBuffer = new StringBuffer();
		
		BufferedReader bufferedReader = new BufferedReader(
										new InputStreamReader(System.in));
		String string = "";

		while(!(string = bufferedReader.readLine()).startsWith("s")) {
			stringBuffer.append(string + "\n"); 	// 스트링버퍼에 한 줄씩 읽어 기록한다.
		}
		
		bufferedReader.close();
		fileWriter.write(stringBuffer.toString());
		fileWriter.flush();
		fileWriter.close();
		System.out.println("저장이 완료되었습니다.");
		
//		FileWriter fw = new FileWriter(filePath, true);
//		BufferedWriter bw = new BufferedWriter(fw);
//		StringBuffer sf = new StringBuffer();
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = "";
//		while(!(str = br.readLine()).startsWith("s")) {
//			sf.append(str + "\n");
//		}
//		br.close();
//		fw.write(sf.toString());
		
	}
}