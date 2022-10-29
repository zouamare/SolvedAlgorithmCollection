package coding_test.Algo2022년_10월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        // set을 이용한 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < T; n++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder ans = new StringBuilder();
        for (int m = 0; m < T; m++) {
            ans.append((set.contains(Integer.parseInt(st.nextToken()))? 1 : 0)).append("\n");
        }

        System.out.println(ans);
    }
}
