import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static List<List<int[]>> graph = new ArrayList<>();
    static int people; // 전역 변수로 선언

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr1 = br.readLine().split(" ");
        int n = Integer.parseInt(arr1[0]);
        int m = Integer.parseInt(arr1[1]);

        dist = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        String[] arr2 = br.readLine().split(" ");
        int start = Integer.parseInt(arr2[0]) - 1;
        int end = Integer.parseInt(arr2[1]) - 1;
        people = Integer.parseInt(arr2[2]); // 전역 변수에 저장

        for (int i = 0; i < m; i++) {
            String[] arr3 = br.readLine().split(" ");
            int u = Integer.parseInt(arr3[0]) - 1;
            int v = Integer.parseInt(arr3[1]) - 1;
            int capacity = Integer.parseInt(arr3[2]);
            int cost = 1;

            graph.get(u).add(new int[]{v, capacity, cost});
            graph.get(v).add(new int[]{u, capacity, cost});
        }

        dijkstra(start); // 이제 매개변수에 people 필요 없음
        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        Arrays.fill(dist, -1);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int current = cur[1];

            if (dist[current] != -1 && curCost > dist[current])
                continue;

            for (int[] nxt : graph.get(current)) {
                int next = nxt[0];
                int capacity = nxt[1];
                int w = nxt[2];

                int real_w = ((people + capacity - 1) / capacity) * w; // 전역 변수 사용

                if (dist[next] == -1 || dist[current] + real_w < dist[next]) {
                    dist[next] = dist[current] + real_w;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }
    }
}
