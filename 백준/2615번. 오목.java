import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX_SIZE = 19;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[MAX_SIZE + 2][MAX_SIZE + 2];
        StringTokenizer st;
        for(int i = 1; i <= MAX_SIZE; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= MAX_SIZE; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {1,0,1,-1};
        int[] dy = {0,1,1,1};
        for(int i = 1; i <= MAX_SIZE; i++){
            for(int j = 1; j <= MAX_SIZE; j++){
                int curVal = map[i][j];
                if(curVal != 0){
                    for(int k = 0; k < dx.length; k++){
                        int cnt = 1;
                        if(map[i + (dx[k] * -1)][j + (dy[k] * -1)] == curVal) continue;
                        while(curVal == map[i + (dx[k] * cnt)][j + (dy[k] * cnt)])  cnt++;
                        if(cnt == 5){
                            System.out.println(map[i][j]);
                            System.out.println(i+" "+j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("0");
    }
}

