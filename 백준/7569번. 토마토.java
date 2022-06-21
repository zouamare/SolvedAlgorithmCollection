import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        String[][][] tomato_box = new String[Integer.valueOf(NM[1])][Integer.valueOf(NM[0])][Integer.valueOf(NM[2])];
        for(int i = 0; i < Integer.valueOf(NM[2]); i++){    // z
            for(int j = 0; j < Integer.valueOf(NM[1]); j++){    //  x
                String[] line = br.readLine().split(" ");
                for(int k = 0; k < Integer.valueOf(NM[0]); k++){    // y
                    tomato_box[j][k][i] = line[k];
                }
            }
        }

        // 1을 찾는다.
        // 1로부터 계속 반복하여 끝까지 채운다.
        // 만약 0이 있다면, -1 반환 (채울 수 없음)
        // 만약 0이 없다면, 숫자 반환

        ArrayList<int[]> point = find_point(tomato_box);
        if(point.size()==0)    // 박스 내에 익은 토마토가 없다면,
            System.out.println(-1); // 토마토는 익을 수 없다.
        else{   // 박스 내에 익은 토마토가 있다면,
            make_delicious_tomatoes(tomato_box,point);
            if(is_there_no_unripe_tomatoes(tomato_box))
                System.out.println(find_days(tomato_box));  // 토마토가 모두 익었으므로, 소요 일수를 출력한다.
            else
                System.out.println(-1); // 익을 수 없는 토마토가 존재한다.
        }
    }

    private static int find_days(String[][][] tomato_box) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < tomato_box.length; i++){
            for(int j = 0; j < tomato_box[0].length; j++){
                for(int k = 0; k < tomato_box[0][0].length; k++){
                    if(Integer.valueOf(tomato_box[i][j][k]) > max){
                        max = Integer.valueOf(tomato_box[i][j][k]);
                    }
                }
            }
        }
        return max -1;  // 초기상태까지 포함이므로 -1을 해준다.
    }

    private static boolean is_there_no_unripe_tomatoes(String[][][] tomato_box) {
        for(int i = 0; i < tomato_box.length; i++){
            for(int j = 0; j < tomato_box[0].length; j++){
                for(int k = 0; k < tomato_box[0][0].length; k++){
                    if(tomato_box[i][j][k].equals("0")){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static ArrayList<int[]> find_point(String[][][] tomato_box) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < tomato_box.length; i++){
            for(int j = 0; j < tomato_box[0].length; j++){
                for(int k = 0; k < tomato_box[0][0].length; k++){
                    if(tomato_box[i][j][k].equals("1")){
                        list.add(new int[]{i,j,k});
                    }
                }
            }
        }
        return list;
    }

    private static void make_delicious_tomatoes(String[][][] tomato_box, ArrayList<int[]> point){
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < point.size(); i++)
            q.add(point.get(i));

        while(!q.isEmpty()){
            int[] removed = q.remove();
            for(int i = 0; i<dx.length; i++){
                int nx = removed[0] + dx[i];
                int ny = removed[1] + dy[i];
                int nz = removed[2] + dz[i];
                if(nx < 0 || nx >= tomato_box.length || ny < 0 || ny >= tomato_box[0].length || nz < 0 || nz >= tomato_box[0][0].length)
                    continue;
                if(tomato_box[nx][ny][nz].equals("0")){
                    q.add(new int[]{nx,ny,nz});
                    tomato_box[nx][ny][nz] = Integer.toString(Integer.valueOf(tomato_box[removed[0]][removed[1]][removed[2]]) + 1);
                }
            }
        }
    }
}