import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stones = new int[N+1];
        for(int i = 1; i <= N; i++){
            stones[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] visited = new int[N+1];
        visited[a] = 0;
        cnt = -1;
        BFS(stones, visited, a, b);
        System.out.println(cnt);
    }

    private static void BFS(int[] stones, int[] visited, int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,0});
        while(!queue.isEmpty()){
            int[] deleted = queue.poll();
            if(deleted[0] == b){
                cnt = deleted[1];
                break;
            }
            for(int i = 1; i < stones.length; i++){
                // 해당 인덱스의 원소의 배수만큼 거리를 이동할 수 있다 = 삭제된 인덱스에서 다른 인덱스를 뺀 값의 절댓값 (거리) 을 삭제된 인덱스에 해당하는 값으로 나눴을 때 나머지가 0인 경우
                if(visited[i] == 0 && Math.abs(deleted[0] - i)%stones[deleted[0]] == 0){
                    visited[i] = deleted[1] + 1;
                    queue.add(new int[]{i,visited[i]});
                }
            }
        }
    }
}