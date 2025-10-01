import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int n = Integer.parseInt(input);

		Map<String, Integer> trmap = new TreeMap<>();
		
		for(int i = 0; i < n; i++) {
			String input2 = br.readLine();
			String arr1 [] = input2.split(" ");
			String s = arr1[0];
			int a = Integer.parseInt(arr1[1]);
			// hsmap.getOrDefault(key, 0(없으면 반환))
			trmap.put(s, trmap.getOrDefault(s, 0) + a);
		}

		// trmap 출력 직접 타이핑
		// for(Map.Entry<String, integer> entry : trmap.entrySet())
		for(Map.Entry<String, Integer> entry : trmap.entrySet() ) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}
		  System.out.print(sb);
	}
}