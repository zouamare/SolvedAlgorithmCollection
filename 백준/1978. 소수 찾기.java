package coding_test.Algo20220902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 에라토스테네스의 체를 이용해서 미리 구해놓기.
        boolean[] prime = new boolean[1001];
        prime[0] = prime[1] = true;
        for(int i = 2; i < Math.sqrt(1001); i++){
            if(prime[i])    continue;
            for(int j = i*i; j <= 1000; j+=i) prime[j] = true;
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(!prime[Integer.parseInt(st.nextToken())])    cnt++;
        }
        System.out.println(cnt);
    }
}
