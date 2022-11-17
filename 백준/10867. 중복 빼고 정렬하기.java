package coding_test.Algo2022년_11월.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10867_중복빼고정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 스트림 이용
        arr = Arrays.stream(arr).distinct().sorted().toArray();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            ans.append(arr[i]).append(" ");
        }
        System.out.println(ans.toString().trim());
    }
}
