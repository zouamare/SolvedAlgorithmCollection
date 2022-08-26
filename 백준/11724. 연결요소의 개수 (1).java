package coding_test.Algo20220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// 방법 1. BFS를 이용한 방법
public class BOJ_11724_연결요소의개수 {
	static int V, E;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V+1];
		visited = new boolean[V+1];
		for(int i = 1; i <= V; i++)	graph[i] = new ArrayList<>();	
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);	// 무방향 그래프 이므로 from - to
			graph[to].add(from);	// 무방향 그래프 이므로 to - from
		}
		
		int cnt = 0;
		
		for(int i = 1; i <= V; i++) {
			if(visited[i])	continue;
			BFS(i);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	private static void BFS(int i) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			for(int next : graph[idx]) {
				if(visited[next])	continue;
				queue.add(next);
				visited[next] = true;
			}
		}
	}
	
}
