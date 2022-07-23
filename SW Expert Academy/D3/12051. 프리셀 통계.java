import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;  test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long todaysMaxGameCnt = Long.parseLong(st.nextToken()); // 단위 확인을 잘하자..
            int todaysWinPercent = Integer.parseInt(st.nextToken());
            int totalWinPercent = Integer.parseInt(st.nextToken());
            boolean isPossible;
            if((todaysWinPercent > 0 && totalWinPercent == 0)||(todaysWinPercent < 100 && totalWinPercent == 100))
                isPossible = false;
            else{
                isPossible = false;
                for(int i = 1; i <= todaysMaxGameCnt; i++){
                    if(((i * todaysWinPercent) / (double) 100) == ((i * todaysWinPercent) / 100)) {
                        isPossible = true;
                        break;
                    }
                }
            }

            System.out.println("#" + test_case + " " + (isPossible ? "Possible" : "Broken"));
        }
    }
}