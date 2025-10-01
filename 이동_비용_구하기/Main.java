import java.io.*;
import java.util.*;

class Main {
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        int n = Integer.parseInt(arr1[0]);
        int m = Integer.parseInt(arr1[1]);

        dist = new int[n];
        

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int s = Integer.parseInt(br.readLine()) - 1; // 0 기반 인덱스

        for (int i = 0; i < m; i++) {
            String[] arr2 = br.readLine().split(" ");
            int u = Integer.parseInt(arr2[0]) - 1; // 0 기반
            int v = Integer.parseInt(arr2[1]) - 1; // 0 기반
            int w = Integer.parseInt(arr2[2]);
            graph.get(u).add(new int[]{v, w});
        }

        dijkstra(s);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dist[i]; // dist[i]가 -1이면 그대로 더함
        }
        System.out.println(sum);
    }

    static void dijkstra(int start) {
			  Arrays.fill(dist, -1); // 초기값 -1

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        dist[start] = 0;
			  pq.offer(new int[]{0, start});

				while(!pq.isEmpty()) {
			    int cur [] = pq.poll();
			    int curCost = cur[0];
			    int current = cur[1];

		    // 여기에 있어야 함
			    if(dist[current] != -1 && curCost > dist[current])
		        continue;

		    for(int [] nextArr : graph.get(current)) {
	        int next = nextArr[0];
	        int w = nextArr[1];

		      if(dist[next] == -1 || dist[current] + w < dist[next]) {
             dist[next] = dist[current] + w;
             pq.offer(new int[]{dist[next], next});
		        }
			    }
					
				}

			
    }
}
