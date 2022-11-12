package coding_test.Algo2022년_11월.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798_세로읽기 {
    private static final int LIMIT = 5;
    public static void main(String[] args) throws IOException {
        // 중첩 반복문을 이용하여 문제 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[LIMIT];
        int maxLen = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < LIMIT; i++) {
            arr[i] = br.readLine();
            if(arr[i].length() > maxLen)    maxLen = arr[i].length();
        }

        int idx = 0;
        while(idx < maxLen){
            for (int i = 0; i < LIMIT; i++) {
                if(arr[i].length() > idx)
                    ans.append(arr[i].charAt(idx));
            }
            idx++;
        }

        System.out.println(ans);
    }
}
