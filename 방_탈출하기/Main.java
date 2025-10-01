import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
				// HashSet 정렬
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(arr1[i]));
        }

        int m = Integer.parseInt(br.readLine());

				// 배열 정렬 Arrays.sorts(배열); Arrays.binarySearch 쓰려면 정렬 해야함
				// 이진 탐색 Arrays.binarySearch(배열, 찾으려는 수(문자열도 가능)
        for (int i = 0; i < m; i++) {
            int b = Integer.parseInt(br.readLine());
							// .contains
            if (set.contains(b)) {
								// StringBuilder는 스트링빌더_변수.append(넣을값);
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb);
    }
}
