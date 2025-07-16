import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		// 왠만해선 배열로 써라, charAt() 쓰지 말고
		String [] arr0 =  input.split(" ");
		int n = Integer.parseInt(arr0[0]);
		int k = Integer.parseInt(arr0[1]);
		
		// int n = input.charAt(0) - '0';
		// int k = input.charAt(2) - '0';

		String input2 = br.readLine();
		String [] arr1 = input2.split(" ");
		int [] arr2 = new int [arr1.length];
		for (int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(arr1[i]);
		} 

		int [] arr3 = new int [n];
		for(int i = 0; i < n; i++) {
			
			int count = 0;
			for(int val = arr2[i]; val > 0; val /= 2) {
				if (val % 2 == 1) {
					count++;
				}
				
			}
			arr3[i] = count;
		}
		
		for(int i = 0; i < n-1; i++) {
			 for(int j = 0; j < n - i - 1; j++) {
				 if (arr3[j] < arr3[j+1] || (arr3[j] == arr3[j+1] && arr2[j] < arr2[j+1]) ) {
					 swap(arr3, j, j+1);
					 swap(arr2, j, j+1);
					 
				 }
			 }
		}
		System.out.println(arr2[k-1]); // k는 1번째부터 시작하므로, -1
	}
	// arr [] 같이 받으면 reference by value
	static void swap(int [] arr, int x, int y) {
		int temp = arr[y];
		arr[y] = arr[x];
		arr[x] = temp; 

	}
}