import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = Integer.parseInt(input);
		int max_num = 0;
		String max_prod = "";
		int min_num = 9999999;
		String min_prod = "";
		
		for(int i = 0; i < count; i++ ){
			String in = br.readLine();
			String [] arr = in.split(" ");
			String [] res = new String [2];
			int num = Integer.parseInt(arr[1]);
			
			if(max_num < num ){
				max_num = num;
				max_prod = arr[0];
			}
			if(min_num > num){
				min_num = num;
				min_prod = arr[0];
			}
			
		}
		System.out.println(max_prod + " " + max_num );
		System.out.println(min_prod + " " + min_num );
	}
}