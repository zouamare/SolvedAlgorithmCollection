package coding_test.Algo20220905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 이 유형은 여러번 풀었어서 빠르게 풀 줄 알았는데, 경기도 오산이었다.
* 일단 * 2 가 cost가 들지 않으므로, 이 부분을 먼저 고려를 해야하기 위해 PriorityQueue를 사용했다. --> 여기까지는 생각을 했다!
* 그리고 해당 PriorityQueue 원소의 우선순위를 cost가 낮은 순, cost가 같다면 value가 작은 순으로 정렬을 해야 했다. --> 이부분에서 막혔음.
* visited를 int로 구현할 필요가 없는 것은 `최단거리` 만 구하면 되기 때문이다.
* */
public class BOJ_13549_숨바꼭질3 {
    static int MAX_VALUE = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Number> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[MAX_VALUE+ 1];
        queue.add(new Number(N, 0));
        visited[N] = true;
        while (!queue.isEmpty()){
            Number number = queue.poll();
            if(number.val == K){
                System.out.println(number.cnt);
                return;
            }

            if(number.val <= MAX_VALUE / 2 && !visited[number.val * 2]){
                queue.add(new Number(number.val * 2, number.cnt));
                visited[number.val * 2] = true;
            }
            if(number.val > 0 && !visited[number.val - 1]){
                queue.add(new Number(number.val - 1, number.cnt + 1));
                visited[number.val - 1] = true;
            }
            if(number.val < MAX_VALUE && !visited[number.val + 1]){
                queue.add(new Number(number.val + 1, number.cnt + 1));
                visited[number.val + 1] = true;
            }
        }
    }

    static class Number implements Comparable<Number>{
        int val, cnt;

        public Number(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) {
            if(this.cnt == o.cnt)   return this.val - o.val;
            return this.cnt - o.cnt;
        }
    }
}
