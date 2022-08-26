package coding_test.Algo20220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// 방법 1. union-find를 이용한 방법
public class BOJ_11724_연결요소의개수2 {
	static int V, E;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		p = new int[V+1];
		for(int i = 1; i <= V; i++)	p[i] = i;
		int cnt = 0;
		int ans = V;
		for(int i = 0; i < E  && cnt < V - 1; i++) {	// [cnt < V - 1] 조건 중요!!
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(union(from, to)) {
				cnt++;
				ans--;	// union으로 연결하면 대표자 외에는 고려안해도 됨!
			}
		}
		System.out.println(ans);	// 남은 ans == 대표자의 갯수
	}
	
	
	static boolean union(int from, int to) {
		from = find(from);
		to = find(to);
		if(from == to)	return false;
		if(from <= to)	p[to] = from;
		else p[from] = to;
		return true;
	}
	
	static int find(int x) {
		if(p[x] == x)	return x;
		return p[x] = find(p[x]);
	}
	
}
