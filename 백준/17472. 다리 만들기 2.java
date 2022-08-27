package coding_test.Algo20220827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 틀렸던 이유
 * 마지막에 연결됐는지 비교하는 곳에서 각 인덱스 마다 1번 인덱스의 find 값이랑 비교해야 하는데,
 * 실수로 i 자리에 숫자 2를 넣었다..ㅠㅠ
 */

public class BOJ_17472_다리만들기2 {
    static int N, M, islandCnt;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeNumberToIsland();   // 각 섬에 번호를 붙여줌. (DFS 이용)
        System.out.println(makeBridgeToIsland());   // 번호를 붙여준 섬의 각각의 거리를 구하고 크루스칼을 이용하여 최단 거리를 도출
    }

    private static int makeBridgeToIsland() {
        // 다리를 만드는 역할의 메소드
        // 다리를 어떻게 만들까? --> BFS 탐색을 활용하여 islandArr를 만들고 최단 거리를 계속 갱신하면서 진행하자.
        // 2차원 배열을 만들어서 해보자
        int[][] minDist = new int[islandCnt+1][islandCnt+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0)  continue;
                int from = map[i][j];

                // 위 확인
                int x = i - 1, y = j;
                int cnt = 0;
                while(isValid(x,y)){
                    if(map[x][y] == from)   break;
                    if(map[x][y] != 0){ // 다른 섬을 발견했다!!
                        int to = map[x][y];
                        if((minDist[from][to] == 0 || minDist[from][to] > cnt) && cnt >= 2){
                            minDist[from][to] = cnt;
                            minDist[to][from] = cnt;
                        }
                        break;
                    }
                    x--;
                    cnt++;
                }

                // 아래 확인
                x = i + 1;
                y = j;
                cnt = 0;
                while(isValid(x,y)){
                    if(map[x][y] == from)   break;
                    if(map[x][y] != 0){ // 다른 섬을 발견했다!!
                        int to = map[x][y];
                        if((minDist[from][to] == 0 || minDist[from][to] > cnt) && cnt >= 2){
                            minDist[from][to] = cnt;
                            minDist[to][from] = cnt;
                        }
                        break;
                    }
                    x++;
                    cnt++;
                }

                // 왼쪽 확인
                x = i;
                y = j - 1;
                cnt = 0;
                while(isValid(x,y)){
                    if(map[x][y] == from)   break;
                    if(map[x][y] != 0){ // 다른 섬을 발견했다!!
                        int to = map[x][y];
                        if((minDist[from][to] == 0 || minDist[from][to] > cnt) && cnt >= 2){
                            minDist[from][to] = cnt;
                            minDist[to][from] = cnt;
                        }
                        break;
                    }
                    y--;
                    cnt++;
                }

                // 오른쪽 확인
                x = i;
                y = j + 1;
                cnt = 0;
                while(isValid(x,y)){
                    if(map[x][y] == from)   break;
                    if(map[x][y] != 0){ // 다른 섬을 발견했다!!
                        int to = map[x][y];
                        if((minDist[from][to] == 0 || minDist[from][to] > cnt) && cnt >= 2){
                            minDist[from][to] = cnt;
                            minDist[to][from] = cnt;
                        }
                        break;
                    }
                    y++;
                    cnt++;
                }
            }
        }

        // 이제 위의 minDist 배열을 크루스칼을 이용해서 최단거리를 구해보자.
        p = new int[islandCnt+1];
        for(int i = 1; i <= islandCnt; i++) p[i] = i;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i = 1; i <= islandCnt; i++){
            for(int j = i+1; j <= islandCnt; j++){
                if(minDist[i][j] != 0)  queue.add(new Edge(i, j, minDist[i][j]));
            }
        }
        int sum = 0;
        while(!queue.isEmpty()){    // union-find 적용
            Edge tmp = queue.poll();
            if(union(tmp.from, tmp.to)) sum += tmp.weight;
        }
        int linked = find(1);
        for(int i = 2; i <= islandCnt; i++){    // 연결되어 있는지 확인하는 과정.
            if(find(i) != linked)  return -1;  // 연결되어 있지 않으면 -1을 반환함
        }
        return sum;
    }

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int find(int x){
        if(p[x] == x)   return x;
        return p[x] = find(p[x]);
    }

    private static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)  return false;
        p[y] = x;
        return true;
    }

    private static void makeNumberToIsland() {  // 섬마다 번호를 붙여주는 메소드
        int num = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 || visited[i][j])   continue;
                ++num;
                make(i, j, num, visited);
            }
        }
        islandCnt = num;
    }

    private static void make(int x, int y, int num, boolean[][] visited) {  // DFS
        visited[x][y] = true;
        map[x][y] = num;
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(isValid(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]) make(nx, ny, num, visited);
        }
    }

    private static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
