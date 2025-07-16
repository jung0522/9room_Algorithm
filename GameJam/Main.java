import java.io.*;
import java.util.*;

// boolaen을 조건 식으로 반복문 끝내려면 바로 끝나는 게 아니라 돌고 나서 끝남

public class Main {

    static int n;
    static int[][] cnt_arr;
    static String[][] cmd_arr;

    static int[] dx = {-1, 1, 0, 0}; // U, D, R, L 행열에서 이동
	  static int[] dy = {0, 0, 1, -1}; // U는 Up으로 행 하나 감소 x -1

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 구름 말 위치 입력
        String[] arr2 = br.readLine().split(" ");
        int g_x = Integer.parseInt(arr2[0]) - 1;
        int g_y = Integer.parseInt(arr2[1]) - 1;

        // 플레이어 말 위치 입력
        String[] arr3 = br.readLine().split(" ");
        int p_x = Integer.parseInt(arr3[0]) - 1;
        int p_y = Integer.parseInt(arr3[1]) - 1;

        // 이동 명령과 횟수 입력
        cnt_arr = new int[n][n];
        cmd_arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] arr4 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                String count_part = arr4[j].replaceAll("[^0-9]", "");
                int count = Integer.parseInt(count_part);
                String command = arr4[j].replaceAll("[0-9]", "");
                cnt_arr[i][j] = count;
                cmd_arr[i][j] = command;
            }
        }

        int goormScore = move(g_x, g_y);
        int playerScore = move(p_x, p_y);

        if (goormScore > playerScore) {
            System.out.println("goorm " + goormScore);
        } else {
            System.out.println("player " + playerScore);
        }
    }
				// 메서드는 Main 안 void main 밖
    static int move(int startX, int startY) {
    
		String[][] visited = new String[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            visited[i][j] = "0";  // 모두 미방문으로 초기화
        }
    }

    int x = startX;
    int y = startY;
    visited[x][y] = "1";  // 시작 위치 방문 표시
    int score = 1; // 시작 위치 포함 방문
		
		// 조건문에 숫자 불가능 ^C
    while (true) {
        int cnt = cnt_arr[x][y];
        String cmd = cmd_arr[x][y];

        int dir = 0;
        if (cmd.equals("U")) {
			    dir = 0;
				} else if (cmd.equals("D")) {
			    dir = 1;
				} else if (cmd.equals("R")) {
			    dir = 2;
				} else if (cmd.equals("L")) {
			    dir = 3;
				}


        for (int i = 0; i < cnt; i++) {
					// 행렬은 방향 설정이 이미 되어있으므로 
            x = (x + dx[dir] + n) % n;
            y = (y + dy[dir] + n) % n;

            if (visited[x][y].equals("1")) {
                return score; 
            }
            visited[x][y] = "1";
            score++;
        }
    }
	}

}
