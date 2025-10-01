import java.io.*;

class Main {
    static String[][] board;  // "휴식"이면 이동 불가
    static int[][] dp;
    static int n, m;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        n = Integer.parseInt(arr1[0]);
        m = Integer.parseInt(arr1[1]);
        int k = Integer.parseInt(arr1[2]);

        board = new String[n][m];
        dp = new int[n][m];

        // 휴식 칸 입력
        for (int i = 0; i < k; i++) {
            String[] arr2 = br.readLine().split(" ");
            int r = Integer.parseInt(arr2[0]) - 1;
            int c = Integer.parseInt(arr2[1]) - 1;
            board[r][c] = "휴식";
        }

        // 시작점
        dp[0][0] = 1;

        // DP 진행 (정방향, +move)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("휴식".equals(board[i][j])) continue; // 휴식 칸이면 못 감

                for (int move = 1; move <= 6; move++) {
                    int ni = i + move; // 아래쪽으로 이동
                    int nj = j;
									  // 아래쪽으로 1씩 이동하므로 더 커질 수밖에 없으므로 >= 0 안 함
                    if (ni < n && !"휴식".equals(board[ni][nj])) {
											dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % MOD;
                    }

                    ni = i;
                    nj = j + move; // 오른쪽으로 이동
                    if (nj < m && !"휴식".equals(board[ni][nj])) {
                        dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % MOD;
                    }
                }
            }
        }
				// 최종 목적지(n,m)
        System.out.println(dp[n - 1][m - 1]);
    }
}
