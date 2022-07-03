import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i <= N - M; i++){
                for(int j = 0; j <= N - M; j++){
                    int sum = 0;
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            sum += matrix[i+a][j+b];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}
