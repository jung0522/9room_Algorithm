import java.util.*;
import java.io.*;

// 하노이의 탑 스택 구조

public class Main {
    static int n = 20;          // 원반 개수
    static int k;              // k번째 이동 후 상태
    static int moveCount = 0;  // 이동 횟수 카운트

    // 각 막대에 쌓인 원반 상태를 Stack으로 관리
    static List<Stack<Integer>> rods = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); 
				k = Integer.parseInt(input);

        for (int i = 0; i < 3; i++) {
            rods.add(new Stack<>());
        }

        // 처음 0번 막대에 20개의 원반 (가장 큰 20부터 1까지)
        for (int i = n; i >= 1; i--) {
            rods.get(0).push(i);
        }

        hanoi(n, 0, 1, 2);

				
        System.out.println(
            sumStack(rods.get(0)) + " " +
						sumStack(rods.get(1)) + " " +
						sumStack(rods.get(2))
        );
    }

    // n개의 원반을 start -> end 로 옮길 때 mid는 보조 막대
	    static void hanoi(int n, int start, int mid, int end) {
         if (moveCount >= k) return;

		    if (n == 1) {
	        moveCount++;
	        if (moveCount > k) return;
	        int disk = rods.get(start).pop();
	        rods.get(end).push(disk);
	        return;
			  }

        hanoi(n - 1, start, end, mid); 
				if (moveCount == k) return;
        moveCount++; // 이동 +1
				// 첫 번쩨 스택(막대기) 맨 위 제거 마지막 스택 맨 위 추가
        int disk = rods.get(start).pop();
        rods.get(end).push(disk);
     
        hanoi(n - 1, mid, start, end); 


    }

    // 스택 안 원반 크기 합 계산
    static int sumStack(Stack<Integer> rods) {
        int sum = 0;
        for (int disk : rods) {
            sum += disk;
        }
        return sum;
    }

	// private static void hanoi(int n, int start, int mid, int end) {
 //    if (n == 1) {
 //        System.out.println(start + " to " + end);
 //        return;
 //    }
 //    hanoi(n - 1, start, end, mid);  // 1단계: start → mid (end는 보조)
 //    System.out.println(start + " to " + end); // 2단계: start → end
 //    hanoi(n - 1, mid, start, end);  // 3단계: mid → end (start는 보조)
	// }

}
