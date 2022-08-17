package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static int N;
	static String[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][];
		for(int i = 0; i < N; i++){
			map[i] = br.readLine().split("");
		}
		sb = new StringBuilder();
		
		QuadTree(0,0,N-1,N-1);
		
		System.out.println(sb);
	}
	private static void QuadTree(int x1, int y1, int x2, int y2) {
		if(allMatched(x1,y1,x2,y2)) {
			sb.append(map[x1][y1]);
			return;
		}
		sb.append("(");
		int xMid = x1 + (x2 - x1)/2;
		int yMid = y1 + (y2 - y1)/2;
		QuadTree(x1, y1, xMid, yMid);
		QuadTree(x1, yMid+1, xMid, y2);
		QuadTree(xMid+1, y1, x2, yMid);
		QuadTree(xMid+1, yMid+1, x2, y2);
		sb.append(")");
	}
	private static boolean allMatched(int x1, int y1, int x2, int y2) {
		String val = map[x1][y1];
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				if(!map[i][j].equals(val))
					return false;
			}
		}
		return true;
	}
}
