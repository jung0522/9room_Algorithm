import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MOD = 1000000;

    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
				dp = new int[n][6];
        /*
         dp(i, j)를 i번째 과목의 상태가 j번 상태일 때의 경우의 수로 정의합니다.

         상태 첫 번째부터 차례대로
         0: 학점 B가 나온 적이 아직 없으며, 학점 C가 0번 누적된 상태
         1: 학점 B가 나온 적이 아직 없으며, 학점 C가 1번 누적된 상태
         2: 학점 B가 나온 적이 아직 없으며, 학점 C가 2번 누적된 상태
         3: 학점 B가 나온 적이 이미 있으며, 학점 C가 0번 누적된 상태
         4: 학점 B가 나온 적이 이미 있으며, 학점 C가 1번 누적된 상태
         5: 학점 B가 나온 적이 이미 있으며, 학점 C가 2번 누적된 상태
        */

				// 맨 처음의 경우의 수
        dp[0][0] = 1; // A
        dp[0][3] = 1; // B
        dp[0][1] = 1; // C

				// 처음은 했으므로 0 다음 1부터
        for (int i = 1; i < n; i++) {
            // 1번 상태: B 나온 적 없음, C 누적 0
						dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
						
						// 2번 상태: B 나온 적 없음, C 누적 1
						dp[i][1] = dp[i - 1][0];
						
						// 3번 상태: B 나온 적 없음, C 누적 2
						dp[i][2] = dp[i - 1][1];
						
						// 4번 상태: B 나온 적 있음, C 누적 0
						dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
						          + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5]) % MOD;
						
						// 5번 상태: B 나온 적 있음, C 누적 1
						dp[i][4] = dp[i - 1][3];
						
						// 6번 상태: B 나온 적 있음, C 누적 2
						dp[i][5] = dp[i - 1][4];

        }

        int res = 0;
        for (int i = 0; i <= 5; i++) {
            res = (res + dp[n - 1][i]) % MOD;
        }

        System.out.println(res);
    }
}
