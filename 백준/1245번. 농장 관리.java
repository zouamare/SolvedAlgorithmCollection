import java.util.*;

public class Main {
    static int[] dx = new int[]{-1,-1,-1,0,0,1,1,1};
    static int[] dy = new int[]{-1,0,1,-1,1,-1,0,1};
    static int N;
    static int M;
    static boolean isPeak;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] mountains = new int[N][M];
        int peak_num = 0;
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i<N; i++)
            for(int j = 0; j<M; j++)
                mountains[i][j] = sc.nextInt();

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                isPeak = true;
                findPeak(i,j,mountains,visited);
                if(isPeak) {
                    peak_num++;
                }
            }
        }
        System.out.println(peak_num);
    }

    private static void findPeak(int x, int y, int[][] mountains, boolean[][] visited) {
        if(visited[x][y] || mountains[x][y]==0) {
            isPeak = false;
            return;
        }
        visited[x][y] = true;
        for(int i = 0; i<dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isVaild(nx,ny))
                continue;
            if(mountains[nx][ny]>mountains[x][y]){
                isPeak = false;
                visited[x][y] = false;
                return;
            }
            if(mountains[nx][ny]==mountains[x][y] && !visited[nx][ny]){
                findPeak(nx,ny,mountains,visited);
            }
        }
    }

    private static boolean isVaild(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}