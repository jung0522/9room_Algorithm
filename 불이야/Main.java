// bfs 1번 호출이면
// isVisited(단순) or for (int i = 0; i < m; i++) Arrays.fill(fireTime[i], INF); bfs 밖에서 초기화
import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int m, n;
    static String[][] lab;
    static int[][] fireTime;
    static Queue<int[]> fireQ = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        m = Integer.parseInt(arr1[0]);
        n = Integer.parseInt(arr1[1]);

        lab = new String[m][n];
        fireTime = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(fireTime[i], -1); // -1로 초기화

        int g_y = -1, g_x = -1;

        for (int y = 0; y < m; y++) {
            String[] arr2 = br.readLine().split("");
            for (int x = 0; x < n; x++) {
                lab[y][x] = arr2[x];
                if (arr2[x].equals("@")) { // 불 시작점
                    fireQ.offer(new int[]{y, x});
                    fireTime[y][x] = 0;
                }
                if (arr2[x].equals("&")) { // 목표점
                    g_y = y;
                    g_x = x;
                }
            }
        }

        bfs();

        int minTime = Integer.MAX_VALUE;
        for (int dir = 0; dir < 4; dir++) {
            int ny = g_y + dy[dir];
            int nx = g_x + dx[dir];
            if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                if (!lab[ny][nx].equals("#") && fireTime[ny][nx] != -1) {
                    minTime = Math.min(minTime, fireTime[ny][nx]);
                }
            }
        }

        // if-else로 출력
        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }
    }

    static void bfs() {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int y = cur[0];
            int x = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                    if (fireTime[ny][nx] == -1 && !lab[ny][nx].equals("#")) {
                        fireTime[ny][nx] = fireTime[y][x] + 1;
                        fireQ.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
