package coding_test;

import java.io.*;
import java.util.*;

public class BOJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[N+1];
        int[] ans = new int[N+1];
        for(int i = 1; i <= N; i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }
        tower[0] = Integer.MAX_VALUE;

        // 뒤에서 부터 탐색한다.
        // PriorityQueue에 tower 크기, tower 위치를 저장한다.
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];   // tower 크기가 작은 순서대로 정렬
            }
        });

        for(int i = N; i >= 0; i--){
            while(!queue.isEmpty() && queue.peek()[0] < tower[i]){
                ans[queue.poll()[1]] = i;
            }
            queue.add(new int[]{tower[i], i});
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= N; i++){
            bw.write(Integer.toString(ans[i]));
            if(i != N)
                bw.write(" ");
        }

        bw.flush();
        bw.close();

    }
}
