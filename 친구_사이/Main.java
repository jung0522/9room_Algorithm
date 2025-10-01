import java.io.*;
import java.util.*;

class Main {
	static int dist[];
	static List<List<int []>> graph = new ArrayList<>();
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.parseInt(input);
		
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new int [n];

		String input2 = br.readLine();
		int m = Integer.parseInt(input2);



		// 이미 친분, w = 0
		for(int i = 0; i < m; i++) {
			String input3 = br.readLine();
		  String arr3[] = input3.split(" ");
			int a = Integer.parseInt(arr3[0])-1;
			int b = Integer.parseInt(arr3[1])-1;
			graph.get(a).add(new int[] {b, 0});
			graph.get(b).add(new int[] {a, 0});
		}

		String input4 = br.readLine();
		int k = Integer.parseInt(input4);

	
		
		for(int i = 0; i < k; i++) {
			String input5 = br.readLine();
			String arr5[] = input5.split(" ");
			int u = Integer.parseInt(arr5[0])-1;
			int v = Integer.parseInt(arr5[1])-1;
			int w = Integer.parseInt(arr5[2]);
			graph.get(u).add(new int[] {v, w});
			graph.get(v).add(new int[] {u, w});
		}
		prim(0);
		}

		static void prim(int start) {
		
		  Arrays.fill(dist, -1);
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
			pq.offer(new int[] {0, start});
			// dist[start] = 0; 프림은 안 쓴다.
			long sum = 0;
			int count = 0;

			while(!pq.isEmpty()) {
				int cur[] = pq.poll();
				int curCost = cur[0];
				int current = cur[1];

				// 현재 방문 x
				if(dist[current] != -1)
					continue;

				// 현재 비용 추가
				dist[current] = curCost;
				sum += curCost;
				count++;

				for(int[] nxt : graph.get(current)) {
					int next = nxt[0];
					int w = nxt[1];
					// 다음 방문 x
					if(dist[next] == -1) 
						pq.offer(new int[] {w, next}); 
					
				}
			}
			if(count < n) 
				System.out.println(-1);
			 else
				System.out.println(sum);

		}
}