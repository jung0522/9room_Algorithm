import java.io.*;
import java.util.*;
class Main {
	static boolean[] isVisited;
	static List<List<Integer>> graph = new ArrayList<>();
	static int languages[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String [] arr1 = input.split(" ");
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);

		for(int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		// isVisited = new boolean[n];

		// 각 나라의 사용하는 언어
		languages = new int [n];
		String input2 = br.readLine();
	  String [] arr2 = input2.split(" ");
		for(int i = 0; i < n; i++) {
			languages[i] = Integer.parseInt(arr2[i]);
		}

		// 시작 언어 1번
		int startLang = languages[0];

		// 언어 후보 집합(중복 제거)
		Set<Integer> languageSet = new HashSet<>();
		for(int i = 0; i < n; i++) {
			languageSet.add(languages[i]);
		}

		// 간선 추가
		for(int i = 0; i < m; i++) {
			String input3 = br.readLine();
			String [] arr3 = input3.split(" ");
			int u = Integer.parseInt(arr3[0])-1;
			int v = Integer.parseInt(arr3[1])-1;
			// 무방향
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

			// 방문 개수 최대
		int maxCount = 0;

		// 1. 추가 언어 없이 출발 언어만 아는 경우 계산
		isVisited = new boolean[n];
		// dfs(시작, 시작 언어, 아직 없음)
		int count = dfs(0, startLang, -1);
		maxCount = Math.max(count, maxCount);

		// 언어 후보 하나씩 실행
		for(int lang : languageSet) {
			
			if (lang == startLang) continue;
			// 방문할 때 마다 초기화
			isVisited = new boolean[n];
			int count2 = dfs(0, startLang, lang );
			maxCount = Math.max(count2, maxCount);
			
		}
		System.out.println(maxCount);
		
	}
	static int dfs(int node, int lang1, int lang2) {
		isVisited[node] = true;
		int testCount = 1;
		for(int next : graph.get(node) ) {
			if(!isVisited[next]) {
				int lang = languages[next];
				if(lang == lang1 || lang == lang2) {
					testCount += dfs(next, lang1, lang2);
				}
			}
		}
		return testCount;
		
	}
}

