import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;  test_case <= T; test_case++){
            StringBuilder sb = new StringBuilder(br.readLine());
            sb = sb.reverse();
            String result = "";
            for(int i = 0; i < sb.length(); i++){
                switch (sb.charAt(i)){
                    case 'b':
                        result += 'd';
                        break;
                    case 'd':
                        result += 'b';
                        break;
                    case 'q':
                        result += 'p';
                        break;
                    case 'p':
                        result += 'q';
                        break;
                }
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}