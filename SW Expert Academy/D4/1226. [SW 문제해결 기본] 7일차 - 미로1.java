import java.awt.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sc.nextInt();
            String[][] matrix = new String[16][16];
            int result = 0;
            for(int i = 0; i < 16; i++){
                matrix[i] = sc.next().split("");
            }
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,-1,1};
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[16][16];
            queue.add(new int[]{1,1});
            visited[1][1] = true;
            while(!queue.isEmpty()){
                int[] deleted = queue.poll();
                if(matrix[deleted[0]][deleted[1]].equals("3")){
                    result = 1;
                    break;
                }
                for(int i = 0; i < 4; i++){
                    int nx = deleted[0] + dx[i];
                    int ny = deleted[1] + dy[i];
                    if(isCorrectXY(nx,ny,16) && Integer.parseInt(matrix[nx][ny]) != 1 &&!visited[nx][ny]){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            System.out.println("#"+test_case+" "+result);
        }
    }

    public static boolean isCorrectXY(int x, int y, int N){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}