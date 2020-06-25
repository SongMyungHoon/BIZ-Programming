package chap7StringByteSBArrayArrayList;

public class K26_p30OneRec {
	
	private int k26_student_id;
	private String k26_name;
	private int k26_kor;
	private int k26_eng;
	private int k26_mat;
	
	public K26_p30OneRec(int student_id, String k26_name
			, int k26_kor, int k26_eng, int k26_mat) {
		this.k26_student_id = student_id;
		this.k26_name = k26_name;
		this.k26_kor = k26_kor;
		this.k26_eng = k26_eng;
		this.k26_mat = k26_mat;
	}
	
	public int k26_student_id() {
		return this.k26_student_id;
	};
	
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