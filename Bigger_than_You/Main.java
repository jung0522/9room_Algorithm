import java.io.*;
import java.util.*;

class Main {
		// 각 숫자(문자열)들 저장할 ArrayList<
    static List<String> nums = new ArrayList<>();
    static String k;
    static String answer = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
        for (String s : arr1) {
            nums.add(s); // 문자열 문자 하나씩 ArrayList에 저장
        }
        Collections.sort(nums); // 정렬

        k = br.readLine();
        int len = k.length();

        // 자릿수: k와 같거나 +1 자리까지 고려
        for (int i = len; i <= len + 1; i++) {
            dfs("", i);
            if (answer != null) 
							break;
        }

        System.out.println(answer);
    }

    static void dfs(String current, int len) {
        if (answer != null) 
					return; // 정답 찾으면 탐색 종료

				// k의 길이(len)와 같은 경우만 비교
        if (current.length() == len) {
            if (current.charAt(0) == '0') 
							return; // 0으로 시작하면 안 됨
            if (isBigger(current, k)) {
							// 정답에 아직 아무것도 없거나 정답보다 더 작은 수면 정답으로 바꿔주려고
                if (answer == null || current.compareTo(answer) < 0) {
                    answer = current;
                }
            }
            return;
        }

        for (String s2 : nums) {
            dfs(current + s2, len);
            if (answer != null) return;
        }
    }

    static boolean isBigger(String current, String k) {
        if (current.length() != k.length()) {
            return current.length() > k.length(); // false 길이가 같아야 하므로
        }
        return current.compareTo(k) > 0; // true(현재 숫자 조합이 k보다 클 경우)
    }
}
