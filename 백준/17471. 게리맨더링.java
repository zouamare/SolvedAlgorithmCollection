package coding_test.Algo20220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, totalVal, minDiff;
	static int[] populationArr;	// 선거구마다의 인구수 저장 배열
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		populationArr = new int[N+1];	// 1 ~ N
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			populationArr[i] = Integer.parseInt(st.nextToken());
			totalVal += populationArr[i];
		}
		// graph 채우기
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)	graph[i] = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while(num-->0) {
				int to = Integer.parseInt(st.nextToken());
				graph[i].add(to);
				graph[to].add(i);
			}
		}
		
		minDiff = Integer.MAX_VALUE;
		for(int i = 1; i <= N/2; i++) {
			comb(0, 0, i, new boolean[N+1], new int[i], 0);
		}
		
		System.out.println((minDiff == Integer.MAX_VALUE ? -1 : minDiff));
	}
	private static void comb(int start, int depth, int r, boolean[] visited, int[] output, int sum) {
		if(depth == r) {
			// visited 1 ~ N으로 비교를 한다.
			if(isBothConnected(visited, r))	minDiff = Math.min(minDiff, Math.abs(Math.abs(totalVal - sum) - sum));			
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(visited[i])	continue;
			visited[i] = true;
			output[depth] = i;
			comb(i + 1, depth + 1, r, visited, output, sum + populationArr[i]);
			visited[i] = false;
		}
	}
	private static boolean isBothConnected(boolean[] visited, int cnt) {
		boolean[] newVisited = new boolean[N+1];
		int trueStartIdx = 0, falseStartIdx = 0;
		for(int i = 1; i <= N; i++) {	// 앞에서부터 읽으면서 가장 첫 true값과 첫 false값의 Idx를 각각 저장
			if(trueStartIdx == 0 && visited[i])	trueStartIdx = i;
			else if(falseStartIdx == 0 && !visited[i])	falseStartIdx = i;
			else if(trueStartIdx != 0 && falseStartIdx != 0)	break;
		}
		// true 인 곳이 한 그룹 (개수: cnt)
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(trueStartIdx);
		newVisited[trueStartIdx] = true;
		int trueCnt = 1;
		while(!queue.isEmpty()) {
			int from = queue.poll();
			for(int to : graph[from]) {
				if(!newVisited[to] && visited[to]) {
					queue.add(to);
					newVisited[to] = true;
					trueCnt++;
				}
			}
		}
		if(trueCnt != cnt)	return false;
		// false 인 곳이 한 그룹 (개수: N - cnt)
		queue = new ArrayDeque<Integer>();
		queue.add(falseStartIdx);
		newVisited[falseStartIdx] = true;
		int falseCnt = 1;
		while(!queue.isEmpty()) {
			int from = queue.poll();
			for(int to : graph[from]) {
				if(!newVisited[to] && !visited[to]) {
					queue.add(to);
					newVisited[to] = true;
					falseCnt++;
				}
			}
		}
		if((N - cnt) != falseCnt)	return false;
		return true;
	}
}
