import java.io.*;
import java.util.*;

public class Main {

	static final int MAXN = 100000;
	static long[] x = new long[MAXN];
	static long[] y = new long[MAXN];
	static long[] start = new long[MAXN];
	static long[] arrive = new long[MAXN];

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 외계인 좌표, 미사일 시작 시간 입력
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			x[i] = Long.parseLong(line[0]);
			y[i] = Long.parseLong(line[1]);
			start[i] = Long.parseLong(line[2]);
		}

		// 각 미사일의 도착 시각 계산
		for (int i = 0; i < n; i++) {
			arrive[i] = start[i] + dist(x[i], y[i]);
		}

		/* 미사일의 시작 시각과 도착 시각을 구간으로 나타내고
		   힙을 사용해 가장 많이 겹치는 구간을 찾음 */
		/* 일반 정렬이 아닌, 우선 순위를 명백하게 정의해야함.*/
		// PriorityQueue<Long> → 가능 (Long은 Comparable)
		// PriorityQueue<long[]> → 불가능 (배열은 Comparable이 아님)
		// → Comparator 지정 필요
		PriorityQueue<long []> pq = new PriorityQueue<>(
			(a, b) -> {
				if(a[0] != b[0]) {
				return Long.compare(a[0], b[0]); // 여러 배열들 중 배열의 첫 번째 요소로 순서 오름 차순 정렬
				} else {
				return Long.compare(a[1], b[1]); // 첫 번째 요소 다를 경우 두 번째 요소로 오름 차순 정렬
				}                              // (b[1], a[1]) 내림차순 정렬
			} 
		);

		// 시작 시간(start[i])과 도착 시간(arrive[i])을 우선순위 큐에 넣기
		for (int i = 0; i < n; i++) {
			pq.add(new long[]{start[i], 1}); // 시작 시각은 1로 표시
			pq.add(new long[]{arrive[i], 0}); // 도착 시각은 0으로 표시
			// {[1,3], [2,4], ...}
		}

		int count = 0;
		int res = 0;

		// 힙에서 시작 시각과 도착 시각을 처리
		while (!pq.isEmpty()) {
			long[] current = pq.poll();
			long t = current[0];
			int kind = (int) current[1];
	
			if (kind == 1) { 
				++count; // 시작했으니까 +1
			} else { // 도착 했으므로 -1
				--count;
			}
			res = Math.max(res, count); // 현재 활성화 중인 미사일 개수 중 최대값
		}

		// 총 시간에서 겹치는 구간의 개수를 빼줌
		// 겹칠 때 속도 1되므로 -1씩
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += arrive[i] - start[i];
		}
		ans -= res;

		// 결과 출력
		System.out.print(ans);
	}
	// 유클리드 거리의 제곱의 두 배를 계산
	static long dist(long x, long y) {
		return (x * x + y * y) * 2;
	}
}