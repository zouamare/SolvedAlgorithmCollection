package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R;
	static int C;
	static char[][] map;
	static int[] dx = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		/*
		 * 문제에 대한 개념을 잘 잡았어야 한다.
		 * 위에서 실패했을 경우 다른 단계에서도 무조건적으로 실패하게 되므로 다시 고려할 필요가 없다는 것을 유념했어야 함.
		 * 이를 모르면 경우의 수가 너무나 늘어난다.
		 * 문제를 정확히 파악해야 함. '이렇지 않을까..' 라는 추상적인 생각은 문제풀이를 오히려 더 어렵게 하는 요소이다.
		 * 앞으로는 문제를 정확히 파악하는 습관을 들이자.
		 * 문제 유형, 시간 복잡도를 꼭 따져야 함 
		 * 
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int cnt = 0;
		for(int i = 0; i < R; i++) {
			if(fetchToMyBakery(i, 0))	++cnt;
		}
		System.out.println(cnt);
	}
	private static boolean fetchToMyBakery(int x, int y) {
		map[x][y] = 'x';
		if(y == C - 1)	return true;
		for(int d = 0, ny = y + 1; d < 3; d++) {
			int nx = x + dx[d];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny]!='.')	continue;
			if(fetchToMyBakery(nx, ny))	return true;
		}
		return false;
	}
}
