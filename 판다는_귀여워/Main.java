import java.io.*;

class Main {
	static String[][] forest;
	static int n;
	static int m;
	static int k;

	// 정수로 표현할 수 있는 최대 수
	static int res = Integer.MAX_VALUE;
	// 거리
	static int dist;

	// 판다의 행 열 저장할 행배열, 열배열
	static int[] p_rows;
	static int[] p_cols;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr1 = input.split(" ");

		n = Integer.parseInt(arr1[0]);
		m = Integer.parseInt(arr1[1]);
		k = Integer.parseInt(arr1[2]);

		// 격자판 구성
		forest = new String[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				forest[i][j] = "0";
			}
		}

		p_rows = new int[k];
		p_cols = new int[k];

		// 판다 좌표 입력받고 2차원 배열에 "1"로 표시 & 행열 각각 저장
		for (int i = 0; i < k; i++) {
			String input2 = br.readLine();
			String[] p_arr = input2.split(" ");
			int p_n = Integer.parseInt(p_arr[0]) - 1;
			int p_m = Integer.parseInt(p_arr[1]) - 1;
			forest[p_n][p_m] = "1";
			p_rows[i] = p_n;
			p_cols[i] = p_m;
		}

		distance();
		System.out.println(res);
	}

	// 거리 측정 후 최소 불만족도 계산 (제곱 거리 방식)
	static void distance() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 각 행열 처음부터 다 계산: 완전 탐색
				if (forest[i][j].equals("1")) continue;

				dist = 0;
				for (int p_k = 0; p_k < k; p_k++) {
					// 첫 번째 펜더 행 열부터 계산하고 초기화 가 아니라 대입
					// 각각의 팬더와 행열(x) 모든 팬더 고려해야 하므로
					int dr = i - p_rows[p_k];
					int dc = j - p_cols[p_k];
					dist += dr * dr + dc * dc;
				}

				if (dist < res) {
					res = dist;
				}
			}
		}
	}
}
