package coding_test.Algo2022년_11월.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
    public static void main(String[] args) throws IOException {
        // count 변수 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int count = 0, sum = 0;
            for (int i = 0, size = input.length(); i < size; i++) {
                if(input.charAt(i) == 'O') sum += ++count;
                else count = 0;
            }
            ans.append(sum).append("\n");
        }
        System.out.println(ans);
    }
}
