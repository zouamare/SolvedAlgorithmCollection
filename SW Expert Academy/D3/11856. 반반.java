import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;  test_case <= T; test_case++){
            StringBuilder sb = new StringBuilder(br.readLine());
            boolean isCorrect = true;
            for(int i = 0; i < sb.length(); i++){
                char c = sb.charAt(i);
                if(sb.chars().filter(x -> x == c).count() != 2)
                    isCorrect = false;
            }
            System.out.println("#" + test_case + " " + (isCorrect ? "Yes" : "No"));
        }
    }
}