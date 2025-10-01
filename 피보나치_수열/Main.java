import java.io.*;
class Main {
	static int n;
	static long dp[];
	// Math.pow()는 double을 반환하므로, 정수로 쓰려면 캐스팅 필요
	static final long div = (long)Math.pow(10, 9) + 7;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.parseInt(input);
		// fibo(0)부터 fibo(n)까지 정의되므로 n+1 크기가 필요하다)
		dp = new long [n+1];
		
		// 1번째 항 = fibo(0) 이므로 n번째 항을 원하면 fibo(n-1)
		// long hang = fibo(n-1);
			
		if (n == 0) {
            System.out.println(0);
     } 
		else if (n == 1) {
            System.out.println(1);
     }

		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i < n; i++) {
			dp[i] = dp[i-1] + dp[i-2] % div;
		}

		
		System.out.println(dp[n-1] % div);
	}
	// static long fibo(int n) {
	// 	if(n <= 0) {
	// 		return 0;
	// 	}
	// 	else if(n == 1) {
	// 		return 1;
	// 	}
	// 	else if(dp[n] != 0) {
	// 		return dp[n];
	// 	}
	// 	dp[n] = (fibo(n-1) + fibo(n-2)) % div;
	// 	return dp[n];
	// }
}