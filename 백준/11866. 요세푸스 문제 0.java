package coding_test.Algo20220913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) queue.add(i);
        int cnt = 0;
        StringBuilder sb = new StringBuilder("<");
        while (!queue.isEmpty()){
            int val = queue.poll();
            if(++cnt == K){
                sb.append(val);
                if(queue.size() > 0)    sb.append(", ");
                cnt = 0;
            }else queue.add(val);

        }
        sb.append(">");
        System.out.println(sb);
    }
}
