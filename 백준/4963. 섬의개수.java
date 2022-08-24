package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int w, h, islandCnt;
	static String[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 || h == 0)	break;
			map = new String[h][];
			for(int i = 0; i < h; i++) {
				map[i] = br.readLine().split(" ");
			}
			
			visited = new boolean[h][w];
			islandCnt = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j].equals("0") || visited[i][j])	continue;
					BFS(i, j);
					islandCnt++;
				}
			}
			System.out.println(islandCnt);
		}
	}
	private static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[x][y] = true;
		queue.add(new  int[] {x,y});
		while (!queue.isEmpty()) {
			int[] deleted = queue.poll();
			for(int d = 0; d < 8; d++) {
				int nx = deleted[0] + dx[d];
				int ny = deleted[1] + dy[d];
				if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny].equals("0") || visited[nx][ny])	continue;
				queue.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
}
