import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int alice = 0;
		int bob = 0;
		String input1 = br.readLine();
		String input2 = br.readLine();
		String [] num_arr1 = input1.split(" ");
		String [] num_arr2 = input2.split(" ");
		for(int i = 0; i < num_arr1.length; i++) {
			int num1 = Integer.parseInt(num_arr1[i]);
			int num2 = Integer.parseInt(num_arr2[i]);

			if ( (num1 - num2) == 7 ) {
				bob += 3;
				alice -= 1;
				continue; //겹치는 조건 있을 경우 반복문 증감으로 뛰어넘기
			}
			if ( (num2 - num1) == 7 ) {
				alice += 3;
				bob -= 1;
				continue;
			}
			if (num1 > num2) {
				alice += 2;
				continue;
			}
			if (num1 < num2) {
				bob += 2;
				continue;
			}
			if (num1 == num2) {
				alice += 1;
				bob += 1;
				continue;
			}
		}
		System.out.println(alice + " " + bob);
	}
}