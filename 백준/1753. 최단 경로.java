package coding_test.Algo20220825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1753_최단_경로 {
    static class Vertex{
        int no, weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }
    static int V, E, K;
    static ArrayList<Vertex>[] map;
    static int[] minDist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        map = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) map[i] = new ArrayList<>();
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())].add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        minDist = new int[V+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        Dijkstra();

        for (int i = 1; i <= V; i++) {
            System.out.println((minDist[i]==Integer.MAX_VALUE?"INF":minDist[i]));
        }
    }

    private static void Dijkstra() {
        minDist[K] = 0;
        boolean[] visited = new boolean[V+1];

        int minIdx, minVal;
        for(int i = 1; i <= V; i++){
            minVal = Integer.MAX_VALUE;
            minIdx = -1;
            for (int j = 1; j <= V; j++) {
                if(!visited[j] && minDist[j] < minVal){
                    minVal = minDist[j];
                    minIdx = j;
                }
            }

            if(minIdx == -1)    continue;
            visited[minIdx] = true;

            for(Vertex v : map[minIdx]){
                if(!visited[v.no] && minDist[v.no] > minDist[minIdx] + v.weight){
                    minDist[v.no] =  minDist[minIdx] + v.weight;
                }
            }
        }
    }
}
