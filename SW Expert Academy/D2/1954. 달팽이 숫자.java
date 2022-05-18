import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int n = 0;
            int x = 0;
            int y = 0;
            int d = 0;
            int[][] arr = new int[N][N];
            while(n<N*N){
                if(0<=x && x<N && 0<=y && y<N && arr[x][y]==0){
                    arr[x][y] = ++n;
                }else{
                    x -= dx[d];
                    y -= dy[d];
                    d = (d+1)%4;
                }
                x += dx[d];
                y += dy[d];
            }
            System.out.println("#"+test_case);
            for(int[] a : arr){
                for(int b= 0; b<a.length; b++){
                    System.out.print(a[b]);
                    if(b!=a.length-1)
                        System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }
}