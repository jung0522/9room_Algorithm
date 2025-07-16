import java.io.*;
import java.util.*;

class Puddle {
	int x, y;
	Puddle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	// 특정 위치가 웅덩이인지 확인하는 정적 메서드
	static boolean isNotPuddled(int x, int y, List<Puddle> puddles) {
		for (Puddle puddle : puddles) {
			if (puddle.x == x && puddle.y == y) {
				return false;
			}
		}
		return true;
	}
}


class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Puddle> puddles = new ArrayList <>();
		String input = br.readLine();
		String [] arr1 = input.split(" ");
		int move_x = Integer.parseInt(arr1[0]);
		int move_y = Integer.parseInt(arr1[1]);
	

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String input2 = br.readLine(); // input 매번 새롭게 선언
			String [] arr2 = input2.split(" ");
			int x = Integer.parseInt(arr2[0]);
			int y = Integer.parseInt(arr2[1]);
			Puddle puddle = new Puddle(x, y);
			puddles.add(puddle);
		}

		int move = Integer.parseInt(br.readLine());
		String [] arr3 = br.readLine().split(" ");

		for (int i = 0; i < move; i++) {
			int next_x = move_x;
			int next_y = move_y;

			if (arr3[i].equals("R")) {
					next_x++;		
			}
			if (arr3[i].equals("L")) {
					next_x--;		
			}
			if (arr3[i].equals("U")) {
				  next_y++;
			}
			if (arr3[i].equals("D")) {
					next_y--;
			}
		
			boolean flag = Puddle.isNotPuddled(next_x, next_y, puddles);
		// Puddle은 타입, static 메서드의 경우 객체 없이도 타입으로 호출 가능!!
			if (flag) {
				move_x = next_x;
				move_y = next_y;
			}
			
		}
		System.out.println(move_x + " " + move_y);
	}
}