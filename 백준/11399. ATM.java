package coding_test.Algo20220920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  queue.add(Integer.parseInt(st.nextToken()));
        int total = 0;
        int beforeTotal = 0;
        for(int i = 0; i < N; i++){
            beforeTotal += queue.poll();
            total += beforeTotal;
        }
        System.out.println(total);
    }
}
