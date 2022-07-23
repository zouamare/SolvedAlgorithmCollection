import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int test_case = 1;  test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            String[][] matrix = new String[N][];
            for(int i = 0; i < N; i++){
                matrix[i] = br.readLine().split("");
            }

            boolean isCorrect = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!isCorrect && matrix[i][j].equals("o")) {
                        for(int k = 0; k < dx.length; k++){
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            int cnt = 1;
                            while(!isNotValid(nx, ny) && !matrix[nx][ny].equals(".")){
                                nx = nx + dx[k];
                                ny = ny + dy[k];
                                cnt++;
                            }
                            if (cnt == 5) {
                                isCorrect = true;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+(isCorrect?"YES":"NO"));
        }
    }

    private static boolean isNotValid(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= N;
    }
}