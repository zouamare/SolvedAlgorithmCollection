package coding_test.Algo2022년_10월.day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5554_심부름가는길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int second = 0;
        for (int i = 0; i < 4; i++) {
            second += Integer.parseInt(br.readLine());
        }

        int minute = second / 60;
        second %= 60;

        System.out.println(minute);
        System.out.println(second);
    }
}
