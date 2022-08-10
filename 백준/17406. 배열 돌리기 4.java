package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
    static int minMatrixCnt;
    static int N;
    static int M;
    static int k;
    static int[][] map;
    static int[][] rcs;
    static int[] dx = {1, 0, -1, 0};	// 하 우 상 좌
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rcs = new int[k][3];
        for(int i = 0; i < k; i ++) {
            st = new StringTokenizer(br.readLine());
            rcs[i][0] = Integer.parseInt(st.nextToken());
            rcs[i][1] = Integer.parseInt(st.nextToken());
            rcs[i][2] = Integer.parseInt(st.nextToken());
        }

        minMatrixCnt = Integer.MAX_VALUE;
        boolean[] visited = new boolean[k];
        perm(new int[k],visited, 0);
        System.out.println(minMatrixCnt);

    }

    private static void perm(int[] output, boolean[] visited, int depth) {
        // TODO Auto-generated method stub
        if(depth == k) {
            // 여기서 배열을 회전하고, 최소값을 구한다.
            minMatrixCnt = Math.min(minMatrixCnt, rotateMatrix(output));
            return;
        }
        for(int i = 0; i < k; i++) {
            if(visited[i])	continue;
            visited[i] = true;
            output[depth] = i;
            perm(output, visited, depth+1);
            visited[i] = false;
        }

    }

    private static int rotateMatrix(int[] output) {
        // TODO Auto-generated method stub
        int[][] newMap = new int[N][M];
        for(int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }
        for(int i = 0; i < k; i++) {
            // output 순서대로 돈다.
            int r = rcs[output[i]][0] - 1;
            int c = rcs[output[i]][1] - 1;
            int s = rcs[output[i]][2];

            for(int j = 0; j < s; j++) {
                int x = r - s + j;
                int y = c - s + j;

                int val = newMap[x][y];

                int idx = 0;
                while(idx < 4) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    if(nx >= r - s + j && ny >= c - s + j && nx <= r + s - j && ny <= c + s - j) {
                        newMap[x][y] = newMap[nx][ny];
                        x = nx;
                        y = ny;
                    }else
                        idx++;
                }
                newMap[j+r-s][j+c-s+1] = val;
            }
        }
        // 합의 최솟값을 구한다.
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < M; j++) {
                sum += newMap[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}