package coding_test.Algo20220911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 임의의 두 점 사이의 거리 중 가장 긴 것.
 * 임의의 두 점 : 연결된 간선이 한개 인 것.
 * 왜 ? 2개 이상이라면 경유지가 되므로 종착지가 되기 어려움.
 *
 * 이는 잘못된 생각이었다.
 * 트리의 지름을 구하는 공식이 따로 있다!!
 * 까먹었다면 아래의 블로그를 참고하자!
 * https://blog.myungwoo.kr/112
 *
 * 블로그 내용을 짧게 요약하면 아래와 같다.
 * 1. 트리에서 임의의 정점 x를 잡는다.
 * 2. 정점 x에서 가장 먼 정점 y를 잡는다.
 * 3. 정점 y에서 가장 먼 정점 z를 찾는다.
 * 트리의 지름 : y - z 까지의 거리
 */

public class BOJ_1167_트리의지름 {
    static int V, diameter, yVal, yIdx;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];

        for(int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        int cnt = 0;
        while (cnt++ < V){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1)  break;
                int cost = Integer.parseInt(st.nextToken());
                graph[current].add(new Edge(next, cost));
            }
        }


        // 트리에서 임의의 정점 x를 잡는다. => 나는 1로 해야지
        // 정점 x에서 가장 먼 정점 y를 찾는다.
        boolean[] visited = new boolean[V+1];
        visited[1] = true;
        findVertex(1, 0, visited);

        // 정점 y에서 가장 먼 정점 z를 찾는다.
        Arrays.fill(visited, false);
        visited[yIdx] = true;
        findDiameter(yIdx, 0, visited);

        System.out.println(diameter);
    }

    private static void findVertex(int cur, int cost, boolean[] visited) {
        if(yVal < cost){
            yVal = cost;
            yIdx = cur;
        }
        for(Edge edge : graph[cur]){
            if(visited[edge.next])  continue;
            visited[edge.next] = true;
            findVertex(edge.next, cost + edge.cost, visited);
        }
    }

    private static void findDiameter(int cur, int cost, boolean[] visited) {
        boolean flag = false;
        for(Edge edge : graph[cur]){
            if(visited[edge.next])  continue;
            flag = true;
            visited[edge.next] = true;
            findDiameter(edge.next, cost + edge.cost, visited);
        }
        if(!flag)   if(cost > diameter) diameter = cost;
    }


    static class Edge {
        int next, cost;

        public Edge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
