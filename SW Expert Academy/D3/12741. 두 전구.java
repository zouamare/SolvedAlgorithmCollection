import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int A = sc.nextInt();   // 전구 X가 켜진 시간
            int B = sc.nextInt();   // 전구 X가 꺼진 시간
            int C = sc.nextInt();   // 전구 Y가 켜진 시간
            int D = sc.nextInt();   // 전구 Y가 꺼진 시간

            int result = Math.min(B,D) - Math.max(A,C); // X,Y의 꺼진시간 중에 작은 값 - X,Y의 켜진시간 중에서 큰 값

            if(result<0)    // 음수가 될 수 있으므로
                result = 0; // 음수라면 0으로 변환

            System.out.println("#"+test_case+" "+result);   // 출력

        }
    }
}