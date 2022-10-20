package coding_test.Algo2022년_10월.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316_그룹단어체커 {
    static final int SIZE = 26;
    public static void main(String[] args) throws IOException {
        /*
        * string을 분해하여 prev, cur를 비교한다.
        * prev, cur이 다르면 stcVisited(한 단어 비교)를 확인한다.
        * 같으면 prev = cur 로 prev를 변경한 후 넘어감
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char prev = s.charAt(0), cur;
            boolean[] stcVisited = new boolean[SIZE];
            boolean flag = true;
            stcVisited[prev - 'a'] = true;
            for (int j = 1; j < s.length(); j++) {
                cur = s.charAt(j);
                if (prev != cur) {
                    if (stcVisited[cur - 'a']) {  // 이미 도달했던 적 있던 알파벳이라면,
                        flag = false;
                        break;
                    } else {    // 처음 나타난 알파벳이라면,
                        stcVisited[cur - 'a'] = true;
                    }
                }
                prev = cur;
            }
            if(flag)    cnt++;
        }
        System.out.println(cnt);
    }
}
