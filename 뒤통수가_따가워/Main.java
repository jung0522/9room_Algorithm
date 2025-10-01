import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		int n = Integer.parseInt(input);

		String input2 = br.readLine();
		String [] arr1 = input2.split(" ");
		int [] arr2 = new int [n];
		for(int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(arr1[i]);
		}
		
		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < n; i++) {
			sb.append(stack.size()).append(" ");
			// 맨 뒤로부터 앞(peek)
			while(!stack.isEmpty() && arr2[stack.peek()] <= arr2[i]) {
				stack.pop();
			}
			// 앞에서부터 1씩 비교하므로 1씩 증가
			// 0, 1은 앞에 1개, 2는 앞에 2개
			stack.push(i);
		}
		System.out.println(sb);
	
		
	}
}