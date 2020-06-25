package chap7StringByteSBArrayArrayList;

class InputData {
	String[] name;
	int[] id;
	int[] kor;
	int[] eng;
	int[] mat;
	
	public InputData(int arraySize) {
		this.name = new String[arraySize];
		this.id = new int[arraySize];
		this.kor = new int[arraySize];
		this.eng = new int[arraySize];
		this.mat = new int[arraySize];
	}
	
	public void setData(int id, String name, int kor, int eng, int mat) {
		this.id[id] = id;
		this.name[id] = name;
		this.kor[id] = kor;
		this.eng[id] = eng;
		this.mat[id] = mat;
	}
	
	public int sum(int id) {
		return kor[id] + eng[id] + mat[id];
	}
	
	public float avg(int id) {
		return (kor[id] + eng[id] + mat[id])/3;
	}
}

class OneRec {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public OneRec(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public String name() {return this.name;};
	public int kor() {return this.kor;};
	public int eng() {return this.eng;};
	public int mat() {return this.mat;};
	public int sum() {return this.kor + this.eng + this.mat;};
	public double ave() {return this.sum()/3.0;};
}

public class K26_chap6p38ReportSheet {
	public static void main(String[] args) {
		
		int iPerson = 5;	// 이 값을 주는 만큼 저장소 생성
		
		OneRec[] inData = new OneRec[iPerson];	// OneRec 클래스 형태의 배열 생성
		
		inData[0] = new OneRec("홍길01",100,100,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		inData[1] = new OneRec("홍길02",90,90,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		inData[2] = new OneRec("홍길03",80,70,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		inData[3] = new OneRec("홍길04",70,60,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		inData[4] = new OneRec("홍길0%",60,100,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
	}
}

//public static void main(String[] args) {
//	
//	int iPerson = 10;	// 이 값을 주는 만큼 저장소 생성
//	
//	InputData inData = new InputData(iPerson);
//	
//	for(int i = 0; i < iPerson; i++) {
//		String name = String.format("홍길%02d", i);
//		int kor = (int)(Math.random() * 100);
//		int eng = (int)(Math.random() * 100);
//		int mat = (int)(Math.random() * 100);
//		inData.setData(i, name, kor, eng, mat);
//	}
//	
//	for(int i = 0; i < iPerson; i++) {
//		System.out.printf("번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n"
//				, i, inData.name[i],inData.kor[i]
//				,inData.eng[i],inData.mat[i],inData.sum(i)
//				,inData.avg(i));
//	}
//}