package coding_test.Algo20220915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
    static int N, diameter;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        if(N == 1){
            System.out.println(0);
            return;
        }
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(next, cost));
            list[next].add(new Node(start, cost));
        }

        BFS(BFS(1));
        System.out.println(diameter);
    }

    private static int BFS(int start) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        queue.add(new Node(start, 0));
        int lastIdx = 0;
        while (!queue.isEmpty()){
            Node node = queue.poll();

            if(node.cost > diameter){
                lastIdx = node.next;
                diameter = node.cost;
            }

            for(Node n : list[node.next]){
                if(visited[n.next]) continue;
                queue.add(new Node(n.next, node.cost + n.cost));
                visited[n.next] = true;
            }
        }
        return lastIdx;
    }

    static class Node{
        int next, cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}
