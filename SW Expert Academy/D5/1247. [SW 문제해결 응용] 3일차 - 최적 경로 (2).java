package day0819;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	static int N;
	static Point[] route;
	static int minRoute;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			route = new Point[N+2];
			route[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			route[N+1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i = 1; i <= N; i++) {
				route[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			minRoute = Integer.MAX_VALUE;
			int[] output = new int[N+2];
			boolean[] visited = new boolean[N+2];
			output[0] = 0;
			output[N+1] = N+1;
			visited[N+1] = visited[0] = true;
			perm(output,visited,1,0);
			System.out.println("#"+t+" "+minRoute);
		}
	}
	
	private static void perm(int[] output, boolean[] visited, int depth, int distance) {
		if(depth == N+1) {
			// 모든 순열을 다 구함
			Point before = route[output[depth-1]];
			Point now = route[output[depth]];
			minRoute = Math.min(minRoute, distance + Math.abs(before.x - now.x) + Math.abs(before.y - now.y));
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(visited[i])	continue;
			visited[i] = true;
			output[depth] = i;
			Point before = route[output[depth-1]];
			Point now = route[output[depth]];
			perm(output, visited, depth+1, distance + Math.abs(before.x - now.x) + Math.abs(before.y - now.y));
			visited[i] = false;
		}
	}

	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}