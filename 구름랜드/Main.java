import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(input[i]);

        // 0번째부터 시작하는 누적합 배열
        long[] prefixSum = new long[n];
        prefixSum[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int l = Integer.parseInt(query[0]) - 1; // 1-based 입력을 0-based로 변환
            int r = Integer.parseInt(query[1]) - 1;

            long sum;
            if (l == 0) sum = prefixSum[r];
            else sum = prefixSum[r] - prefixSum[l - 1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
