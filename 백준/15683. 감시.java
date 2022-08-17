package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<CCTV> cctv;
	static int cctvCnt;
	static int totalZero;
	static int minZeroCnt = Integer.MAX_VALUE;
	static int[] dir = {0, 4, 2, 4, 4, 1};
	static boolean[][] visited;
	static int deletedZeroCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					cctv.add(new CCTV(i,j,map[i][j]));
				}else if(map[i][j] == 0){
					totalZero++;
				}
			}
		}
		
		cctvCnt = cctv.size();
		playCCTV(0, new int[cctvCnt]);
		System.out.println(minZeroCnt);
		
	}
	
	private static void lookRight(CCTV cctv) {
		int x = cctv.x;
		int y = cctv.y;
		visited[x][y] = true;
		while(y < M && map[x][y] != 6) {
			if(map[x][y] == 0 && !visited[x][y]) {
				visited[x][y] = true;
				deletedZeroCnt++;
			}
			y++;
		}
	}

	private static void lookUp(CCTV cctv) {
		int x = cctv.x;
		int y = cctv.y;
		visited[x][y] = true;
		while(0 <= x && map[x][y] != 6) {
			if(map[x][y] == 0 && !visited[x][y]) {
				visited[x][y] = true;
				deletedZeroCnt++;
			}
			x--;
		}
		
	}

	private static void lookLeft(CCTV cctv) {
		int x = cctv.x;
		int y = cctv.y;
		visited[x][y] = true;
		while(0 <= y && map[x][y] != 6) {
			if(map[x][y] == 0 && !visited[x][y]) {
				visited[x][y] = true;
				deletedZeroCnt++;
			}
			y--;
		}
	}

	private static void lookDown(CCTV cctv) {
		int x = cctv.x;
		int y = cctv.y;
		visited[x][y] = true;
		while(x < N && map[x][y] != 6) {
			if(map[x][y] == 0 && !visited[x][y]) {
				visited[x][y] = true;
				deletedZeroCnt++;
			}
			x++;
		}
	}

	private static void playCCTV(int index, int[] arr) {
		if(index == cctvCnt) {
			runCCTVs(arr);
			return;
		}
		for(int i = 0; i < dir[cctv.get(index).type]; i++) {
			arr[index] = i;
			playCCTV(index+1, arr);
		}
	}
	
	


	private static void runCCTVs(int[] arr) {
		// TODO Auto-generated method stub
		
		visited = new boolean[N][M];
		deletedZeroCnt = 0;
		for(int i = 0; i < cctvCnt; i++) {
			switch (cctv.get(i).type) {
			case 1:
				CCTV1(arr[i], cctv.get(i));
				break;
			case 2:
				CCTV2(arr[i], cctv.get(i));
				break;
			case 3:
				CCTV3(arr[i], cctv.get(i));
				break;
			case 4:
				CCTV4(arr[i], cctv.get(i));
				break;
			case 5:
				CCTV5(arr[i], cctv.get(i));
				break;
			}
		}
		
		minZeroCnt = Math.min(minZeroCnt, totalZero - deletedZeroCnt);
		
	}




	private static void CCTV1(int dir, CCTV cctv) {
		switch(dir) {
			case 0:
				lookRight(cctv);
				break;
			case 1:
				lookUp(cctv);
				break;
			case 2:
				lookLeft(cctv);
				break;
			case 3:
				lookDown(cctv);
				break;
		}
	}

	private static void CCTV2(int dir, CCTV cctv) {
		switch(dir) {
		case 0:
			lookLeft(cctv);
			lookRight(cctv);
			break;
		case 1:
			lookUp(cctv);
			lookDown(cctv);
			break;
		}
	}

	private static void CCTV3(int dir, CCTV cctv) {
		switch(dir) {
		case 0:
			lookRight(cctv);
			lookUp(cctv);
			break;
		case 1:
			lookUp(cctv);
			lookLeft(cctv);
			break;
		case 2:
			lookLeft(cctv);
			lookDown(cctv);
			break;
		case 3:
			lookDown(cctv);
			lookRight(cctv);
			break;
		}	
	}

	private static void CCTV4(int dir, CCTV cctv) {
		switch(dir) {
		case 0:
			lookRight(cctv);
			lookUp(cctv);
			lookLeft(cctv);
			break;
		case 1:
			lookUp(cctv);
			lookLeft(cctv);
			lookDown(cctv);
			break;
		case 2:
			lookLeft(cctv);
			lookDown(cctv);
			lookRight(cctv);
			break;
		case 3:
			lookDown(cctv);
			lookRight(cctv);
			lookUp(cctv);
			break;
		}
	}

	private static void CCTV5(int dir, CCTV cctv) {
		// TODO Auto-generated method stub
		lookLeft(cctv);
		lookDown(cctv);
		lookRight(cctv);
		lookUp(cctv);
	}




	static class CCTV{
		int x;
		int y;
		int type;
		
		public CCTV(int x, int y, int type) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
}
