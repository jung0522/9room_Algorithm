import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String [] arr1 = input.split(" ");
		int a = Integer.parseInt(arr1[0]);
		int b = Integer.parseInt(arr1[1]);
		int c = Integer.parseInt(arr1[2]);

		int n = Integer.parseInt(br.readLine());

		int totalN = 0;
		long totalPrice = 0;


		// map 자료구조는 중복 허용 x 같은 값이면 반영 x
		  List<Integer> xList = new ArrayList<>();
      List<Integer> yList = new ArrayList<>();

    for(int i = 0; i < n; i++) {
        String[] arr2 = br.readLine().split(" ");
        int price = Integer.parseInt(arr2[0]);
        int kind = Integer.parseInt(arr2[1]);
	      if (kind == 0) xList.add(price);
        else yList.add(price);
      }

		// 가격이 적은 것부터 해야 최대한 많이 충전함
		Collections.sort(xList);
		Collections.sort(yList);

		// c 같이 안 하는 이유 : x 따로 y 따로 하면 가격이 낮은 순서 겹칠 수 있다.
		// 나중에 c에서 사용
		List<Integer> remain = new ArrayList<>(); 
		for(int xPrice : xList) {
			if(a > 0) {
				totalN++;
				totalPrice += xPrice;
				a--;
			} else {
				remain.add(xPrice);
			}
		}

		for(int yPrice : yList) {
			if(b > 0) {
				totalN++;
				totalPrice += yPrice;
				b--;
			} else {
				remain.add(yPrice);
			}
		}

		Collections.sort(remain);
		 for (int price : remain) {
            if (c > 0) {
                totalN++;
                totalPrice += price;
                c--;
            } 
        }

		
		
		System.out.println(totalN+ " " +totalPrice);
	}
}