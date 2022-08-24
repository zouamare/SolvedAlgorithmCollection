package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M, minDis;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 벽을 부수고 이동하기 0,0 -> N-1, M-1 까지
		// 벽 부수는건 순차대로 진행하기로..!
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		minDis = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		BFS();
		
		System.out.println((minDis==Integer.MAX_VALUE?-1:minDis));
	}
	private static void BFS() {
		if(0 == N-1 && 0 == M-1) {
			minDis = Math.min(minDis, 1);
			return;
		}
		boolean[][] visited = new boolean[N][M];
		boolean[][] visitedBroken = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1, 0});	// x, y, cnt, sum
		visited[0][0] = true;
		visitedBroken[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M ||tmp[3] + map[nx][ny] >= 2)	continue;
				if(tmp[3] == 1 && visitedBroken[nx][ny])	continue;
				else if(tmp[3] == 0 && visited[nx][ny])	continue;
				if(nx == N-1 && ny == M-1) {
					minDis = Math.min(minDis, tmp[2] + 1);
					return;
				}
				queue.add(new int[] {nx, ny,tmp[2] + 1, tmp[3] + map[nx][ny]});
				if(tmp[3] == 0) visited[nx][ny] = true;
				else	visitedBroken[nx][ny] = true;
			}
		}
	}
	
}


//package day0824;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BOJ_2206_벽부수고이동하기 {
//	static int N, M, minDis;
//	static char[][] map;
//	static int[] dx = {-1, 1, 0, 0};
//	static int[] dy = {0, 0, -1, 1};
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		// 벽을 부수고 이동하기 0,0 -> N-1, M-1 까지
//		// 벽 부수는건 순차대로 진행하기로..!
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		map = new char[N][M];
//		minDis = Integer.MAX_VALUE;
//		Queue<int[]> queue = new LinkedList<int[]>();
//		for(int i = 0; i < N; i++) {
//			String s = br.readLine();
//			for(int j = 0; j < M; j++) {
//				map[i][j] = s.charAt(j);
//				if(map[i][j] == '1')	queue.add(new int[] {i, j});
//			}
//		}
//		
//		while(!queue.isEmpty()) {
//			int[] tmp = queue.poll();
//			// 벽 잠깐 뿌시기
//			map[tmp[0]][tmp[1]] = '0';
//			
//			// BFS 시작!
//			BFS();
//			
//			// 벽 다시 만들기
//			map[tmp[0]][tmp[1]] = '1';
//		}
//		
//		System.out.println((minDis==Integer.MAX_VALUE?-1:minDis));
//	}
//	private static void BFS() {
//		boolean[][] visited = new boolean[N][M];
//		Queue<int[]> queue = new LinkedList<>();
//		queue.add(new int[] {0,0,1});
//		visited[0][0] = true;
//		
//		while(!queue.isEmpty()) {
//			int[] tmp = queue.poll();
//			if(tmp[2] > minDis)	return;
//			for(int d = 0; d < 4; d++) {
//				int nx = tmp[0] + dx[d];
//				int ny = tmp[1] + dy[d];
//				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == '1')	continue;
//				if(nx == N-1 && ny == M-1) {
//					minDis = Math.min(minDis, tmp[2] + 1);
//					return;
//				}
//				queue.add(new int[] {nx, ny,tmp[2] + 1});
//				visited[nx][ny] = true;
//			}
//		}
//	}
//}
