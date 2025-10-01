import java.io.*;
class Main {
	static final int mod = (int)Math.pow(10,8) + 7;
	static int table[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		// 첫 줄에 앉을 수 있는 5가지 경우
		// (0, 0, 0) (1, 0, 0) (0, 1, 0) (0, 0, 1), (1, 0, 1)
		table = new int [n][5];

		// dp[0][0]: (0, 0, 0), dp[0][1]: (1, 0, 0),...
		// 5가지 모두 가능
		table[0][0] = 1;
		table[0][1] = 1;
		table[0][2] = 1;
		table[0][3] = 1;
		table[0][4] = 1;

		// 2번째 부터니까 i = 1
		for(int i = 1; i < n; i++) {

			// (0, 0, 0)
			table[i][0] = (table[i-1][0] + table[i-1][1] + table[i-1][2] + table[i-1][3] + table[i-1][4]) % mod;

			// (1, 0, 0)
			table[i][1] =  (table[i-1][0] + table[i-1][2] + table[i-1][3]) % mod;

			// (0, 1, 0)
			table[i][2] =  (table[i-1][0] + table[i-1][1] + table[i-1][3] + table[i-1][4]) % mod;

			// (0, 0, 1)
			table[i][3] =  (table[i-1][0] + table[i-1][1] + table[i-1][2]) % mod;

			// (1, 0, 1)
			table[i][4] =  (table[i-1][0] + table[i-1][2]) % mod;

		}
		long res = 0;
		// i < n이 아니라 i<5(경우의 수)
		for(int i = 0; i < 5; i++) {
			// res += (table[n-1][i] % mod); (x)
			 res = (res + table[n-1][i]) % mod;
		}
		System.out.println(res);
	}
}