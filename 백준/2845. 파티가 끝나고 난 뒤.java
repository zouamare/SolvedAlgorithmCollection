package coding_test.Algo2022년_11월.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2845_파티가끝나고난뒤 {
    private final static int MAX_SIZE = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < MAX_SIZE; i++) {
            if(i != 0) ans.append(" ");
            ans.append(Integer.parseInt(st.nextToken()) - size);
        }

        System.out.println(ans);
    }
}
