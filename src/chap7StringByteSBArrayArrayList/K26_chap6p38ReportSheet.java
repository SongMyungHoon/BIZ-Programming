package chap7StringByteSBArrayArrayList;

//학생의 이름, 국어 점수, 영어 점수, 수학 점수에 대한 데이터와 method를 묶어둔 class
class K26_OneRec {	 
	private String k26_name;	// 학생의 이름을 저장할 String type 변수
	private int k26_kor;		// 학생의 국어 점수를 저장할 int type 변수
	private int k26_eng;		// 학생의 영어 점수를 저장할 int type 변수
	private int k26_mat;		// 학생의 수학 점수를 저장할 int type 변수
	
	// 각 field의 값을 parameter로 하는 Constructor 선언
	public K26_OneRec(String k26_name, int k26_kor, int k26_eng, int k26_mat) {
		this.k26_name = k26_name;	// parameter name값을 instance의 name으로 지정
		this.k26_kor = k26_kor;		// parameter kor값을 instance의 kor으로 지정
		this.k26_eng = k26_eng;		// parameter eng값을 instance의 eng으로 지정
		this.k26_mat = k26_mat;		// parameter mat값을 instance의 mat으로 지정
	}
	// name field에 대한 getter method로 해당 class의 instacne의 name을 반환
	public String k26_name() {
		return this.k26_name;
	};
	// kor field에 대한 getter method로 해당 class의 instacne의 kor을 반환
	public int k26_kor() {
		return this.k26_kor;
	};
	// eng field에 대한 getter method로 해당 class의 instacne의 eng을 반환
	public int k26_eng() {
		return this.k26_eng;
	};
	// mat field에 대한 getter method로 해당 class의 instacne의 mat을 반환
	public int k26_mat() {
		return this.k26_mat;
	};
	// kor, eng, mat의 합계를 return하는 method
	public int k26_sum() {
		return this.k26_kor + this.k26_eng + this.k26_mat;
	};
	// kor, eng, mat의 평균을 return하는 method
	public double k26_ave() {
		return this.k26_sum()/3.0;
	};
}

public class K26_chap6p38ReportSheet {
	public static void main(String[] args) {
		
		int k26_iPerson = 5;	// 이 값을 주는 만큼 저장소 생성
		
		K26_OneRec[] k26_inData = new K26_OneRec[k26_iPerson];	// OneRec 클래스의 배열 선언
		
		k26_inData[0] = new K26_OneRec("홍길01",100,100,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[1] = new K26_OneRec("홍길02",90,90,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[2] = new K26_OneRec("홍길03",80,70,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[3] = new K26_OneRec("홍길04",70,60,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		k26_inData[4] = new K26_OneRec("홍길0%",60,100,90);	// 각 배열의 요소마다 클래스 인스턴스 생성
		
		for(int k26_i = 0; k26_i < k26_iPerson; k26_i++) {
		System.out.printf("번호:%d, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 총점:%d, 평균:%f\n"
				, k26_i, k26_inData[k26_i].k26_name(),k26_inData[k26_i].k26_kor()
				,k26_inData[k26_i].k26_eng(),k26_inData[k26_i].k26_mat()
				,k26_inData[k26_i].k26_sum(),k26_inData[k26_i].k26_ave());
		}
	}
}