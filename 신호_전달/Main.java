import java.io.*;
import java.util.*;

class Main {
	// 3차원 배열[행][열][거리]
	static int dist[][][];
	static int board[][];
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
  static final int ANTENA = 10;
	static final int S = 11;
	static final int E = 12;
	static final int VS = 13;

	// 전역으로 사용
	static int m;
	static int n;

	static int res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String arr1 [] = input.split(" ");
		m = Integer.parseInt(arr1[0]);
		n = Integer.parseInt(arr1[1]);
		dist = new int[m][n][8];
		board = new int[m][n];

		int sy = 0, sx = 0, ey = 0, ex = 0;
		
		for(int i = 0; i < m; i++) {
			String input2 = br.readLine();
			String arr2 [] = input2.split("");
			for(int j = 0; j < n; j++) {
				
				if (arr2[j].equals(".")) {
					board[i][j] = ANTENA;
					continue;
				}
					

				else if (arr2[j].equals("S")) {
					board[i][j] = S;
					sy = i;
					sx = j;
					continue;
				}

				else if (arr2[j].equals("E")) {
					board[i][j] = E;
					ey = i;
					ex = j;
					continue;
				}

				else if (arr2[j].equals("#")) {
					board[i][j] = VS;
					continue;
				}
				else {
					board[i][j] = Integer.parseInt(arr2[j]);
				}
					
			}
		}
		dijkstra(sy, sx, ey, ex);
		System.out.println(res);
		
	}
	static void dijkstra(int sy, int sx, int ey, int ex) {
		for(int i = 0; i < m; i++) {
	    for(int j = 0; j < n; j++) {
        Arrays.fill(dist[i][j], -1);
	    }
		}

																													// a[2](비용) 기준
		PriorityQueue <int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); 
		// 8방향 모두 시작점에서 비용 0으로 큐에 넣는다.
		for(int dir = 0; dir < 8; dir++) {
			dist[sy][sx][dir] = 0;
			              // y, x, cost, dir
			pq.offer(new int[]{sy, sx, 0, dir});
		}

		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			int cy = cur[0];
			int cx = cur[1];
			int curCost = cur[2];
			int cDir = cur[3];
			
		  if( dist[cy][cx][cDir] != -1 && curCost > dist[cy][cx][cDir] ) 
				continue;

			int val = board[cy][cx];
			
			if(val >= 1 && val <= 9) { // 숫자 칸 방향 유지, cDir로 가니까 
				int ny = cy + dy[cDir];
				int nx = cx + dx[cDir];
				if( ny < m && ny >= 0 && nx < n && nx >= 0 ) {
					if( board[ny][nx] != VS ) {
						// 여기선 만들어라
						int nCost = curCost + val;
						if(dist[ny][nx][cDir] == -1 || dist[ny][nx][cDir] < nCost) {
							dist[ny][nx][cDir] = nCost;
							pq.offer(new int[]{ny, nx, nCost, cDir});
						}
					}
				}
			} 
			else { // S, ANTENA, E: 8방향 자유 이동
				for(int nDir = 0; nDir < 8; nDir++) {
					
					int ny = cy + dy[nDir];
					int nx = cx + dx[nDir];
					if( ny < m && ny >= 0 && nx < n && nx >= 0) {
						if(board[ny][nx] != VS) {
						// 여기서 만들어라
							int nCost = curCost + 1;
							if(dist[ny][nx][nDir] == -1 || dist[ny][nx][nDir] > nCost) {
								dist[ny][nx][nDir] = nCost;
								pq.offer(new int[]{ny, nx, nCost, nDir});
							}
						}
					}
				}
			}
		}
		
		res = Integer.MAX_VALUE;
		for(int dir = 0; dir < 8; dir++) {
		    if(dist[ey][ex][dir] != -1) {  // -1은 방문 안 한 경우
		        res = Math.min(res, dist[ey][ex][dir]);
		    }
		}
		if(res == Integer.MAX_VALUE) 
			res = -1;

		
	}
}