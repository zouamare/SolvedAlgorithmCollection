import java.io.IOException;
import java.util.*;

public class Solution {
    static int N;
    static int Min;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();

            int[][] map = new int[N+2][2];
            boolean[] check = new boolean[N+2];
            int[] result = new int[N+2];

            Min = Integer.MAX_VALUE;

            map[0][0] = sc.nextInt();
            map[0][1] = sc.nextInt();

            map[N+1][0] = sc.nextInt();
            map[N+1][1] = sc.nextInt();

            for(int i = 1; i <= N; i++){
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();
            }

            Perm(1,map,result,check);
            System.out.println("#"+test_case+" "+Min);
        }
    }

    static void Perm(int num, int[][] map, int[] result, boolean[] check){
        if(num == N+1){
            int sum = 0;
            for(int i = 0; i < N+1; i++){
                sum += Math.abs(map[result[i]][0]-map[result[i+1]][0])
                        + Math.abs(map[result[i]][1]-map[result[i+1]][1]);
            }
            if(sum < Min)
                Min = sum;
            return;
        }

        result[0] = 0;
        check[0] = true;

        result[N+1] = N+1;
        check[N+1] = true;

        for(int i = 1; i < N+1; i++){
            if(check[i])
                continue;
            result[num] = i;
            check[i] = true;
            Perm(num+1,map,result,check);
            check[i] = false;
        }
    }
}