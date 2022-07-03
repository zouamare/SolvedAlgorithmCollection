import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String[][] matrix = new String[N][];
            for(int i = 0; i < N; i++){
                matrix[i] = br.readLine().split(" ");
            }
            int cnt = 0;
            for(int i = 0; i < N; i++){ //  가로 찾기
                int len = 0;
                for(int j = 0; j < N; j++){
                    if(matrix[i][j].equals("1")){
                        len++;
                    }else{
                        if(len > 0 && len == K)
                            cnt++;
                        len = 0;
                    }
                }
                if(len > 0 && len == K)
                    cnt++;
            }
            for(int i = 0; i < N; i++){ // 세로 찾기
                int len = 0;
                for(int j = 0; j < N; j++){
                    if(matrix[j][i].equals("1")){
                        len++;
                    }else{
                        if(len > 0 && len == K)
                            cnt++;
                        len = 0;
                    }
                }
                if(len > 0 && len == K)
                    cnt++;
            }
            System.out.println("#"+test_case+" "+cnt);
        }
    }
}