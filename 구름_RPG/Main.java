import java.io.*;
import java.lang.*; // Math 쓰려면
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int arr[] = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 소수 판단
		for(int i = 0; i < n; i++) {

			if ( arr[i] < 2) {
			System.out.println("1은 소수");
			continue;
			}
					// boolean 값 사용
			boolean isPrime = true;
			// 소수 판별에 제곱근까지만 판단!
			for(int w = 2; w <= Math.sqrt(arr[i]); w++) {
				
				if(arr[i] % w == 0) {
					isPrime = false;
					break;
				}
			
			}
			if (isPrime) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
		}
		
	}
}