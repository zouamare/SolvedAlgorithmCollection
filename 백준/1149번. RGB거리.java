import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 다음의 규칙을 만족해야 한다.
        // 1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        // 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다. (연속하여 같은 색 X)
        // 3. i (2 <= i <= N - 1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
        // => 결론: 연속하여 같은 색이 나올 수 없을 때의 가장 최솟값을 구하여라.
        int[][] RGB = new int[N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            RGB[i][0] = Integer.parseInt(st.nextToken());
            RGB[i][1] = Integer.parseInt(st.nextToken());
            RGB[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] DP = new int[N][3];
        DP[0] = RGB[0];
        for(int i = 1; i<N; i++){
            for(int j = 0; j < 3; j++){
                switch (j){
                    case 0:
                        DP[i][j] = Math.min(DP[i - 1][1] + RGB[i][j], DP[i-1][2] + RGB[i][j]);
                        break;
                    case 1:
                        DP[i][j] = Math.min(DP[i - 1][0] + RGB[i][j], DP[i-1][2] + RGB[i][j]);
                        break;
                    case 2:
                        DP[i][j] = Math.min(DP[i - 1][0] + RGB[i][j], DP[i-1][1] + RGB[i][j]);
                        break;
                }
            }
        }
        System.out.println(Arrays.stream(DP[N-1]).min().getAsInt());
    }
    /*
    // 시간 초과
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 다음의 규칙을 만족해야 한다.
        // 1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        // 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다. (연속하여 같은 색 X)
        // 3. i (2 <= i <= N - 1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
        // => 결론: 연속하여 같은 색이 나올 수 없을 때의 가장 최솟값을 구하여라.
        int[][] RGB = new int[N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            RGB[i][0] = Integer.parseInt(st.nextToken());
            RGB[i][1] = Integer.parseInt(st.nextToken());
            RGB[i][2] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        DFS(RGB, -1,0,N,0);

        System.out.println(min);
    }

    private static void DFS(int[][] rgb, int before, int depth, int len, int sum) {
        if(depth == len){
            min = Math.min(min, sum);
            return;
        }
        for(int i = 0; i < 3; i++){
            if(depth!= 0 && i == before)
                continue;
            DFS(rgb,i,depth+1,len,sum+rgb[depth][i]);
        }
    }
     */
}