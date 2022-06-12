import javax.swing.text.html.ListView;
import java.util.*;

public class Main {
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int M = sc.nextInt();   // row
            int N = sc.nextInt();   // col
            int K = sc.nextInt();   // cabbage
            boolean[][] matrix = new boolean[M][N];
            boolean[][] visited = new boolean[M][N];
            for(int j = 0; j<K; j++){
                matrix[sc.nextInt()][sc.nextInt()] = true;
            }
            int cnt = 0;
            for(int j = 0; j<M; j++){
                for(int k = 0; k<N; k++){
                    if(DFS(j,k,matrix,visited,M,N))
                        cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    private static boolean DFS(int x, int y, boolean[][] matrix, boolean[][] visited, int M, int N) {
        if(visited[x][y] || !matrix[x][y])
            return false;
        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isNotValid(nx,ny,M,N))
                continue;
            if(!visited[nx][ny] && matrix[nx][ny]){
                DFS(nx,ny,matrix,visited,M,N);
            }
        }
        return true;
    }

    private static boolean isNotValid(int nx, int ny, int m, int n) {
        return nx < 0 || nx >= m || ny < 0 || ny >= n;
    }
}