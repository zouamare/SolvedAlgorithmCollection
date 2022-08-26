package coding_test.Algo20220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
    static int N, maxGoal;
    static int[][] point;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        point = new int[N][10];  // 1 ~ 9까지 사용하기 위함
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxGoal = Integer.MIN_VALUE;
        batterPerm(0,new boolean[10], new int[8]);
        System.out.println(maxGoal);
    }

    private static void batterPerm(int depth, boolean[] visited, int[] output) {
        if(depth == 8){
            startBaseBallGame(setArr(output));
            return;
        }
        for(int i = 2; i <= 9; i++){
            if(visited[i])  continue;
            visited[i] = true;
            output[depth] = i;
            batterPerm(depth+1, visited, output);
            visited[i] = false;
        }
    }

    private static int[] setArr(int[] output) {
        int[] arr = new int[9];
        for(int i = 0; i < 3; i++)  arr[i] = output[i];
        arr[3] = 1;
        for(int i = 3; i < 8; i++)  arr[i+1] = output[i];
        return arr;
    }

    private static void startBaseBallGame(int[] output) {
        int outCnt = 0, inning = 0, idx = 0, goal = 0;
        int[] map = new int[3]; // 1루 2루 3루
        // 이닝이 모두 종료되었다.
        while (inning < N) {
            switch (point[inning][output[idx]]) {
                case 0: // 아웃
                    if (++outCnt == 3) {
                        inning++;   // 다음 inning 시작
                        map = new int[3];
                        outCnt = 0;
                    }
                    break;
                case 1: // 안타
                    if (map[2] != 0) goal++;
                    map[2] = map[1];
                    map[1] = map[0];
                    map[0] = output[idx];
                    break;
                case 2: // 2루타
                    if (map[2] != 0) goal++;
                    if (map[1] != 0) goal++;
                    map[2] = map[0];
                    map[1] = output[idx];
                    map[0] = 0;
                    break;
                case 3: // 3루타
                    if (map[2] != 0) goal++;
                    if (map[1] != 0) goal++;
                    if (map[0] != 0) goal++;
                    map[2] = output[idx];
                    map[1] = map[0] = 0;
                    break;
                case 4: // 홈런
                    if (map[2] != 0) goal++;
                    if (map[1] != 0) goal++;
                    if (map[0] != 0) goal++;
                    map[2] = map[1] = map[0] = 0;
                    goal++; // output[idx] 까지 나옴
                    break;
            }
            idx = (idx + 1) % 9;
        }
        if(maxGoal < goal)  maxGoal = goal;
    }
}
