package coding_test.Algo20220828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
*  총 11번의 시도 끝에 성공...!!
*  이 문제는 BFS 문제이나 도달할 때 까지의 경로가 다양할 수 있고, 다양하다면 해당 경로의 카운트를 세는 문제이다.
*
*  그렇다면 나는 중복문제를 어떻게 해결했는가?
*
*  int 타입 visited 배열을 이용하여 풀이했다.
*  visited배열에 해당 숫자까지 도달하는 time을 저장하고, 저장된 time을 비교하여 작거나 같을 때는 다시 계산을 진행하는 방법을 이용했다.
*  생각해보니 작을 때는 없을 거 같아서 빼도 괜찮을 것 같다.
*
*  위의 방식을 적용하니 최단 거리이면서 다양한 루트들을 고려할 수 있었다.
* */
public class BOJ_12851_숨바꼭질2 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        findSister();
    }

    private static void findSister() {
        int time = Integer.MAX_VALUE, way = 0;
        Queue<Dist> queue = new ArrayDeque<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        queue.add(new Dist(N, 0));
        visited[N] = 0;
        while(!queue.isEmpty()){
            Dist tmp = queue.poll();
            if(tmp.time > time){
                System.out.println(time);
                System.out.println(way);
                return;
            }
            if(tmp.val == K){
                time = tmp.time;    // time이 더 큰 수로 갱신될 가능성은 없다. 그 이유는 위에서 time과 tmp의 time을 비교하여 클 경우 반복문을 종료하게 구성했기 때문이다.
                way++;
            }
            int plus = tmp.val+1, minus = tmp.val-1, multi = tmp.val*2;
            if(plus <= 100000 && (visited[plus] >= tmp.time + 1)){
                queue.add(new Dist(plus, tmp.time + 1));
                visited[plus] = tmp.time + 1;
            }
            if(minus >= 0 && (visited[minus] >= tmp.time + 1)){
                queue.add(new Dist(minus, tmp.time + 1));
                visited[minus] = tmp.time + 1;
            }
            if(multi <= 100000 && (visited[multi] >= tmp.time + 1)){
                queue.add(new Dist(multi, tmp.time + 1));
                visited[multi] = tmp.time + 1;
            }
        }
        // queue에 남아있는 것이 없는 경우에는 바로 출력하도록 한다.
        // 도달할 수 없는 경우가 없으므로 따로 조건을 걸지 않아도 될 것 같다.
        System.out.println(time);
        System.out.println(way);
    }

    static class Dist{
        int val, time;

        public Dist(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }
}
