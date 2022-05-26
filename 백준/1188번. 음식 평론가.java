import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if(N%M == 0)    // N이 M으로 나누어 떨어지면 자를 필요 없다.
            System.out.println(0);
        else    // N이 M으로 나누어 떨어지지 않으면, 두 수의 최대공약수를 구해서 (M - 최대공약수)를 반환한다.
            System.out.println(M - BigInteger.valueOf(N).gcd(BigInteger.valueOf(M)).intValue());
    }
}
