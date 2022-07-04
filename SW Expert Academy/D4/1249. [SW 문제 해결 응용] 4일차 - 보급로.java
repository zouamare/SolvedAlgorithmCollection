import java.awt.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++){
                String s = sc.next();
                for(int j = 0; j < N; j++){
                    matrix[i][j] = Character.getNumericValue(s.charAt(j));
                }
            }
            PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.value - o2.value;
                }
            });
            boolean[][] visited = new boolean[N][N];
            queue.add(new Point(0,0,0));
            visited[0][0] = true;
            while(!queue.isEmpty()){
                Point deleted = queue.poll();
                for(int i = 0; i < 4; i++){
                    int nx = deleted.x + dx[i];
                    int ny = deleted.y + dy[i];
                    if(isCorrectXY(nx,ny,N) && !visited[nx][ny]){
                        matrix[nx][ny] += matrix[deleted.x][deleted.y];
                        visited[nx][ny] = true;
                        queue.add(new Point(nx,ny,matrix[nx][ny]));
                    }
                }
            }
            System.out.println("#"+test_case+" "+matrix[N-1][N-1]);
        }
    }

    static class Point{
        int x;
        int y;
        int value;

        public Point(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static boolean isCorrectXY(int x, int y, int N){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}