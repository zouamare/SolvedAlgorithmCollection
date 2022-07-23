import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;  test_case <= T; test_case++){
            StringBuilder sb = new StringBuilder(br.readLine());
            int a = 1;
            int b = 1;
            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i)=='L'){  // Left
                    b += a;
                }else{  // Right
                    a += b;
                }
            }
            System.out.println("#"+test_case+" "+a+" "+b);
        }
    }
}