package coding_test.Algo20220910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 이 문제를 풀때 주의할 점.
* 벨만포드 알고리즘은 가중치가 INF 일 때도 계속 계산을 해야 하므로,
* Integer.MAX_VALUE로 최대값을 지정해주면 안됨. => overflow가 발생하기 때문에.
* 따라서 거리의 최대 값은 MAX_VALUE는 아니지만 일반 값보다는 월등히 큰 숫자를 넣어줘야 한다.
*
* */

public class BOJ_1865_웜홀 {
    static Edge[] edges;
    static int V, PE, NE;
    private static final int INF = 500 * 10_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st  = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            PE = Integer.parseInt(st.nextToken());   // 가중치가 양수. positive edge
            NE = Integer.parseInt(st.nextToken());  // 가중치가 음수. negative edge
            edges = new Edge[(PE * 2)+NE];
            int idx = 0;
            for(int i = 0; i < PE; i++){    // 도로 저장
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges[idx++] = new Edge(start, end, cost);
                edges[idx++] = new Edge(end, start, cost);
            }

            for(int i = 0; i < NE; i++){    // 웜홀 저장
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges[idx++] = new Edge(start, end, -cost);
            }

            if(bellmanFord())   sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bellmanFord() {
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i = 1; i <= V; i++){
            for(Edge edge : edges){
                if(dist[edge.end] > dist[edge.start] + edge.cost){
                    dist[edge.end] = dist[edge.start] + edge.cost;
                    if(i == V) return true;
                }
            }
        }

        return false;
    }

    static class Edge{
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
