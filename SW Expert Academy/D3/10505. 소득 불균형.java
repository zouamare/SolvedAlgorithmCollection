import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;  test_case <= T; test_case++){
            br.readLine();  // N 처리
            String[] input = br.readLine().split(" ");
            int ave = (int) Arrays.stream(input).mapToInt(Integer::parseInt).average().getAsDouble();
            System.out.println("#" + test_case + " " + Arrays.stream(input).mapToInt(Integer::parseInt).filter(e -> ave >= e).count());
        }
    }
}