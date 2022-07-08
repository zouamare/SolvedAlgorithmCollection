import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[][] matrix = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i < edge.length; i++){
            matrix[edge[i][0]][edge[i][1]] = true;
            matrix[edge[i][1]][edge[i][0]] = true;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        visited[1] = true;
        int max = 0;
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] deleted = queue.poll();
            for(int i = 0; i < matrix.length; i++){
                if(matrix[deleted[0]][i] && !visited[i]){
                    queue.add(new int[]{i,deleted[1]+1});
                    visited[i] = true;
                }
            }
            if(deleted[1] > max){
                max = deleted[1];
                cnt = 1;
            }
            else if(deleted[1] == max)
                cnt++;
        }
        return cnt;
    }
}