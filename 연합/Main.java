import java.io.*;
import java.util.*;

class Main {
    static private List<List<Integer>> dirGraph = new ArrayList<>();
    static private List<List<Integer>> undirGraph = new ArrayList<>();
    static private boolean isVisited[];
    static private Set<String> edgeSet = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr1 = input.split(" ");
        int n = Integer.parseInt(arr1[0]);
        int m = Integer.parseInt(arr1[1]);

        isVisited = new boolean[n];

        // 단방향 그래프, 양방향 그래프 초기화
        for (int i = 0; i < n; i++) {
            dirGraph.add(new ArrayList<>());
            undirGraph.add(new ArrayList<>());
        }

        // 입력 간선 단방향 그래프 추가
        for (int i = 0; i < m; i++) {
            String input2 = br.readLine();
            String[] arr2 = input2.split(" ");
            int u = Integer.parseInt(arr2[0]) - 1;
            int v = Integer.parseInt(arr2[1]) - 1;
            dirGraph.get(u).add(v);
            edgeSet.add(u + " " + v);
        }

        // 양방향 그래프 생성
        for (int u = 0; u < n; u++) {
            for (int v : dirGraph.get(u)) {
                if (edgeSet.contains(v + " " + u)) {
                    undirGraph.get(u).add(v);
                    undirGraph.get(v).add(u);
                }
            }
        }

        int unionCount = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                int nodesInComponent = dfs(i);
                // System.out.println("연합 " + (unionCount + 1) + " 노드 수: " + nodesInComponent);
                unionCount++;
            }
        }

        System.out.println(unionCount);
    }

    // dfs 함수에서 방문한 노드 수 반환
    static int dfs(int node) {
        isVisited[node] = true;
        int count = 1; // 현재 노드 포함

        for (int next : undirGraph.get(node)) {
            if (!isVisited[next]) {
                count += dfs(next);
            }
        }
        return count;
    }
}
