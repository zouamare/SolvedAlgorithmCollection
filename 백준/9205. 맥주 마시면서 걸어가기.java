package coding_test.Algo2022년_10월.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {
    static final int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());    // 편의점의 개수

            Point[] points = new Point[N + 2];  // 편의점의 개수 + 상근이네 + 페스티벌

            for (int i = 0; i < N+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            int[][] map = new int[N+2][N+2];
            for (int i = 0; i < N+2; i++) {
                for (int j = i + 1; j < N+2; j++) {
                    if(i == j)  continue;
                    int dist = Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y);
                    if(dist <= 1000){
                        map[i][j] = dist;
                        map[j][i] = dist;
                    }
                    else{
                        map[i][j] = INF;
                        map[j][i] = INF;
                    }
                }
            }

            for (int i = 1; i <= N; i++) {  // 경유지
                for (int j = 0; j < N + 2; j++) {   // 출발지
                    if(i == j)  continue;
                    for (int k = j + 1; k < N + 2; k++) {   // 도착지
                        if(i == k || j == k)    continue;
                        if(map[j][i] != INF && map[i][k] != INF) {
                            map[j][k] = map[i][k];
                            map[k][j] = map[i][k];
                        }
                    }
                }
            }

            System.out.println((map[0][N+1] != INF ? "happy" : "sad"));
        }
    }


    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
