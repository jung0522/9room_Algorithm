import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String [] parts = input.split(" "); // 문자열 공백 기준 배열로
		int [] nums = new int [2]; 
		
		for(int i = 0; i < parts.length; i++){
			nums[i] = Integer.parseInt(parts[i]);
		}

		int _1RM = (int) (nums[0] * (1 + (double)nums[1] / 30));
		System.out.println(_1RM);
		
	}
}