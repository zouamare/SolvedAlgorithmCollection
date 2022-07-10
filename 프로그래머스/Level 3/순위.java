import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] arr = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++){
            arr[results[i][0]][results[i][1]] = 1;
            arr[results[i][1]][results[i][0]] = -1;
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(arr[k][i] == 1 && arr[i][j] == 1){
                        arr[k][j] = 1;
                        arr[j][k] = -1;
                    }
                    if(arr[k][i] == -1 && arr[i][j] == -1){
                        arr[j][k] = 1;
                        arr[k][j] = -1;
                    }
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(Arrays.stream(arr[i]).filter(x -> x == 0).count() == 2)
                cnt++;
        }
        return cnt;
    }
}