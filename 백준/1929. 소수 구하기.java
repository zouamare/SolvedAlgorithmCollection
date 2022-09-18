package coding_test.Algo20220918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[end + 1];
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= end; i++){
            if(prime[i])    continue;

            if(i >= start)   sb.append(i).append("\n");

            for(int j = i + i; j <= end; j+=i){
                prime[j] = true;
            }
        }
        System.out.println(sb);
    }
}
