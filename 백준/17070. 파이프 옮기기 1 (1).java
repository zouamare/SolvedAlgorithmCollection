package coding_test.Algo20220827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀를 이용한 방법
public class BOJ_17070_파이프옮기기1_1 {
    static int N, wayCnt;
    static char[][] map;    // 이번엔 char 타입으로 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N+1][N+1];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        movePipe(1,2,0);
        System.out.println(wayCnt);
    }

    private static void movePipe(int x, int y, int dir) {
        // x와 y는 파이프의 우측 하단의 좌표를 의미
        // (x,y)가 (N,N)일 때 종료
        // dir 0 : 가로, 1: 세로, 2: 대각선
        if(x == N && y == N){
            wayCnt++;
            return;
        }
        switch (dir){
            case 0:
                if(isValid(x,y+1))  movePipe(x, y+1, 0);
                if(isValid(x+1,y) && isValid(x, y+1) && isValid(x+1, y+1))  movePipe(x+1, y+1, 2);
                break;
            case 1:
                if(isValid(x+1,y))  movePipe(x+1, y, 1);
                if(isValid(x+1,y) && isValid(x, y+1) && isValid(x+1, y+1))  movePipe(x+1, y+1, 2);
                break;
            case 2:
                if(isValid(x,y+1))  movePipe(x, y+1, 0);
                if(isValid(x+1,y))  movePipe(x+1, y, 1);
                if(isValid(x+1,y) && isValid(x, y+1) && isValid(x+1, y+1))  movePipe(x+1, y+1, 2);
                break;
        }
    }

    private static boolean isValid(int x, int y){
        return x > 0 && x <= N && y > 0 && y <= N && map[x][y] != '1';
    }
}
