import java.io.*;

class Main {
    static final long MOD = (long)1e9 + 7;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String arr1 [] = input.split(" ");
        int n = Integer.parseInt(arr1[0]);  // 구름이 구슬 개수
        int m = Integer.parseInt(arr1[1]);  // 상대 구슬 개수
        int k = Integer.parseInt(arr1[2]);  // 최대 진행 횟수

        int total = n + m;

        // dp[i]: 현재 시점에서 구름이가 i개의 구슬을 가지고 있는 경우의 수
        long dp [] = new long[total+1];
        dp[n] = 1; // 초기 상태

        long count = 0;

        for (int turn = 0; turn < k; turn++) {
            // 현재 턴에서 게임이 끝난 경우 (구슬이 0개이거나 total개일 때)
            count = (count + dp[0] + dp[total]) % MOD;

            long [] next = new long[total+1];

            for (int j = 1; j < total; j++) {
                if (dp[j] == 0) continue;

                next[j-1] = (next[j-1] + dp[j]) % MOD; // 1개 잃음
                next[j]   = (next[j]   + dp[j]) % MOD; // 무승부
                next[j+1] = (next[j+1] + dp[j]) % MOD; // 1개 얻음
            }
            dp = next;
        }

        // 마지막 턴 이후에도 종료 상태 반영
        count = (count + dp[0] + dp[total]) % MOD;

        System.out.println(count);
    }
}
