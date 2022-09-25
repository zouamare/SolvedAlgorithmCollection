package coding_test.Algo20220925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0 && C == 0)  break;
            int max = Math.max(A, Math.max(B, C));
            boolean flag = false;
            if(A == max){
                if(Math.pow(A,2) == Math.pow(B,2) + Math.pow(C, 2)) flag = true;

            }
            else if(B == max){
                if(Math.pow(B,2) == Math.pow(A,2) + Math.pow(C, 2)) flag = true;

            }
            else{
                if(Math.pow(C,2) == Math.pow(A,2) + Math.pow(B, 2)) flag = true;
            }
            if(flag)    sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }

        System.out.println(sb);
    }
}
