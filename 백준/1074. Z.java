package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N;
	static int r;
	static int c;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int len = (int) Math.pow(2, N-1) * 2;
		
		flag = false;
		DC(0, 0, len - 1, len - 1, 0);
	}
	private static void DC(int x1, int y1, int x2, int y2, int sum) {
		if(flag)	System.exit(0);
		if(x1 == x2 && y1 == y2) {
			if(x1 == r && y1 == c) {
				System.out.println(sum);
				flag = true;
			}
			return;
		}
		
		int rMid = x1 + (x2 - x1)/2 ;
		int cMid = y1 + (y2 - y1)/2 ;
		int sumVal = (rMid - x1 + 1) * (cMid - y1 + 1);
		
		if(r >= x1 && r <= rMid && c >= y1 && c <= cMid) {
			DC(x1, y1, rMid, cMid, sum);
		}else if(r >= x1 && r <= rMid && c > cMid && c <= y2) {
			DC(x1, cMid+1, rMid, y2, sum + sumVal);
		}else if(r > rMid && r <= x2 && c >= y1 && c <= cMid) {
			DC(rMid+1, y1, x2, cMid, sum + sumVal * 2);
		}else if(r > rMid && r <= x2 && c > cMid && c <= y2) {
			DC(rMid+1, cMid+1, x2, y2, sum + sumVal * 3);
		}
	}
}
