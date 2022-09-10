package coding_test.Algo20220910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 비의 높이는 최소값부터 탐색하며 최대 카운트는 1로 시작한다.
* 그 이유는 아래의 예시와 같다.
*  2 2 2
*  2 2 2
*  2 2 2
* 지도가 위와 같다면, 2일때의 정답은 0이 된다.
* max도 2이므로 바로 계산이 종료되게 되는데, 정답은 1이 나와야 한다.
* 따라서 이와 같이 풀이했다.
* */
public class BOJ_2468_안전영역 {
    static int N, min, max;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] < min) min = map[i][j];
                if(map[i][j] > max) max = map[i][j];
            }
        }

        int maxCnt = 1;
        for(int water = min; water <= max; water++){
            int cnt = 0;
            boolean[][] visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i][j] || map[i][j] <= water)  continue;
                    DFS(i, j, water, visited);
                    cnt++;
                }
            }
            if(maxCnt < cnt)    maxCnt = cnt;
        }

        System.out.println(maxCnt);
    }

    private static void DFS(int x, int y, int water, boolean[][] visited) {
        visited[x][y] = true;
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(!isValid(nx, ny) || visited[nx][ny] || map[nx][ny] <= water)  continue;
            visited[nx][ny] = true;
            DFS(nx, ny, water, visited);
        }
    }
    private static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
