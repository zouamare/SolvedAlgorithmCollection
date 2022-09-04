package coding_test.Algo20220904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 문제를 봤을 때, DP라는 생각이 들었다.
* 그 이유는 다양한 경우를 고려해야하는데, 그리디로 풀 수는 없을거 같아 DP로 푸는게 맞다고 생각했다.
*
* 그러나 문제를 풀지 못했다.. 후.. 아직 많이 부족하다.
* */

public class BOJ_9465_스티커 {
    static int N;
    static int[][] sticker, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            sticker = new int[N+2][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) sticker[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) sticker[i][1] = Integer.parseInt(st.nextToken());
            dp = new int[N+1][2];
            dp[1][0] = sticker[1][0];
            dp[1][1] = sticker[1][1];
            for(int i = 2; i <= N; i++){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + sticker[i][0];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + sticker[i][1];
            }
            System.out.println(Math.max(dp[N][0],dp[N][1]));
        }
    }

}
