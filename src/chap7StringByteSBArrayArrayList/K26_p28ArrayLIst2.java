package chap7StringByteSBArrayArrayList;

import java.util.ArrayList;

public class K26_p28ArrayLIst2 {
	public static void main(String[] args) {
		int k26_iTestMAX = 1000000;
		ArrayList k26_iAL = new ArrayList();
		
		for(int k26_i = 0; k26_i < k26_iTestMAX; k26_i++) {
			k26_iAL.add( (int)(Math.random() * 1000000) );
		}
		
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++) {
			System.out.printf(" ArrayList %d = %d\n", k26_i, k26_iAL.get(k26_i));
		}
			
		System.out.printf("*****************************\n");
		k26_iAL.sort(null);
		
		for(int k26_i = 0; k26_i < k26_iAL.size(); k26_i++) {
			System.out.printf(" ArrayList %d = %d\n", k26_i, k26_iAL.get(k26_i));
		}
	}
}
