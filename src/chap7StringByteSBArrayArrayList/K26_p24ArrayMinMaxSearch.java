package chap7StringByteSBArrayArrayList;

public class K26_p24ArrayMinMaxSearch {

	public static void main(String[] args) {
		int[] iArray = {1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		for(int i = 0; i < iArray.length; i++) {
			System.out.printf("iArray[%d] = %d\n", i, iArray[i]);
		}	// for loop end
		
		int iMax = iArray[0];
		int iMaxPt = 0;
		for(int i = 0; i < iArray.length; i++) {
			if(iMax < iArray[i]) {
				iMax = iArray[i];
				iMaxPt = i;
			}	// if end
		}	// for loop end
		
		System.out.printf("MAX : iArray[%d] = %d\n", iMaxPt, iMax);
	}
}
