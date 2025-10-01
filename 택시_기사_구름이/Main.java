// bfs 함수를 2번 이상 호출하면 bfs 안에서 초기화 해주셈
// 1. isVisited 필요 없고 dist로
// 2.dist 초기화: bfs 안에서 for(int[] row : dist)  Arrays.fill(row, -1);
// 거리 구해야 하면 dist[ny][nx] = dist[cy][cx] + 1;(isVisited 역할도 함)
import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {0, 0, -1, 1}; // 좌, 우
    static final int[] dy = {-1, 1, 0, 0}; // 상, 하

    static int n, m, x, y, z;
    static int[][] board;
    static int[] a, b, c, d;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 크기, 손님 수 입력
        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        board = new int[n][n];
        dist = new int[n][n];
        a = new int[m];
        b = new int[m];
        c = new int[m];
        d = new int[m];

        // 요금 관련 변수 입력
        String[] secondLine = br.readLine().split(" ");
        x = Integer.parseInt(secondLine[0]);
        y = Integer.parseInt(secondLine[1]);
        z = Integer.parseInt(secondLine[2]);

        // 맵 정보 입력
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        // 손님 승하차 좌표 입력
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            a[i] = Integer.parseInt(line[0]) - 1;
            b[i] = Integer.parseInt(line[1]) - 1;
            c[i] = Integer.parseInt(line[2]) - 1;
            d[i] = Integer.parseInt(line[3]) - 1;
        }

        int tx = a[0], ty = b[0]; // 택시 초기 위치 = 첫 손님 승차 지점
        int res = 0;

        for (int i = 0; i < m; i++) {
            int move = bfs(tx, ty, a[i], b[i]); // 손님 태우러 가는 거리
            int work = bfs(a[i], b[i], c[i], d[i]); // 손님 목적지까지 거리
            tx = c[i];
            ty = d[i]; // 택시 위치 갱신

            // 요금 계산
            if (work <= 5)
                res += x;
            else
                res += x + (work - 5) * y;

            // 통행료 차감
            res -= (move + work) * z;
        }

        System.out.println(res);
    }

    // (sx, sy) -> (ex, ey) 최단 거리 BFS
    static int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();

        for (int[] row : dist)
            Arrays.fill(row, -1);

        dist[sy][sx] = 0; // 시작점 (y, x)
        q.offer(new int[]{sy, sx});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    if (dist[ny][nx] == -1 && board[ny][nx] == 0) {
                        dist[ny][nx] = dist[cy][cx] + 1;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return dist[ey][ex]; // 도착점 (y, x)
    }
}
