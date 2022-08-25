package coding_test.Algo20220825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램 {
    static int N, M;
    static int[] d;
    static ArrayList<Integer>[] musician;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        d = new int[N+1];
        musician = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) musician[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int before = 0;
            for(int j = 0; j < cnt; j++){
                int num = Integer.parseInt(st.nextToken());
                if(before != 0){
                    musician[before].add(num);
                    d[num]++;
                }
                before = num;
            }
        }

        topologySort();
    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(d[i] == 0){
                q.offer(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()){
            int tmp = q.poll();
            cnt++;
            sb.append(tmp).append("\n");

            for(int idx : musician[tmp]){
                if(--d[idx] == 0)  q.offer(idx);
            }
        }
        if(cnt != N) System.out.println(0);
        else System.out.println(sb);
    }
}
