package coding_test.Algo2022년_10월.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
    public static void main(String[] args) throws IOException {
        // stack을 이용한 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0)
                stack.pop();
            else stack.add(tmp);
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
