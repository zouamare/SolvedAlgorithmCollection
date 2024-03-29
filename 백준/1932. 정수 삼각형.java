package coding_test.Algo2022년_10월.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블로그 https://st-lab.tistory.com/131 참고
public class BOJ_1932_정수삼각형 {
    static int[][] arr;
    static Integer[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 마지막 행의 값들을 DP의 마지막 행에도 똑같이 복사
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(find(0, 0));
    }

    private static int find(int depth, int idx) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        if(depth == N - 1)  return dp[depth][idx];

        // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
        if(dp[depth][idx] == null){
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}
