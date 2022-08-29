package coding_test.Algo20220829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407_조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        System.out.println(factorial(n).divide(factorial(n-m).multiply(factorial(m))));
    }

    public static BigInteger factorial(long x){
        BigInteger sum = new BigInteger("1");
        for(int i = 1; i <= x; i++)  sum = sum.multiply(new BigInteger(Integer.toString(i)));
        return sum;
    }
}
