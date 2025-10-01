import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		String[] arr1 = input.split(" ");
		int n = Integer.parseInt(arr1[0]);
		int q = Integer.parseInt(arr1[1]);

		String[] arr_ = br.readLine().split(" ");
		long[] arr2 = new long[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = Long.parseLong(arr_[i]);
		}
		Arrays.sort(arr2);

		for (int i = 0; i < q; i++) {
			long p = Long.parseLong(br.readLine());
			int idx = Arrays.binarySearch(arr2, p);

			if (idx >= 0) {
				sb.append(arr2[idx]).append("\n");
			} 
			else {
				idx = -idx - 1;

				if (idx == 0) {
					sb.append(arr2[0]).append("\n");
				} 
				else if (idx == n) {
					sb.append(arr2[n - 1]).append("\n");
				} 
				else {
					long left = arr2[idx - 1];
					long right = arr2[idx];

					if (p - left <= right - p) {
						sb.append(left).append("\n");
					} 
					else {
						sb.append(right).append("\n");
					}
				}
			}
		}

		System.out.print(sb);
	}
}
