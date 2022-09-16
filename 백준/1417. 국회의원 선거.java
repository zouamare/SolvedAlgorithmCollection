package coding_test.Algo20220916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1417_국회의원선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = 1; i < N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        int time = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(dasom <= num){
                time++;
                dasom++;
                queue.add(num-1);
            }
        }
        System.out.println(time);
    }
}
