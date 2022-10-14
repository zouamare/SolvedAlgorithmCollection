package coding_test.Algo2022년_10월.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        System.out.println(bf(A, B));
    }

    private static int bf(String A, String B) { // brute-force
        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= B.length() - A.length(); j++) {
            int cnt = 0;
            for (int i = 0; i < A.length(); i++) {  // A가 B보다 같거나 짧으므로 A 기준으로 탐색
                if(A.charAt(i) != B.charAt(i + j)) cnt++;
            }
            min = Math.min(min, cnt);
        }
        return min;
    }
}
