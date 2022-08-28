package coding_test.Algo20220828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M_4 {
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        perm(0, new int[M]);
        System.out.println(sb);
    }

    private static void perm(int depth, int[] output) {
        if(depth == M){
            print(output);
            return;
        }
        for(int i = 1; i <= N; i++){
            output[depth] = i;
            if(depth == 0 || (depth > 0 && output[depth-1] <= output[depth])) perm(depth+1, output);
        }
    }

    private static void print(int[] output) {
        for(int i = 0; i < M; i++){
            sb.append(output[i]);
            if(i != M-1)    sb.append(" ");
        }
        sb.append("\n");
    }
}
