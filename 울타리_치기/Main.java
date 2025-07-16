import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();

		int num1 = Integer.parseInt(input1);
		String [] parts  = input2.split(" "); // split()은 String []
																								// String 해주고 혈 변환
		int [] num2 = new int [parts.length]; // 배열 () 없어
		for (int i = 0; i < num2.length; i++) {
			num2[i] = Integer.parseInt(parts[i]);
		}
		
		int count = 0;
		for (int i = 0; i < num2.length-1; i++){
			if ( num2[i] == num2[i+1] ){
			}
			if ( num2[i] > num2[i+1] ) {
				count += (num2[i] - num2[i+1]);
			}
			if ( num2[i] < num2[i+1]) {
				count += (num2[i+1] - num2[i]);
			}
		}
		count += num2[0] + num2[num2.length-1];
		count += num2.length*2;

		System.out.println(count);
		
		
	}
}