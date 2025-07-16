import java.io.*;
import java.util.*;

class Main {

	// public static int factorial (int n) {
	// 	if (n <= 1) {
	// 		return n;
	// 	}
	// 	else {
	// 		return n * factorial(n-1);
	// 	}
	// } 
	public static int factorial (int n) {
		if ( n == 0){
			return 0;
		}
		else {
			return n / 5 + factorial(n/5); // 10 = 2*5 == 2와 5 쌍이 1개 있으므로 끝자리 연속 0 1개
																		// 즉, / 때 2는 많으므로 5의 개수를 센다.
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int count = factorial(n);
		
		// for( int i = 1; i <= n; i++) {
		// 	fact *= i;
		// }
		// System.out.println(fact);
		
		// String str1 = String.valueOf(fact);  // 숫자 -> 문자열
		// int [] arr1 = new int [str1.length()]; 
		
		// for (int i = 0; i < arr1.length; i++) {
		// 	arr1[i] = str1.charAt(i) - '0';  // 문자 -> 숫자 배열
		// }
		// for (int i = 0; i < arr1.length; i++) {
			
		// }
		
		// int count = 0;
		// for (int j = arr1.length-1; j >= 0; j--) {
		// 	if (arr1[j] == 0) {
		// 		count++;
		// 	}
		// 	else {
		// 		break;
		// 	}
		// }
		System.out.println(count);
				
	}
}