package coding_test.Algo20220903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 이 문제는 분할정복으로 푸는 문제였다.
* 그런데 이제 주의할 점은 mod를 중간중간에 계속해줘야 한다는 것.
* '뭔가 그래도 되지 않을까?' 하긴 했는데 진짜로 그렇게 해줘야 할줄은 몰랐다.
* 수학적인 개념, 수학 지식이 부족한 것 같다.
*
* 이 문제에서 사용된 수학적 개념은 지수 법칙과 모듈러이론이다
*
* A^N (짝수인 경우) = A^N/2 * A^N/2 이고
* A^N (홀수인 경우) = A^N/2 * A^N/2 * A 이다.
*
* 그리고 A^N % M 은 (A^N/2 % M * A^N/2 % M) % M와 같다. (짝수 기준)
*
* 이를 꼭 기억해두자.
 * */

public class BOJ_1629_곱셈 {
    static int A, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(pow(B));
    }

    private static long pow(int time) {
        if(time == 0)   return 1;
        long tmp = pow(time/2);
        tmp = tmp * tmp % C;
        if(time % 2 == 0){
            return tmp;
        }else{
            return A * tmp % C;
        }
    }
}
