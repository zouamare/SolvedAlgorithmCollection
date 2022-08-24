package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int cnt = 0, redGreenCnt = 0;
	
		boolean[][] check = new boolean[N][N];
		boolean[][] checkRG = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!check[i][j]) {
					BFS(i,j, check);
					cnt++;
				}
				if(!checkRG[i][j]) {
					redGreenBFS(i,j, checkRG);
					redGreenCnt++;
				}
			}
		}
		
		System.out.println(cnt+" "+redGreenCnt);
	}
	private static void redGreenBFS(int x, int y, boolean[][] check) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		char color = map[x][y];
		check[x][y] = true;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny])	continue;
				if((color == 'R' || color == 'G') && map[nx][ny]=='B') continue;
				if(color == 'B' && map[nx][ny] != color) continue;
				check[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			}
		}
	}
	private static void BFS(int x, int y, boolean[][] check) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		char color = map[x][y];
		check[x][y] = true;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != color || check[nx][ny])	continue;
				check[nx][ny] = true;
				queue.add(new int[] {nx, ny});
			}
		}
	}
}
