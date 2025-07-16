import java.io.*;
import java.util.*;

class Island implements Comparable<Island> {
    int x, y, index;
    public Island(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
    @Override
    public int compareTo(Island other) {
        if (this.x != other.x) return this.x - other.x;
        else return this.y - other.y;
    }
}

public class Main {
    static List<Integer>[] graph;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Island> islands = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            islands.add(new Island(x, y, i));
        }

        // x, y 기준으로 정렬 (오름차순)
        Collections.sort(islands);

        int [] res = new int [n];

				// 정렬한 섬 순서대로, 자신보다 뒤쪽에 위치한 섬들의 개수(n-i-1)를 res[ArrayList.get.인덱스)에 저장
					  // [island.get(i).index] 인덱스 안에 get(i) 값을 원래 인덱스 값으로
			for (int i = 0; i < n; i++) {
				res[islands.get(i).index] = n - i - 1;
			}
			for (int i = 0; i < n; i++) {
				System.out.println(res[i]);
			}



    }
}
