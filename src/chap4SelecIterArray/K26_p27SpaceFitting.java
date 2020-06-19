package chap4SelecIterArray;

import java.text.DecimalFormat;

public class K26_p27SpaceFitting {
	public static void main(String[] args) {
		// 칸 맞추기 실습
		String item = "사과";
		int unit_price = 5000;
		int num = 500;
		int total = 0;
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		// header 출력
		System.out.printf("==========================================================\n");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목","단가","수량","합계");
		System.out.printf("==========================================================\n");
		
		// 값 출력
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n",
				item, df.format(unit_price), df.format(num), df.format(unit_price * num));
		System.out.printf("==========================================================\n");
	}
}