import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static int N;
    static int M;
    static int[] snack;
    static int maxWeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }
            // 과자 봉지 무게 합 최대로
            maxWeight = -1;
            boolean[] visited = new boolean[N];
            maxSnackWeight(visited, N, 0, 2, M);
            System.out.println("#"+t+" "+maxWeight);
        }
    }

    private static void maxSnackWeight(boolean[] visited, int n, int start, int r, int weight) {
        if(r == 0){
            maxWeight = Math.max(maxWeight, M - weight);
            return;
        }
        for(int i = start; i < n; i++){
            if(visited[i])  continue;
            if(weight - snack[i] < 0)   continue;
            visited[i] = true;
            maxSnackWeight(visited, n, i+1, r-1, weight - snack[i]);
            visited[i] = false;
        }
    }
}