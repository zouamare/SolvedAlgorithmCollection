import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> list;
        final int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            int dumpCnt = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list,Collections.reverseOrder());
            int max = 0, min = list.size() - 1;
            for(int i = dumpCnt; i > 0; i--) {
                list.set(max, list.get(max)-1);
                list.set(min, list.get(min) + 1);
                Collections.sort(list,Collections.reverseOrder());
            }
            System.out.println("#"+test_case+" "+(list.get(max) - list.get(min)));
        }
    }
}
