import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            String input = br.readLine();
            int cnt = 0;
            if(input.charAt(0) == '1')
                cnt++;
            for(int i = 1; i < input.length(); i++) {
                if(input.charAt(i-1) != input.charAt(i))
                    cnt++;
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}
