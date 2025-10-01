import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		String [] arr1 = input.split(" ");
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);

		String input2 = br.readLine();
		String [] arr_g = input2.split(" ");
		Set<String> tset_g = new TreeSet<>();
		for (String s : arr_g) {
			tset_g.add(s);
		}
	

		String input3 = br.readLine();
		String [] arr_f = input3.split(" ");
		Set<String> tset_f = new TreeSet<>();
		for (String s : arr_f) {
			tset_f.add(s);
		}

		
		for(int i = 0; i < m; i++) {
			String input4 = br.readLine();
			String [] arr4 = input4.split(" ");
			String g = arr4[0];
			String f = arr4[1];
			if(tset_g.contains(g) && tset_f.contains(f)) {
				tset_g.remove(g);
				tset_g.add(f);
				tset_f.remove(f);
				tset_f.add(g);
				
			}
		}
		for(String str : tset_g) {
			sb.append(str).append(" ");
		}
		System.out.print(sb);
	}
}