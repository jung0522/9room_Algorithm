import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		for (int i = 0; i < n; i++) {
			String nums = br.readLine();
			String [] numArr = nums.split(" ");
			// long으로 
			long num1 = Long.parseLong(numArr[0]);
			long num2 = Long.parseLong(numArr[1]);

					// Math(lang) 함수: Math.min(num1, num2), Math(num1 - num2)
			long min_val =  Math.min(num1, num2);
			long max_val =  Math.max(num1, num2);
			long abs_val =  Math.abs(num1 - num2);
			
			
			if ( num1 > num2) {
				if( ( num2*160 <= num1*100) && ( num2*163 >= num1*100 ) ){ // 부동 소수 계산 시 오류 가능성 있으므로 양 변에 100씩 곱해줌
					count += 1;
				}
			}
			else {
				if( ( num1*160 <= num2*100) && ( num1*163 >= num2*100) ){
					count+=1;
				}
						
			}
		}
		System.out.println(count);
		
	}
}