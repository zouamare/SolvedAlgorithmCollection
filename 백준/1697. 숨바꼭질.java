package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());		//수빈이 위치
		int k = Integer.parseInt(st.nextToken());		//동생 위치
		answer = Integer.MAX_VALUE;
		
		dfs(n, k, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int n, int k, int count) {		//수빈이위치, 동생위치, 카운트
		if( n >= k ) {
			count += n - k;
			if( answer > count ) {
				answer = count;
			}
			return;
		}
		
		dfs(n, n, count + k - n);
		if( n == 0 ) {
			n = 1;
			count++;
		}
		
		if( k % 2 == 1 ) {
			dfs(n, k + 1, count + 1);
			dfs(n, k - 1, count + 1);
		}		
		else {
			dfs(n, k / 2, count + 1);
		}
	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		boolean[] visited = new boolean[100_001];
//		ArrayDeque<Case> q = new ArrayDeque<>();
//		q.add(new Case(0, N));
//		visited[N] = true;
//		while(!q.isEmpty()) {
//			Case c = q.poll();
//			if(c.loc == K) {
//				System.out.println(c.sec);
//				break;
//			}
//			if(2*c.loc <= 100000 && !visited[2*c.loc]) {
//				q.add(new Case(c.sec+1, 2*c.loc));
//				visited[2*c.loc] = true;
//			}
//			if(c.loc+1 <= 100000 && !visited[c.loc+1]) {
//				q.add(new Case(c.sec+1, c.loc+1));
//				visited[c.loc+1] = true;
//			}
//			if(c.loc-1 >= 0 && !visited[c.loc-1]) {
//				q.add(new Case(c.sec+1, c.loc-1));
//				visited[c.loc-1] = true;
//			}
//		}
//	}
//	
//	static class Case{
//		int sec;
//		int loc;
//		
//		public Case(int sec, int loc) {
//			this.sec = sec;
//			this.loc = loc;
//		}
//	}
}
