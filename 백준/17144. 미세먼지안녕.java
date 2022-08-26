package coding_test.Algo20220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int R, C, T, airMachineX;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		airMachineX = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && airMachineX == 0)	airMachineX = i;
			}
		}
		
		startMachine();
		printFineDustCnt();
	}
	
	private static void printFineDustCnt() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
			
		}
		// 공기청정기가 -1 * 2 이므로 +2
		System.out.println(sum + 2);
	}
	private static void startMachine() {
		while(T-->0) {
			startSpread();	// 미세먼지 확산
			startMachineUp();	// 위의 공기청정기 작동
			startMachineDown();	// 아래의 공기청정기 작동
		}
	}
	
	private static void startSpread() {
		int[][] adder = new int[R][C];
		// 확산 시작.
		// 주변으로 확산되는 값은 adder에 저장. 줄어든 먼지는 그대로 map에 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] >= 5) {	// 확산되는 양이 (x/5) 이므로 5이상만 확산하도록
					int spreadedDust = map[i][j] / 5;
					for(int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)	continue;
						adder[nx][ny] += spreadedDust;
						map[i][j] -= spreadedDust;
					}
				}
			}
			
		}
		// adder에 저장된 주변으로 확산된 값을 더한다.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += adder[i][j];
			}
			
		}
	}
	
	private static void startMachineUp() {
		int x =airMachineX, y = 1;
		int before = 0, now = 0;
		while (true) {	// 바람이 오른쪽으로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(y + 1 == C)	break;
			y++;
		}
		x--;	// 다음 좌표의 위치로 이동
		while (true) {	// 바람이 위로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(x - 1 == -1)	break;
			x--;
		}
		y--;	// 다음 좌표의 위치로 이동
		while (true) {	// 바람이 왼쪽으로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(y - 1 == -1)	break;
			y--;
		}
		x++;	// 다음 좌표의 위치로 이동
		while (true) {	// 바람이 아래로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(map[x+1][y] == -1)	break;
			x++;
		}
	}
	
	private static void startMachineDown() {
		int x =airMachineX + 1, y = 1;
		int before = 0, now = 0;
		while (true) {	// 바람이 오른쪽으로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(y + 1 == C)	break;
			y++;
		}
		x++;	// 다음 좌표의 위치로 이동
		while (true) {	// 바람이 아래로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(x + 1 == R)	break;
			x++;
		}
		y--;	// 다음 좌표의 위치로 이동
		while (true) {	// 바람이 왼쪽으로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(y - 1 == -1)	break;
			y--;
		}
		x--;	// 다음 좌표의 위치로 이동
		while (true) {	// 바람이 위로 이동
			now = map[x][y];
			map[x][y] = before;
			before = now;
			if(map[x-1][y] == -1)	break;
			x--;
		}
	}

}
