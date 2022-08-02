import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            br.readLine();
            String[][] map = new String[100][];

            for(int i = 0; i < 100; i++)
                map[i] = br.readLine().split(" ");

            int row = 99;
            int col = 0;
            for(int i = 0; i < 100; i++) {
                if(map[row][i].equals("2")) {
                    col = i;
                    break;
                }
            }

            while(row > 0) {
                if(col-1 >= 0 && col - 1 < 100 && map[row][col-1].equals("1")) {
                    while(col-1 >= 0 && col - 1 < 100 && map[row][col-1].equals("1")) {
                        col--;
                    }
                }
                else if(col+1 >= 0 && col + 1 < 100 && map[row][col+1].equals("1")) {
                    while(col+1 >= 0 && col + 1 < 100 && map[row][col+1].equals("1")) {
                        col++;
                    }
                }
                if(map[row-1][col].equals("1"))
                    row--;
            }

            System.out.println("#"+t+" "+col);
        }
    }
}
