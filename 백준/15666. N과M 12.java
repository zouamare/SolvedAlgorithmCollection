package coding_test.Algo20220828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15652_N과M_12 {
    static int N, M;
    static int[] data;
    static StringBuilder sb;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        set = new HashSet<>();
        for(int i = 0; i < N; i++)  data[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(data);
        sb = new StringBuilder();
        perm(0, new int[M]);
        System.out.println(sb);
    }

    private static void perm(int depth, int[] output) {
        if(depth == M){
            if(set.add(Arrays.toString(output)))    print(output);
            return;
        }
        for(int i = 0; i < N; i++){
            output[depth] = data[i];
            if(depth == 0 || output[depth-1] <= output[depth]) perm(depth+1, output);
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
