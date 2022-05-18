import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            System.out.println("#"+test_case);
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int trans_90_x = N-1;
            int trans_90_y = 0;

            int trans_180_x = N-1;
            int trans_180_y = N-1;

            int trans_240_x = 0;
            int trans_240_y = N-1;
            for(int i = 0; i<N; i++){
                String s = "";
                for(int j = 0; j<N; j++){
                    s+= arr[trans_90_x-j][trans_90_y];
                }
                s += " ";
                for(int j = 0; j<N; j++){
                    s+= arr[trans_180_x][trans_180_y-j];
                }
                s += " ";
                for(int j = 0; j<N; j++){
                    s+= arr[trans_240_x+j][trans_240_y];
                }
                System.out.println(s);
                trans_90_y += 1;
                trans_180_x -= 1;
                trans_240_y -= 1;
            }
        }
    }
}