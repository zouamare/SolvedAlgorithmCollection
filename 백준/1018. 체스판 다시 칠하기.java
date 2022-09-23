package coding_test.Algo20220923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int row, col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        char[][] startWhite = new char[row][];
        char[][] startBlack = new char[row][];

        for(int r = 0; r < row; r++){
            String s = br.readLine();
            startWhite[r] = s.toCharArray();
            startBlack[r] = s.toCharArray();
        }

        System.out.println(Math.min(BFS(startWhite, 'W', new boolean[row][col]), BFS(startBlack, 'B', new boolean[row][col])));
    }

    private static int BFS(char[][] map, char x, boolean[][] visited) {
        int[][] counts = new int[row][col];
        Queue<Cell> queue = new ArrayDeque<>();
        if(map[0][0] != x){
            map[0][0] = x;
            counts[0][0]++;
        }
        queue.add(new Cell(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Cell cell = queue.poll();
            for(int d = 0; d < 4; d++){
                int nr = cell.r + dr[d];
                int nc = cell.c + dc[d];
                if(isValid(nr, nc) && !visited[nr][nc]){
                    char tmp = getRival(map[cell.r][cell.c]);
                    if(map[nr][nc] != tmp){
                        map[nr][nc] = tmp;
                        counts[nr][nc]++;
                    }
                    visited[nr][nc] = true;
                    queue.add(new Cell(nr, nc));
                }
            }
        }

        int minCnt = Integer.MAX_VALUE;
        for(int r = 0; r <= row - 8; r++){
            for(int c = 0; c <= col - 8; c++){
                int cnt = 0;
                for(int i = r; i < r + 8; i++){
                    for(int j = c; j < c + 8; j++){
                        cnt += counts[i][j];
                    }
                }
                minCnt = Math.min(minCnt, cnt);
            }
        }


        return minCnt;
    }

    private static char getRival(char val){
        if(val == 'W')  return 'B';
        return 'W';
    }

    private static boolean isValid(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    static class Cell{
        int r, c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}
