package coding_test.Algo20220825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄_세우기 {
    static int N, M;
    static int[] d;
    static ArrayList<Integer>[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        d = new int[N+1];   // 학생 수는 1 ~ N
        height = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) height[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            height[A].add(B);
            d[B]++;
        }

        TopologySort();
    }

    private static void TopologySort() {
        boolean[] visited = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(!visited[i] && d[i] == 0){
                visited[i] = false;
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int idx = q.poll();

            sb.append(idx).append(" ");

            for(int i : height[idx]){
                if(!visited[i] && --d[i] == 0)    q.offer(i);
            }
        }

        System.out.println(sb.toString().trim());
    }
}
