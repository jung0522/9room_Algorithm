import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		String input2 = br.readLine();
		String [] arr1 = input2.split(" ");
		int [] arr2 = new int [n];
		
		for(int i  = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(arr1[i]); 
		}

		
		int power = 0; // 파워
		int count = 0; // 횟수(결과)
		int h = 0;  // hp
		int i = 0;  // 인덱스
		int num = 1;  // 몇 번째
		
		while (arr2[i] > 0) {
					power = ((num-1) % 4) + 1;
					h = arr2[i] - power;
					arr2[i] = h;
					num++;
					count++;
					if (h <= 0) {
						i++;
						if (i == n) {
							break;
					}
				}
		}
		
	System.out.println(count);
	}
}