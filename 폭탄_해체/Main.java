import java.io.*;
import java.util.*;

public class Main {
    static int[] degree; // 각 기폭 장치의 연결된 전선 개수
    static int[][] edges; // 전선 정보 저장 [M][2]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input = br.readLine();
				String [] arr1 = input.split(" ");
				int n = Integer.parseInt(arr1[0]);
				int m = Integer.parseInt(arr1[1]);

				// 전선들이 1번 부터 시작 된다고 했으므로 0번 안 쓰고 1번 부터이므로 크기는 +1
        degree = new int[n + 1];
			 // 전선은 u, v가 필요하므로
        edges = new int[m][2];

			for(int i = 0; i < m; i++) {
				String input2 = br.readLine();
				String [] arr2 = input2.split(" ");
				int u = Integer.parseInt(arr2[0])-1;
				int v = Integer.parseInt(arr2[1])-1;
				edges[i][0] = u;
				edges[i][1] = v;
				degree[u]++;
				degree[v]++;
			}

			List<Integer> safeEdges = new ArrayList<>();
			// 각 전선을 끊어본다
			for(int i = 0; i < m; i++) {
				// 입력된 u-v 전선
				int u = edges[i][0];
				int v = edges[i][1];
				// 기폭 장치에 연결된 전 선 끊기
				int afterDegreeU = degree[u]-1;
				int afterDegreeV = degree[v]-1;

				if(afterDegreeU > 0 && afterDegreeV > 0) {
					safeEdges.add(i+1);
				}
				
			}
			if (safeEdges.isEmpty()) {
				System.out.println(-1);
			} else {
				Collections.sort(safeEdges);
				for(int idx : safeEdges) {
					System.out.print(idx + " ");
				}
			}

    }
}
