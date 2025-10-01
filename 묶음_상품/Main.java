import java.io.*;
import java.util.*;

class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr1 = input.split(" ");
        int n = Integer.parseInt(arr1[0]);
        int m = Integer.parseInt(arr1[1]);

				// 1부터 n포함까지, n+1로 전체 크기 늘려서
       parent = new int[n+1];
			for(int i = 1; i <= n; i++) {
				parent[i] = i;
			}

        for (int i = 0; i < m; i++) {
            String[] arr2 = br.readLine().split(" ");
            int a = Integer.parseInt(arr2[0]);
            int b = Integer.parseInt(arr2[1]);
            union(a, b);
        }

        Set<Integer> uniqueBundle = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            uniqueBundle.add(find(i));
        }

        System.out.println(uniqueBundle.size());
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
           parent[rootB] = rootA;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
