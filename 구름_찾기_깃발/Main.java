import java.io.*;
// 인접한 칸 물어볼때 dx,dy 기법

class Main {
	
	static String[][] board;
	// static int[] dx = {-1, 1, 0, 0};
	// static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	static int n;
	static int k;

	static int k_count;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String [] arr1 = input.split(" ");
		n = Integer.parseInt(arr1[0]);
		k = Integer.parseInt(arr1[1]);
		board = new String[n][n];

		// 격자판 구성
		for(int i = 0; i < n; i++) {
			String input2 = br.readLine();
			String [] arr2 = input2.split(" ");
			for(int j = 0; j < n; j++) {
				 board[i][j] = arr2[j];
			}
		}

		k_count = cntFlag(k);
		System.out.println(k_count);
		
		
	}
	static int cntFlag(int k) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j].equals("0")) {
					int count = 0;
					for(int l = 0; l < 8; l++) {  // 구름 주위 8칸
						int ni = i + dx[l];  // 격자판 행 + 각 8방향
						int nj = j + dy[l];

						if ( (ni >= 0 && ni < n) && (nj >=0 && nj < n) ) { // 8방향이 인덱스 범위 없는 것도 있음
							if ( board[ni][nj].equals("1") ) {
								++count;
							}
						}
						
					}
					if (count == k) {
					++k_count;
					}		
				}
				
			}
		}
		return k_count;
	}
}