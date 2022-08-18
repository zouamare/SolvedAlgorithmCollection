package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    static int R;
    static int C;
    static char map[][];
    static int maxCnt = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        for(int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();
        boolean[] visited = new boolean[26];
        visited[map[0][0] - 'A'] = true;
        movePiece(visited,0,0,1);
        System.out.println(maxCnt);
    }

    private static void movePiece(boolean[] visited, int x, int y, int cnt) {
        maxCnt = Math.max(maxCnt, cnt);
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= R || ny < 0 || ny >= C)  continue;
            int now = map[nx][ny] - 'A';
            if(!visited[now]){
                visited[now] = true;
                movePiece(visited, nx, ny, cnt+1);
                visited[now] = false;
            }
        }
    }
}
