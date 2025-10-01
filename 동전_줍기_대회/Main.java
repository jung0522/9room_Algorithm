import java.io.*;
class Main {
	static final int MAXN = 100000;
	static long dp[] = new long[MAXN];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		String [] arr1 = br.readLine().split(" ");
		
		int [] arr2 = new int [n];
		for(int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(arr1[i]);
		}
		
		dp[0] = arr2[0];
		for(int i = 1; i < n; i++) {
			// 원래 최대 연속합 문제에서는 최소값도 음수가 될 수 있으므로, 
			// 0을 비교하면 안 되고 dp[i-1] + arr2[i]와 arr2[i]를 비교해야 합니다.
			dp[i] = Math.max(dp[i-1] + arr2[i], arr2[i]);
		}

		long max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(dp[i], max);
		}

		System.out.println(max);
	}
}