package coding_test.Algo2022년_11월.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1246_온라인판매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cost = 0, income = 0;

        for (int i = M - 1; i >= 0; i--) {
            int num = M - i;
            if(M - i > N) num = N;
            if(num * arr[i] > income){
                income = num * arr[i];
                cost = arr[i];
            }
        }

        System.out.println(cost+" "+income);
    }
}
