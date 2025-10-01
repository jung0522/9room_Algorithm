import java.io.*;
class Main {
	static int n, q;
	static int tree[];
	static int nums[];
	static int res = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		String arr1[] = input.split(" ");
		n = Integer.parseInt(arr1[0]);
		q = Integer.parseInt(arr1[1]);

		nums = new int[n];
		String input2 = br.readLine();
		String arr2[] = input2.split(" ");
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(arr2[i]);
		}
		tree = new int[n*4];
		build(1, 0, n-1);

		for(int i = 0; i < q; i++) {
			String input3 = br.readLine();
			String arr3[] = input3.split(" ");
			int type = Integer.parseInt(arr3[0]);
			
			if(type == 1) {
				int idx = Integer.parseInt(arr3[1]) - 1;
				int x = Integer.parseInt(arr3[2]);
				nums[idx] += x;
				update(1, 0, n-1, idx, nums[idx]);
			} else if (type == 2) {
				int idx = Integer.parseInt(arr3[1]) - 1;
				res += nums[idx];
				nums[idx] = 0;
				update(1, 0, n-1, idx, nums[idx]);
			} else if (type == 3) {
				int l = Integer.parseInt(arr3[1]) - 1;
        int r = Integer.parseInt(arr3[2]) - 1;
				sb.append(query(1, 0, n-1, l, r)).append("\n");
			}
		}
	sb.append(res);
	System.out.println(sb);
	}
	static void build(int node, int start, int end) {
		if(start == end)
			tree[node] = nums[start];
		else {
			int mid = (start + end) / 2;
			build(node*2, start, mid);
			build(node*2+1, mid+1, end);
			tree[node] = tree[node*2] + tree[node*2+1];
		}
		
	}
	static int query(int node, int start, int end, int l, int r) {
		if(r < start || end < l)
			return 0;
		if(l <= start && end <= r)
			return tree[node]; // query는 tree[node] 반환
		int mid = (start + end) / 2;
		return query(node*2, start, mid, l, r) 
			+ query(node*2+1, mid+1, end, l, r);
	}
	static void update(int node, int start, int end, int idx, int value) {
		if(idx < start || idx > end)
			return;
		if(start == end)
			tree[node] = value; // update는 tree[node]에 value 대입
		else {
			int mid = (start + end) / 2;
			update(node*2, start, mid, idx, value);
			update(node*2+1, mid+1, end, idx, value);
			tree[node] = tree[node*2] + tree[node*2+1];
		}
	}
}