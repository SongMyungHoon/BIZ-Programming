package chap4SelecIterArray;

public class K26_p26Phyramid {

	public static void main(String[] args) {
		int n, m;
		m = 20; n = 1;
		while(true) {
			for(int i = 0; i < m; i++) {
				System.out.printf(" ");
			}
			for(int i = 0; i < n; i++) {
				System.out.printf("★");
			}
			System.out.printf("\n");
			
			m = m - 1;
			n = n + 1;
			if(m < 0) break;
		}
	}
}
