package day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int N, M;
	static int[] p;
	
	static int find(int x) {
		if(p[x] == x)	return x;
		return p[x] = find(p[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y)	return false;
		p[y] = x;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			for(int i = 1; i <= N; i++)	p[i] = i;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(a == 0)	union(b, c);
				else {
					if( find(b) == find(c)) sb.append(1);
					else	sb.append(0);
				}
				
			}
			
			
			System.out.println("#"+t+" "+sb);
		}
	}
}
