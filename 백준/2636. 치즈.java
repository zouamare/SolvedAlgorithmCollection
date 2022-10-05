package day20221005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 주변에 0이 하나라도 있다면 (단, 동시에 진행되어야 함)
 * 치즈가 녹는다.
 * 
 * */

public class BOJ_2636_치즈 {
	static int R, C, minCnt, time;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0)	cnt++;
			}
		}
		meltCheese(map, 1, cnt);
		
		System.out.println(time);
		System.out.println(minCnt);
	}
	private static void check(int x, int y, int[][] map, boolean[][] visited) {
		map[x][y] = -1;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 1 || visited[nx][ny])	continue;
			visited[nx][ny] = true;
			check(nx, ny, map, visited);
		}
	}
	private static void meltCheese(int[][] map, int depth, int cnt) {
		int prevCnt = cnt;
		boolean[][] visited = new boolean[R][C];
		check(0, 0, map, visited);
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] <= 0)	continue;
				int minusOneCnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] != -1)	continue;
					minusOneCnt++;
				}
				if(minusOneCnt > 0) {
					queue.add(new Point(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			map[p.x][p.y] = -1;
			cnt--;
		}
		
		if(cnt == 0) {
			time = depth;
			minCnt = prevCnt;
			return;
		}
		else {
			meltCheese(map, depth+1, cnt);
		}
	}
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
