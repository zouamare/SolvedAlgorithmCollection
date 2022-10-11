package coding_test.Algo2022년_10월.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            String s = br.readLine();
            if(t != 0)  sb.append("\n");
            int temp = 0;
            for (int i = 0, size = s.length(); i < size; i++) {
                if(temp < 0)    break;
                if(s.charAt(i) == '(')  temp++;
                else temp--;
            }
            if(temp == 0)   sb.append("YES");
            else sb.append("NO");
        }
        System.out.println(sb);
    }
}
