import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);

		String input2 = br.readLine();
		String [] arr1 = input2.split(" ");
		int [] arr2 = new int [n];
		for(int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(arr1[i]);
		}

		// 맛, 번호 쌍 저장, 중복 지원 안 되니까 list로
		Map<Integer, List<Integer>> tmap = new TreeMap<>();
		for(int i = 0; i < n; i++) {
			tmap.putIfAbsent(arr2[i], new ArrayList<>());
			// 맛, 번호 쌍 저장
			tmap.get(arr2[i]).add(i+1);
		}

		// 예외 처리: 맛 - 먹는 순서 <= 0
		int idx = 0;
		boolean zeroCase = false;
		outer:
		for(Map.Entry<Integer, List<Integer>> entry : tmap.entrySet()) {
			int key = entry.getKey();
			List<Integer> nums = entry.getValue();
			Collections.sort(nums);
			for(int num : nums) {
				// 예외 처리: 맛 - 먹는 순서 <= 0
				// 하루가 지날 수록 -1 되므로
				// 같은 맛이 ex) 2면 최소 -1을 해야 하므로 
				// 같은 맛의 개수만큼 +
				if(key - idx <= 0) {
					 zeroCase = true;
					 break outer;
				}
				idx++;
			}
		}

		// 곱셈 0되는 경우(사전 순) 출력과 구한 경우
		if (zeroCase) {
			for(int i = 1; i <= n; i++) {
				System.out.print(i + " ");
			}
		} else {
			for(Map.Entry<Integer, List<Integer>> entry : tmap.entrySet() ) {
				List<Integer> nums = entry.getValue();
				for(int num : nums) {
					System.out.print(num + " ");
				}
			}
		}
		
	}
}