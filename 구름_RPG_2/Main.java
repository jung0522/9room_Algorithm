import java.io.*;
class Main {
	static int count;
	static boolean isPrime = true;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		for(int i = 0; i < n; i++) {
		
			String str_armor = br.readLine();
			int armor = Integer.parseInt(str_armor);

			count = 0;
			isPrime = cal_Prime(armor);

			if (isPrime) {
				System.out.println(0);
			}
			
			if (!isPrime) {
				for(int j = armor; j > 2; j--) {
					count++;
					isPrime = cal_Prime(j-1);
					
					if (isPrime == true) {
						break;
					}
				}
				if (!isPrime) {
					System.out.println(-1);
				}
				else {
					System.out.println(count);
				}
			}

			
		}
		
	}
	static boolean cal_Prime(int armor) {
		
		isPrime = true; 
		for(int j = 2; j <= Math.sqrt(armor); j++)
			if (armor % j == 0) {
				isPrime = false;
			}
		return isPrime;
	} 
}