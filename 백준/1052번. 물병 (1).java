import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int new_bottles_cnt = 0;

        while(true){
            int cnt = 0;
            int num = N;
            while(num != 0){
                if(num%2==1)
                    cnt++;
                num/=2;
            }
           if(cnt <= K)
               break;
           new_bottles_cnt++;
           N++;
        }
        System.out.println(new_bottles_cnt);
    }
}