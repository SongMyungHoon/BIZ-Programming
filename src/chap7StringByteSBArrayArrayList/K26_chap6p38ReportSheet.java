package chap7StringByteSBArrayArrayList;

class K26_InputData {
	String[] k26_name;	// 이름을 저장할 String 배열 선언
	int[] k26_id;		// id를 저장할 int 배열 선언
	int[] k26_kor;		// 국어 점수를 저장할 int 배열 선언
	int[] k26_eng;		// 영어 점수를 저장할 int 배열 선언
	int[] k26_mat;		// 수학 점수를 저장할 int 배열 선언
	
	// field의 size를 parameter로 하는 Constructor 선언
	public K26_InputData(int k26_arraySize) {
		// 입력받은 parameter만큼을 size로 하는 String[] instance를 선언하여 name에 저장
		this.k26_name = new String[k26_arraySize];
		// 입력받은 parameter만큼을 size로 하는 int[] instance를 선언하여 id에 저장
		this.k26_id = new int[k26_arraySize];
		// 입력받은 parameter만큼을 size로 하는 int[] instance를 선언하여 kor에 저장
		this.k26_kor = new int[k26_arraySize];
		// 입력받은 parameter만큼을 size로 하는 int[] instance를 선언하여 eng에 저장
		this.k26_eng = new int[k26_arraySize];
		// 입력받은 parameter만큼을 size로 하는 int[] instance를 선언하여 mat에 저장
		this.k26_mat = new int[k26_arraySize];
	}
	
	/* InputData의 Field 값을 저장하는 setter method
	 * param: id - 번호, name - 이름,
	 * 		  kor - 해당 학생의 국어 점수, eng - 해당 학생의 영어 점수, mat - 해당 학생의 수학 점수
	 * return: void
	 * */
	public void k26_setData(int k26_id, String k26_name, int k26_kor, int k26_eng, int k26_mat) {
		this.k26_id[k26_id] = k26_id;		// parameter id 값을 instance의 id array의 id 번째 요소로 저장
		this.k26_name[k26_id] = k26_name;	// parameter name 값을 instance의 name array의 id 번째 요소로 저장
		this.k26_kor[k26_id] = k26_kor;		// parameter kor 값을 instance의 kor array의 id 번째 요소로 저장
		this.k26_eng[k26_id] = k26_eng;		// parameter eng 값을 instance의 eng array의 id 번째 요소로 저장
		this.k26_mat[k26_id] = k26_mat;		// parameter mat 값을 instance의 mat array의 id 번째 요소로 저장
	}

	// InputData의 field(array) 중 kor, eng, mat의 id번째 요소들의 합을 계산해주는 method
	public int k26_sum(int k26_id) {
		return k26_kor[k26_id] + k26_eng[k26_id] + k26_mat[k26_id];
	}
	
	// InputData의 field(array) 중 kor, eng, mat의 id번째 요소들의 평균을 계산해주는 method 
	public float k26_avg(int k26_id) {
		return (k26_kor[k26_id] + k26_eng[k26_id] + k26_mat[k26_id])/3;
	}
}

class K26_OneRec {
	private String k26_name;
	private int k26_kor;
	private int k26_eng;
	private int k26_mat;
	
	public K26_OneRec(String k26_name, int k26_kor, int k26_eng, int k26_mat) {
		this.k26_name = k26_name;
		this.k26_kor = k26_kor;
		this.k26_eng = k26_eng;
		this.k26_mat = k26_mat;
	}
	
	public String k26_name() {
		return this.k26_name;
	};
	
	public int k26_kor() {
		return this.k26_kor;
	};
	
	public int k26_eng() {
		return this.k26_eng;
	};
	
	public int k26_mat() {
		return this.k26_mat;
	};
	
	public int k26_sum() {
		return this.k26_kor + this.k26_eng + this.k26_mat;
	};
	
	public double k26_ave() {
		return this.k26_sum()/3.0;
	};
}

public class K26_chap6p38ReportSheet {
	public static void main(String[] args) {
		
		int k26_iPerson = 5;	// 이 값을 주는 만큼 저장소 생성
		
		K26_OneRec[] k26_inData = new K26_OneRec[k26_iPerson];	// OneRec 클래스 형태의 배열 생성
		
		k26_inData[0] = new K26_OneRec("홍길01",100,100,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[1] = new K26_OneRec("홍길02",90,90,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[2] = new K26_OneRec("홍길03",80,70,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[3] = new K26_OneRec("홍길04",70,60,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[4] = new K26_OneRec("홍길0%",60,100,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
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