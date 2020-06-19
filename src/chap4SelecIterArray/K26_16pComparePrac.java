package chap4SelecIterArray;

public class K26_16pComparePrac {
	public static void main(String[] args) {
		int k26_iI;		// 정수형 k26_iI 변수 선언
		double k26_iD;	// 실수형 k26_iD 변수 선언
		
		k26_iI = 10/3;		// 정수형 변수에 10/3 = 3을 저장
		k26_iD = 10/3.0;	// 실수형 변수에 정수/실수 = 실수형 변수 저장(3.3333...)
		
		// int와 double은 정수형 연산과 실수형 연산이다.
		// 정수형 연산과 실수형 연산의 결과가 동일하다면, 소수 부분 없다는 의미
		if(k26_iI == k26_iD) System.out.println("equal");	// 같음을 화면에 출력
		
		// 정수형 연산과 실수형 연산의 결과가 다르다면, 소수 부분이 존재함을 의미
		// 다르다는 것을 화면에 출력한다
		else System.out.printf("Not equal[%f][%f]\n", (double)k26_iI, k26_iD);

		// 단지 유효숫자까지 표시된 것뿐이지 다르다
		// 10/3.0 은 무한 소수이므로 실수를 유한소수로 표현한 것과 무한소수가 같을 수는 없다.
		if(k26_iD == 3.333333) System.out.println("equal");
		
		// 무한 소수와 유한 소수는 엄연히 다른 값이므로 Not equal을 화면에 출력
		else System.out.printf("Not equal [3.333333][%f]\n", k26_iD);
		
		// 실수형 연산의 결과를 명시적 형 변환(explicit type casting)
		// 소수점 이하 숫자는 제거되고 (버림처리) 정수 부분만 남는다.
		k26_iD = (int) k26_iD;
		
		// 실수형 연산의 결과를 정수형으로 형변환 했으므로 정수형 연산 결과가 같게 된다
		if(k26_iI == k26_iD) System.out.println("equal");
		
		// else에 걸리지 않는다.
		else System.out.printf("Not equal[%f][%f]\n", (double)k26_iI, k26_iD);
		
		// int type 변수를 %f 서식지정자로 실수로 출력하면 뒤에 .000000 이 붙는다.
		System.out.printf("int로 인쇄[%d][%f]\n", k26_iI, k26_iD);
		
		// iI, iD 모두 같은 값을 출력한다.
		System.out.printf("double로 인쇄[%f][%f]\n",(double)k26_iI, k26_iD);
		
		char k26_a = 'c';	// char type 변수 k26_a 선언하고 'c'로 초기화한다.
		
		if(k26_a == 'b') System.out.println("a는 b이다");	// k26_a가 'b'와 같다면
		if(k26_a == 'c') System.out.println("a는 c이다");	// k26_a가 'c'와 같다면
		if(k26_a == 'd') System.out.println("a는 d이다");	// k26_a가 'd'와 같다면
		
		String k26_aa = "abcd";	// String type 변수 k26_aa 선언하고 "abcd"로 초기화
		
		// String의 동등 비교는 equals method를 사용한다.
		// k26_aa가 "abcd"와 같다면
		if(k26_aa.equals("abcd")) System.out.println("aa는 abcd이다");
		
		// else에 걸리지 않는다.
		else System.out.println("aa는 abcd이 아니다");
		
		boolean k26_bb = true;	// boolean type 변수 k26_bb 선언하고 true 로 초기화
		
		// (이중부정) "부정의 부정"이 참인 경우 
		if(!!k26_bb) System.out.println("bb가 아니고 아니면 참이다");
		
		// (이중부정) "부정의 부정"이 거짓인 경우
		else System.out.println("bb가 아니고 아니면 거짓이다");
	}	// main method end
}	// K26_15pStars Class end
