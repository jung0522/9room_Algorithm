
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 문자열 길이 n과 문자열 s
        String[] arr1 = br.readLine().split(" ");
        int n = Integer.parseInt(arr1[0]);
        String s = arr1[1];

        // prefix[c][i] : ex) 문자 'c'가 0~n까지 몇 번 나왔는지 (i 포함)
        int[][] prefix = new int[26][n];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (i > 0) 
									prefix[j][i] = prefix[j][i - 1]; // 이전 값 복사
            }
            prefix[ch][i]++; // 현재 문자 카운트
        }

        // 쿼리 수
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            String[] arr3 = br.readLine().split(" ");
            int l = Integer.parseInt(arr3[0]) - 1; // inclusive (0-based)
            int r = Integer.parseInt(arr3[1]) - 1; // inclusive (0-based)
            int m = Integer.parseInt(arr3[2]);
            String t = arr3[3];

            // t 문자열 문자 개수 세기
            int[] need = new int[26];
            for (int j = 0; j < t.length(); j++) {
								int ch2 = t.charAt(j);
                need[ch2 - 'a']++;
            }

            // 부분 문자열 [l, r] 문자 개수
            int count = Integer.MAX_VALUE;
            for (int k = 0; k < 26; k++) {
                if (need[k] > 0) {
                    int have;
                    if (l > 0) {
                        have = prefix[k][r] - prefix[k][l - 1];
                    } else {
                        have = prefix[k][r];
                    }
									// have / need[k]
                    count = Math.min(count, have / need[k]);
                }
            }

            System.out.println(count);
        }
    }
}


// import java.io.*;
// import java.util.*;

// class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         // 첫 줄: 문자열 길이 n과 문자열 s
//         String[] arr1 = br.readLine().split(" ");
//         int n = Integer.parseInt(arr1[0]);
//         String s = arr1[1];

//         // 쿼리 수
//         int q = Integer.parseInt(br.readLine());

//         for (int i = 0; i < q; i++) {
//             String[] arr3 = br.readLine().split(" ");
//             int l = Integer.parseInt(arr3[0]) - 1; // inclusive (0-based)
//             int r = Integer.parseInt(arr3[1]) - 1; // inclusive (0-based)
//             int m = Integer.parseInt(arr3[2]);
//             String t = arr3[3];

//             // t 문자열 문자 개수 세기
//             Map<Character, Integer> need = new TreeMap<>();
//             for (int j = 0; j < m; j++) {
//                 char c = t.charAt(j);
//                 need.put(c, need.getOrDefault(c, 0) + 1);
//             }

//             // 부분 문자열 [l, r] 문자 개수 세기
//             Map<Character, Integer> haveMap = new TreeMap<>();
//             for (int j = l; j <= r; j++) {
//                 char c = s.charAt(j);
//                 haveMap.put(c, haveMap.getOrDefault(c, 0) + 1);
//             }

//             // 최소 개수 계산
//             int count = Integer.MAX_VALUE;
//             for (Map.Entry<Character, Integer> entry : need.entrySet()) {
//                 char c = entry.getKey();
//                 int needCount = entry.getValue();
//                 int haveCount = haveMap.getOrDefault(c, 0);
//                 count = Math.min(count, haveCount / needCount);
//             }

//             System.out.println(count);
//         }
//     }
// }

