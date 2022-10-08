package coding_test.Algo2022년_10월.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
    static final int MAX_VALUE = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시의 개수
        int M = Integer.parseInt(br.readLine());    // 버스의 개수

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], MAX_VALUE);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            if (graph[from][to] > cost) graph[from][to] = cost;
        }

        for (int i = 0; i < N; i++) {   // 경유지
            for (int j = 0; j < N; j++) {   // 출발지
                if(i == j)  continue;
                for (int k = 0; k < N; k++) {   // 도착지
                    if(i == k || j == k)    continue;
                    if(graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j != 0)  sb.append(" ");
                if(graph[i][j] == MAX_VALUE) graph[i][j] = 0;
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
