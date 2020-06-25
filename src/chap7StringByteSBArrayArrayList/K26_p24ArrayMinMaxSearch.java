package chap7StringByteSBArrayArrayList;

public class K26_p24ArrayMinMaxSearch {

	public static void main(String[] args) {
		int[] k26_iArray = {1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		for(int k26_i = 0; k26_i < k26_iArray.length; k26_i++) {
			System.out.printf("iArray[%d] = %d\n", k26_i, k26_iArray[k26_i]);
		}	// for loop end
		
		int k26_iMax = k26_iArray[0];
		int k26_iMaxPt = 0;
		for(int k26_i = 0; k26_i < k26_iArray.length; k26_i++) {
			if(k26_iMax < k26_iArray[k26_i]) {
				k26_iMax = k26_iArray[k26_i];
				k26_iMaxPt = k26_i;
			}	// if end
		}	// for loop end
		
		System.out.printf("MAX : iArray[%d] = %d\n", k26_iMaxPt, k26_iMax);
	}
}
