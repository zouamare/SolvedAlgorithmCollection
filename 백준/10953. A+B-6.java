package coding_test.Algo2022년_11월.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10953_AB6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] AB = br.readLine().split(",");
            ans.append(Integer.parseInt(AB[0]) + Integer.parseInt(AB[1])).append("\n");
        }
        System.out.println(ans);
    }
}
