import java.io.*;
import java.util.*;

public class Main {
    static final int MAXN = 3000;
    static long[] S = new long[MAXN];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // S 배열 입력 받기
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            S[i] = Long.parseLong(input[i]);
        }

        // S 배열 정렬
        Arrays.sort(S, 0, N);

        long ans = 0;

        // 두 수를 고르고 세 번째 수를 찾는 탐색
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {

                // S[i] + S[j]보다 작거나 같은 원소의 최대 인덱스를 찾는다.
                long sum = S[i] + S[j];
                int idx = Arrays.binarySearch(S, j + 1, N, sum);

                // 이분 탐색의 결과가 음수인 경우, 해당 값이 없으므로 -(인덱스) - 1 값이 반환된다.
                if (idx < 0) {
                    idx = -idx - 1;
                } else {
                    // 만약 정확히 sum을 찾았다면, 같은 값의 마지막 인덱스를 구하기 위해 +1 한다.
                    idx++;
                }

                // 인덱스가 j보다 큰지 확인
                if (idx > j + 1) {
                    ans += (idx - (j + 1));
                }
            }
        }

        // 결과 출력
        System.out.println(ans);
    }
}