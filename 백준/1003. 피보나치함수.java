package coding_test.Algo2022년_10월.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 메모이제이션
        int[][] dp = new int[41][2];

        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int j = 2; j <= 40; j++) {
            dp[j][0] = dp[j-1][0] + dp[j-2][0];
            dp[j][1] = dp[j-1][1] + dp[j-2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}
