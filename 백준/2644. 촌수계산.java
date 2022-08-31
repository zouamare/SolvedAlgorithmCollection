package coding_test.Algo20220831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[N+1][N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = true;
            graph[to][from] = true;
        }

        boolean[] visited = new boolean[N+1];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()){
            int[] t = queue.poll();

            if(t[0] == end){
                System.out.println(t[1]);
                return;
            }

            for(int i = 1; i <= N; i++){
                if(!visited[i] && graph[t[0]][i]){
                    visited[i] = true;
                    queue.add(new int[]{i, t[1] + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
