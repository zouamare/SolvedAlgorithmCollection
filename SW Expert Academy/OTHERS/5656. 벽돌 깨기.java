package day20221005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
    static int N, W, H, minVal;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        int totalBlockCnt = 0;

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0)  totalBlockCnt++;
            }
        }
        minVal = totalBlockCnt;
        overlapPerm(0, map, totalBlockCnt);
        System.out.println("#"+t+" "+minVal);
    }
}

private static void overlapPerm(int depth, int[][] map, int blockCnt) {
    if(blockCnt == 0 || depth == N){
        if(minVal > blockCnt)   minVal = blockCnt;
        return;
    }
    for (int i = 0; i < W; i++) {
    	int[][] newMap = copyMap(map);
        int deletedCnt = boomTheBlock(newMap, i);
        doGravity(newMap);
        overlapPerm(depth + 1, newMap, blockCnt - deletedCnt);
    }
}

private static void doGravity(int[][] map) {
    for (int j = 0; j < W; j++) {
        for (int i = H - 1; i > 0; i--) {
            if(map[i][j] != 0)  continue;
            int row = i - 1;
            while(row >= 0 && map[row][j] == 0) row--;
            if(row == -1)   break;
            map[i][j] = map[row][j];
            map[row][j] = 0;
        }
    }
}

private static int[][] copyMap(int[][] map) {
    int[][] newMap = new int[H][W];
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            newMap[i][j] = map[i][j];
        }
    }
    return newMap;
}

private static int boomTheBlock(int[][] map, int col) {
    int deletedBlockCnt = 0;
    int row = 0;

    while(row < H && map[row][col] == 0)   row++;
    if(row == H)    return deletedBlockCnt;

    Queue<Point> queue = new ArrayDeque<>();
    queue.add(new Point(row, col, map[row][col]));
    map[row][col] = 0;
    while (!queue.isEmpty()){
        Point p = queue.poll();
        deletedBlockCnt++;

        if(p.val == 1) continue;

        for (int d = 0; d < 4; d++) {
            int nx = p.x;
            int ny = p.y;
            for (int i = 1; i < p.val; i++) {
                nx += dx[d];
                ny += dy[d];
                if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] > 0) {
                    queue.add(new Point(nx, ny, map[nx][ny]));
                    map[nx][ny] = 0;
                }
            }
        }
    }
    return deletedBlockCnt;
}

static class Point{
    int x, y, val;

    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
}