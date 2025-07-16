import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = Integer.parseInt(input);
		int res = 0;
		int total = 0;
		
		for(int i = 0; i < count; i++){
			String in = br.readLine();
			String [] cal = in.split(" ");
			int num1 = Integer.parseInt(cal[0]);
			String op = cal[1];
			int num2 = Integer.parseInt(cal[2]);
			
				
			if (op.equals("+")){ // 문자열 .eqauls()
				res = num1 + num2;
			}
			if (op.equals("-")){
				res = num1 - num2;
			}
			if (op.equals("*")){
				res = num1 * num2;
			}
			if (op.equals("/")){
				res = num1 / num2;
			}
			total += res;
		}
		System.out.println(total);
	}
}