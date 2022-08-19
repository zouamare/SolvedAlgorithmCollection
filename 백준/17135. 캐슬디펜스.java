package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int totalEnemyCnt;
	static int maxKillCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)	totalEnemyCnt++;
			}
		}
		
		maxKillCount = Integer.MIN_VALUE;
		settingCastleDefense(new int[3], new boolean[M], 0, 0);
		System.out.println(maxKillCount);
	}
	
	private static void settingCastleDefense(int[] archerLoc, boolean[] visited, int start, int cnt) {
		// 조합
		if(cnt == 3) {
			letsStartTheGame(archerLoc);
			return;
		}
		for(int i = start; i < M; i++) {
			if(visited[i])	continue;
			visited[i] = true;
			archerLoc[cnt] = i;
			settingCastleDefense(archerLoc, visited, i+1, cnt+1);
			visited[i] = false;
		}
	}

	private static void letsStartTheGame(int[] archerLoc) {
		int cnt = totalEnemyCnt;
		int killCount = 0;
		int[][] newMap = deepCopy();
		while(cnt > 0) {
			int val = killEnemy(newMap, archerLoc);
			killCount += val;
			cnt -= val + enemyMoving(newMap);
		}
		maxKillCount = Math.max(maxKillCount, killCount);
	}

	private static int killEnemy(int[][] newMap, int[] archerLoc) {
		// 적을 죽인다. 조건은 거리가 D 이하인 적 중에서 가장 가까운 적.
		// 동시에 쏜다.
		int killCount = 0;
		Enemy[] deadEnemy = {new Enemy(Integer.MAX_VALUE, 0, 0), new Enemy(Integer.MAX_VALUE, 0, 0), new Enemy(Integer.MAX_VALUE, 0, 0)};
		for(int i = N - 1; i >= N - D; i--) {
			for(int j = 0; j < M; j++) {
				if(newMap[i][j] == 1) {
					for(int k = 0; k < 3; k++) {
						int dis = Math.abs(archerLoc[k] - j) + Math.abs(N - i);
						if(dis <= D && dis <= deadEnemy[k].distance) {
							if((deadEnemy[k].distance == dis && deadEnemy[k].y > j) || (deadEnemy[k].distance > dis)) {
								deadEnemy[k] = new Enemy(dis, i, j);
							}
						}
					}
				}
			}
		}
		
		if(deadEnemy[0].distance != Integer.MAX_VALUE && newMap[deadEnemy[0].x][deadEnemy[0].y] != 0) {
			newMap[deadEnemy[0].x][deadEnemy[0].y] = 0;
			killCount++;
		}
		if(deadEnemy[1].distance != Integer.MAX_VALUE && newMap[deadEnemy[1].x][deadEnemy[1].y] != 0) {
			newMap[deadEnemy[1].x][deadEnemy[1].y] = 0;
			killCount++;
		}
		if(deadEnemy[2].distance != Integer.MAX_VALUE && newMap[deadEnemy[2].x][deadEnemy[2].y] != 0) {
			newMap[deadEnemy[2].x][deadEnemy[2].y] = 0;
			killCount++;
		}
		return killCount;
	}

	private static int enemyMoving(int[][] newMap) {
		// TODO Auto-generated method stub
		int killCount = 0;
		for(int i = N - 1; i >= 0; i--) {
			for(int j = 0; j < M; j++) {
				if(newMap[i][j] == 1) {
					if(i == N-1) {
						newMap[i][j] = 0;
						killCount++;
					}else {
						newMap[i][j] = 0;
						newMap[i+1][j] = 1;
					}
				}
			}
		}
		return killCount;
	}

	private static int[][] deepCopy() {
		// TODO Auto-generated method stub
		int[][] newMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
	
	static class Enemy{
		int distance;
		int x;
		int y;
		
		public Enemy(int distance, int x, int y) {
			this.distance = distance;
			this.x = x;
			this.y = y;
		}
	}
}
