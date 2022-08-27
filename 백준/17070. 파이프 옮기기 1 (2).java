package coding_test.Algo20220827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp를 이용한 방법
// 백준 skdlzlabc님 코드 참고
public class BOJ_17070_파이프옮기기1_2 {
    static int N;
    static int[][] map;    // 이번엔 char 타입으로 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N+2; i++) {
            map[i][N+1]=1;
            map[0][i]=1;
            map[i][0]=1;
            map[N+1][i]=1;
        }
        movePipe();
    }

    private static void movePipe() {
        int[][][] dp = new int[N+2][N+2][3];
        dp[1][2][0] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                // 우
                if(dp[i][j-1][0] > 0 && map[i][j] == 0)   dp[i][j][0] += dp[i][j-1][0];
                if(dp[i-1][j-1][0] > 0 && map[i][j] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0)   dp[i][j][2] += dp[i-1][j-1][0];

                // 하
                if(dp[i-1][j][1] > 0 && map[i][j] == 0)   dp[i][j][1] += dp[i-1][j][1];
                if(dp[i-1][j-1][1] > 0 && map[i][j] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0)   dp[i][j][2] += dp[i-1][j-1][1];

                // 우하
                if(dp[i][j-1][2] > 0 && map[i][j] == 0)   dp[i][j][0] += dp[i][j-1][2];
                if(dp[i-1][j][2] > 0 && map[i][j] == 0)   dp[i][j][1] += dp[i-1][j][2];
                if(dp[i-1][j-1][2] > 0 && map[i][j] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0)   dp[i][j][2] += dp[i-1][j-1][2];
            }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}
