import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        long n = Long.parseLong(arr[0]); 
        long m = Long.parseLong(arr[1]); 

				// (double)m / n * 100
        long winRate = (m * 100) / n;
				long goalRate = winRate+1;

        if (winRate >= 99) { // 100%로 올릴 수 없는 경우
            System.out.println("X");
            return;
        }

        long left = 1;
				// right는 임의의 값으로
        long right = n * 2;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newWinRate = ((m + mid) * 100) / (n + mid);

            if (newWinRate >= goalRate) {
                result = mid;
                right = mid - 1;
							// 왼쪽으로 가려면 right = mid -1;
            } else {
							// 오른족으로 가려면 left = mid - 1;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
