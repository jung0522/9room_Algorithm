import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if (input == null) {
			return;
		}
		String [] condi = input.split(" ");
		int n = Integer.parseInt(condi[0]);
		int m = Integer.parseInt(condi[1]);
		int x = Integer.parseInt(condi[2]) - 1;
		int res = 0;

		String input2 = br.readLine();
		String [] arr0 = input2.split(" ");
		int [] arr1 = new int [n]; // 배열의 각각 요소를 ex) 문자열 -> 숫자
															// 새로운 배열을 만들어서 각 요소를 집어 넣음(복사)
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = Integer.parseInt(arr0[i]);
		}
		
		String input3 = br.readLine();
		int q = Integer.parseInt(input3);
		
		String input4 = br.readLine();
		String [] arr2 = input4.split(" ");
		for (int i = 0; i < q; i++) { 

			if ( arr2[i].equals("S")  ) {
					if (arr1[x] >= m ) {
			     res += arr1[x];
					 arr1[x] = 0;
					}
					x = x; // 그대로             
					for (int j = 0; j < arr1.length; j++) {
						arr1[j] += 1;
					}
			
				}
			
			if ( arr2[i].equals("R") ) {
				if (arr1[x] >= m ) {
			     res += arr1[x];
					 arr1[x] = 0;
					}
					x = (x+1) % n;
				
//				x +=1;
//				if (x < 0){ // - 인덱스가 되는 경우
//						x += n;       // x(현재 위치) + n(주기)를 해준다.
//				}
					
//				if (x > n-1) { // n-1보다 큰 초과 인덱스가 되는 경우
//						x -= n;       // x(현재 위치) - n(주기)를 해준다.
//					}
				for (int j = 0; j < arr1.length; j++) {
						arr1[j] += 1;
					}
				}
			if ( arr2[i].equals("L") ) {
				if  (arr1[x] >= m ) {
			     res += arr1[x];
					 arr1[x] = 0;
				}
				// - 때는 +n까지
				x = (x - 1 + n) % n; 
		//		x -= 1;
			
		//		if (x < 0 ){ // - 인덱스가 되는 경우
		//				x += n;       // x(현재 위치) + n(주기)를 해준다.
		//		}
					
		//		if (x > n-1) { // n-1보다 큰 초과 인덱스가 되는 경우
		//				x -= n;       // x(현재 위치) - n(주기)를 해준다.
		//			}
				
				for (int j = 0; j < arr1.length; j++) {
						arr1[j] += 1;
					}
			}
			
		}
		System.out.println(res);
	}
}