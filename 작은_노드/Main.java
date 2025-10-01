import java.io.*;
import java.util.*;

class Main {
	static List<List<Integer>> undirGraph = new ArrayList<>();
	static boolean [] isVisited; 
	static int count;
	static int lastNode;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input = br.readLine();
		String [] arr1 = input.split(" ");
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);
		int k = Integer.parseInt(arr1[2]) -1;

		//
		for(int i = 0; i < n; i++) {
			undirGraph.add(new ArrayList<>());
		}
		

		isVisited = new boolean[n];

		for(int i = 0; i < m; i++) {
			String input2 = br.readLine();
			String [] arr2 = input2.split(" ");
			int u = Integer.parseInt(arr2[0]) -1;
			int v = Integer.parseInt(arr2[1]) -1;
			addEdge(u, v);
		}

		
		for (List<Integer> neighbor : undirGraph) {
			Collections.sort(neighbor);
		}
		
		int cnt = dfs(k);
	
		System.out.println(cnt+ " "+ lastNode);
		
	}
	static void addEdge(int u, int v) {
		undirGraph.get(u).add(v);
		undirGraph.get(v).add(u);
	}
	static int dfs(int node) {
		isVisited[node] = true;
		count = 1;
		lastNode = node+1;
		for(int next : undirGraph.get(node)) {
			if(!isVisited[next]) {
				count += dfs(next);
				
				break;  // 가장 번호가 작은 노드 한 개만 방문 후 즉시 종료
			}
		}
		return count;
	
	}
}