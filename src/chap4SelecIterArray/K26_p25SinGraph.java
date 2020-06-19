package chap4SelecIterArray;

public class K26_p25SinGraph {
	public static void main(String[] args) {
		// sin 그래프 그리기
		// 360도 : 2pi = 1도 : x
		double fSin;
		for(int i = 0; i < 360; i++) {
			fSin = Math.sin(i * 3.141592 / 180);
			System.out.printf("%d sin ==>%f\n", i, fSin);
		}
		
		for(int i = 0; i < 360; i++) {
			fSin = Math.sin(i * 3.141592 / 180);
			
			int iSpace = (int)((1.0 - fSin) * 50);
			for(int j = 0; j < iSpace; j++) {
				System.out.printf(" ");
			}
			System.out.printf("*[%f][%d]\n", fSin, iSpace);
		}
	}
}
