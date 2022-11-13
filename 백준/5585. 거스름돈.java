package coding_test.Algo2022년_11월.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585_거스름돈 {
    private final static int payBill = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coins = {500, 100, 50, 10, 5, 1};
        int money = payBill - Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0, size = coins.length; i < size; i++) {
            result += money / coins[i];
            money %= coins[i];
        }
        System.out.println(result);
    }
}
