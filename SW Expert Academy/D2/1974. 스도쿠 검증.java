import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int[][] matrix = new int[9][9];
            for(int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            int[] row = new int[9];
            boolean isRight = true;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    row[matrix[i][j]-1]++;
                }
                if(Arrays.stream(row).distinct().count() != 1){
                    isRight = false;
                    break;
                }
            }
            int[] col = new int[9];
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    col[matrix[j][i]-1]++;
                }
                if(Arrays.stream(col).distinct().count() != 1){
                    isRight = false;
                    break;
                }
            }
            int[] box = new int[9];
            for(int i = 0; i < 9; i+=3){
                for(int j = 0; j < 9; j+=3){
                    box[matrix[i][j]-1]++;
                    box[matrix[i+1][j]-1]++;
                    box[matrix[i+2][j]-1]++;
                    box[matrix[i][j+1]-1]++;
                    box[matrix[i][j+2]-1]++;
                    box[matrix[i+1][j+1]-1]++;
                    box[matrix[i+1][j+2]-1]++;
                    box[matrix[i+2][j+1]-1]++;
                    box[matrix[i+2][j+2]-1]++;
                    if(Arrays.stream(box).distinct().count() != 1){
                        isRight = false;
                        break;
                    }
                }
                if (!isRight)
                    break;
            }
            if(isRight)
                System.out.println("#"+test_case+" 1");
            else
                System.out.println("#"+test_case+" 0");
        }
    }
}
