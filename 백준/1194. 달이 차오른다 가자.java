package day20221005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
	static int N, M, minCnt;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		int x = -1, y = -1;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					x = i;
					y = j;
				}
			}
		}

		minCnt = Integer.MAX_VALUE;
		BFS(x, y);
		System.out.println((minCnt == Integer.MAX_VALUE ? -1 : minCnt));
	}

	private static void BFS(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][64];
		queue.offer(new Point(x, y, 0));
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if (map[p.x][p.y] == '1') {
				if (minCnt > p.depth)
					minCnt = p.depth;
				return;
			}
			
			if (isKey(map[p.x][p.y]) && ((p.keyCnt & 1<<((int)(map[p.x][p.y] - 'a'))) == 0)) { // key이면서 아직 획득하지 못했을 때
				p.keyCnt = p.keyCnt | 1 << ((int)(map[p.x][p.y] - 'a'));
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (!isValid(nx, ny) || map[nx][ny] == '#' || ((isDoor(map[nx][ny]) && (p.keyCnt & 1 << (map[nx][ny] - 'A')) == 0)) || visited[nx][ny][p.keyCnt])	continue;
				Point newP = new Point(nx, ny, p.depth + 1, p.keyCnt);
				visited[nx][ny][p.keyCnt] = true;
				queue.offer(newP);
			}
		}
	}

	private static boolean isValid(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	private static boolean isKey(char ch) {
		return Character.isLowerCase(ch);
	}

	private static boolean isDoor(char ch) {
		return Character.isUpperCase(ch);
	}
	
	static class Point{
		int x, y, depth, keyCnt;
		
		public Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			keyCnt = 0;
		}
		
		public Point(int x, int y, int depth, int keyCnt) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.keyCnt = keyCnt;
		}
	}
}
