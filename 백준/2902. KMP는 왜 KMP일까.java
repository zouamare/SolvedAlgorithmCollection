package coding_test.Algo2022년_11월.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2902_KMP는왜KMP일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        StringBuilder ans = new StringBuilder();
        for(String s : arr){
            ans.append(Character.toUpperCase(s.charAt(0)));
        }
        System.out.println(ans);
    }
}
