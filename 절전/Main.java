import java.io.*;
import java.util.*;
class Main {
	static int dist[];
	static List<List<int[]>> graph = new ArrayList<>();
	static long tot = 0;
	static int k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String arr[] = input.split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		k = Integer.parseInt(arr[2]);
		dist = new int[n];
		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

	
		for(int i = 0; i < m; i++) {
			String input2 = br.readLine();
			String arr2[] = input2.split(" ");
			int u = Integer.parseInt(arr2[0]) - 1;
			int v = Integer.parseInt(arr2[1]) - 1;
			int w = Integer.parseInt(arr2[2]);
			graph.get(u).add(new int[] { v, w });
			graph.get(v).add(new int[] { u, w });
			tot += w;
		}
		prim(0, k);
		
	} 
	static void prim(int start, int k) {
		Arrays.fill(dist, -1);
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		pq.offer(new int[]{0, start});
		long sum = 0;
		int count = 0;

		// 모든 정점이 아니라 최대 k이므로
		while(!pq.isEmpty() && count < k) {
			int cur[] = pq.poll();
			int curCost = cur[0];
			int current = cur[1];

			if(dist[current] != -1) 
				continue;

			dist[current] = curCost;
			sum += curCost;
			count++;

			for(int [] nxt : graph.get(current)) {
				int next = nxt[0];
				int w = nxt[1];
				if(dist[next] == -1) 
					pq.offer(new int[]{w, next});
			}
		}
		System.out.println(tot - sum);
	}
	
}