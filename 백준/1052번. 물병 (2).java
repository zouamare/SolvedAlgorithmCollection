import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
//        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        br.close();

        int cnt = 0;
        int n = N;
        while(true){
            int oneCnt = 0;
            while(n > 1) {
                if(n % 2 == 1)
                    oneCnt++;
                n = n / 2;
            }
            if(oneCnt <= K - 1)
                break;
            cnt++;
            n = N + cnt;
        }
        System.out.println(cnt);
    }
}