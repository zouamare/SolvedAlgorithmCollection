package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {
	static int R, C;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		/*
		 * 본 문제는 초기에 DFS로 풀려고 시도했으나, 메모리 초과가 발생했다.
		 * 그 이유는 방문처리를 까먹고 안해서 그랬던 것 같다.
		 * 그리고 BFS로 물 처리를 하는 방법이 생각이 안나서 DFS로 구현했던 것인데, 
		 * 거리가 적을 수록 빨리 빠지는 것을 이용하여 거리가 변경되면 물을 늘리는 방법을 사용하면 됐었다.
		 * 최소 거리인 경우는 BFS를 통해 구하는 것이 편하므로 최소 거리일 때는 최대한 BFS로 접근해야 겠다.
		 * 
		 * 따라서, BFS를 사용할 때 특정 trigger를 찾는 방법을 꾸준히 연습해야겠다.
		 * 
		 * 그리고 visited 꼭 빼먹지 말기!
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int gx = 0, gy = 0;
		int[][] check = new int[R][C];	// 물의 상태를 표시할 2차원 배열
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					gx = i;	// 고슴도치의 x 좌표
					gy = j;	// 고슴도치의 y 좌표
					map[i][j] = '.';
				}else if(map[i][j] == '*') {
					check[i][j] = 2;	// 물이 시작되는 곳
				}
			}
		}
		BFS(gx, gy, check);
		System.out.println("KAKTUS");
	}
	private static void waterCheck(int[][] check) {	// 곧 물이 퍼질 곳을 1로 체크
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(check[i][j] == 2) {
					for(int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny]!='.' || check[nx][ny] != 0)	continue;
						check[nx][ny] = 1;
					}
				}
			}
		}
	}
	
	private static void waterStart(int[][] check) {	// 곧 물이 퍼질 곳인 1을 물이 퍼졌다는 뜻인 2로 변경
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(check[i][j] == 1)	check[i][j] = 2;
			}
		}
	}
	
	private static void BFS(int x, int y, int[][] check) {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y, 0});
		visited[x][y] = true;
		// 물 퍼지기
		int before = 0;
		waterCheck(check);
		while (!queue.isEmpty()) {
			int[] deleted = queue.poll();
			if(deleted[2] != before) {	// 이동 거리가 늘어난다면,
				before = deleted[2];
				waterStart(check);
				waterCheck(check);
			}
			for(int d = 0; d < 4; d++) {
				int nx = deleted[0] + dx[d];
				int ny = deleted[1] + dy[d];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny]=='X' || check[nx][ny] != 0 || visited[nx][ny])	continue;
				if(map[nx][ny] == 'D') {	// 도착지에 도착한다면,
					System.out.println(deleted[2] + 1);
					System.exit(0);
				}
				queue.add(new int[] {nx, ny, deleted[2] + 1});
				visited[nx][ny] = true;
			}
		}
	}
}
