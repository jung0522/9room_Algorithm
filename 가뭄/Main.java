import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int t = Integer.parseInt(input);

		for(int i = 0; i < t; i++) {
			String input2 = br.readLine();
			String [] arr1 = input2.split(" ");
			// n 지점(노드) m 수로(간선)
			int n = Integer.parseInt(arr1[0]);
			int m = Integer.parseInt(arr1[1]);

			// 수로 정보는 사실 사용하지 않아도 됨 (문제 조건상 항상 연결되어 있으므로)
			// 걍 버리는 거임
			for(int j = 0; j < m; j++) {
				String input3 = br.readLine();
			}

			//  MST를 만들기 위한 최소 간선 개수 = N - 1
			System.out.println(n-1);

		}	
	}
}