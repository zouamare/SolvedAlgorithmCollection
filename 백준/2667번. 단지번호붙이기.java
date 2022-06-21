import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static ArrayList<Integer> number_of_house = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        String[][] matrix = new String[N][];
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N; i++)
            matrix[i] = br.readLine().split("");

        int num_house = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(find_house(i,j,matrix,visited))
                    num_house++;
            }
        }

        Collections.sort(number_of_house);

        System.out.println(num_house);  // 단지의 수 출력
        for(int i = 0; i < number_of_house.size(); i++){
            System.out.println(number_of_house.get(i)); // 단지 내 집 개수 출력
        }
    }

    private static boolean find_house(int x, int y, String[][] matrix, boolean[][] visited) {
        if(visited[x][y] || Integer.valueOf(matrix[x][y]) == 0)
            return false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] removed = q.remove();
            cnt++;
            for(int i = 0; i < dx.length; i++){
                int nx = removed[0] + dx[i];
                int ny = removed[1] + dy[i];
                if(nx<0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(Integer.valueOf(matrix[nx][ny]) > 0 && !visited[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        number_of_house.add(cnt);
        return true;
    }
}