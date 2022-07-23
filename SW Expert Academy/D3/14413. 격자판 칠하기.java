import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    static boolean isPossible;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;  test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            String[][] matrix = new String[N][];
            boolean[][] visited = new boolean[N][M];
            isPossible = true;

            for(int i = 0; i < N; i++)
                matrix[i] = br.readLine().split("");

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(isPossible && !visited[i][j] && !matrix[i][j].equals("?"))
                        BFS(i,j,matrix,visited);
                }
            }

            System.out.println("#" + test_case + " " + (isPossible ? "possible" : "impossible"));
        }
    }

    private static void BFS(int x, int y, String[][] matrix, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int i = 0; i < dx.length; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if(isNotVaild(nx,ny) || visited[nx][ny])   continue;
                switch (matrix[point[0]][point[1]]){
                    case "#":   // black
                        if(matrix[nx][ny].equals("?"))  // possible
                            matrix[nx][ny] = ".";
                        else if(matrix[nx][ny].equals("#")) // impossible
                            isPossible = false;
                        break;
                    case ".":   // white
                        if(matrix[nx][ny].equals("?"))  // possible
                            matrix[nx][ny] = "#";
                        else if(matrix[nx][ny].equals(".")) // impossible
                            isPossible = false;
                        break;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny});
            }
        }
    }

    private static boolean isNotVaild(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}