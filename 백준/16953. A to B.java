package coding_test.Algo20220830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16953_AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int MAX_VAL = 1000000000;
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<long[]> queue = new ArrayDeque<>();
        Set<Long> set = new HashSet<>();
        queue.add(new long[]{A, 1L});
        set.add(A);
        while (!queue.isEmpty()){
            long[] tmp = queue.poll();
            if(tmp[0] == B){
                System.out.println(tmp[1]);
                return;
            }
            long addOne = Long.parseLong(Long.toString(tmp[0])+"1"), multi = tmp[0] * 2;
            if(addOne < MAX_VAL && set.add(addOne)) queue.add(new long[]{addOne, tmp[1]+1});
            if(multi < MAX_VAL && set.add(multi))  queue.add(new long[]{multi, tmp[1]+1});
        }
        System.out.println(-1);
    }
}
