package coding_test.Algo20220929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 풀이 참고 https://fbtmdwhd33.tistory.com/73
public class BOJ_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];
            dp[1] = 1;
            if(N == 1){
                sb.append(dp[N]).append("\n");
                continue;
            }
            dp[2] = 2;
            if(N == 2){
                sb.append(dp[N]).append("\n");
                continue;
            }
            dp[3] = 4;
            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
