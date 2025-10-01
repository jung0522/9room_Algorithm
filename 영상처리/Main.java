// bfs 1번 호출이면
// isVisited(단순) or for (int i = 0; i < m; i++) Arrays.fill(fireTime[i], INF); bfs 밖에서 초기화
 import java.io.*;
import java.util.*;

public class Main {
    static int n, m; // n = 열, m = 행
    static String[][] picture;
    static int[][] dist; // 방문 체크 + 거리 (isVisited 대신 사용)
    static final int[] dx = {0, 0, -1, 1}; // 좌, 우
    static final int[] dy = {-1, 1, 0, 0}; // 상, 하

    static int count = 0;
    static int maxSize = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        n = Integer.parseInt(arr1[0]); // 열
        m = Integer.parseInt(arr1[1]); // 행

        picture = new String[m][n];
        dist = new int[m][n];

        // 사진 입력
        for (int y = 0; y < m; y++) {
            String[] arr2 = br.readLine().split("");
            for (int x = 0; x < n; x++) {
                picture[y][x] = arr2[x];
            }
        }

        // 전체 탐색
        for (int y = 0; y < m; y++) {
            Arrays.fill(dist[y], -1); // 초기화 필요시 (여기선 BFS 안에서 처리하므로 생략 가능)
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (picture[y][x].equals("#") && dist[y][x] == -1) {
                    int size = bfs(y, x);
                    count++;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(count + "\n" + maxSize);
    }

    static int bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        dist[sy][sx] = 0; // 방문 체크
        queue.offer(new int[]{sy, sx});
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                    if (dist[ny][nx] == -1 && picture[ny][nx].equals("#")) {
                        dist[ny][nx] = dist[y][x] + 1; // 거리 기록 + 방문 체크
                        queue.offer(new int[]{ny, nx});
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
