import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        for(int t = 1; t <= T; t++){
            // 첫 번째 줄: 원본 암호문의 길이 N
            int N = Integer.parseInt(br.readLine());
            // 두 번째 줄: 원본 암호문
            StringBuilder sb = new StringBuilder(br.readLine());
            // 세 번째 줄: 명령어의 개수
            int M = Integer.parseInt(br.readLine());
            // 네 번째 줄: 명령어
            st = new StringTokenizer(br.readLine(),"I");
            for(int i = 0; i < M; i++){
                StringTokenizer st2 = new StringTokenizer(st.nextToken());
                int index = Integer.parseInt(st2.nextToken());
                int cnt = Integer.parseInt(st2.nextToken());
                String s = "";
                for(int j = 0; j < cnt; j++){
                    s += st2.nextToken() + " ";
                }
                sb.insert((7 * index), s);  // sb.insert()를 이용하여 중간에 삽입
            }
            System.out.println("#"+t+" "+sb.substring(0, 70));  // 0 ~ 70번째 인덱스 까지만 출력
        }
    }
}