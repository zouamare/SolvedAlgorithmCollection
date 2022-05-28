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
            int D = sc.nextInt();   // 기본 데미지
            int L = sc.nextInt();   // 용사의 레벨
            int N = sc.nextInt();   // 몬스터를 공격할 횟수

            int damage = 0; // 총 데미지
            for(int n=0; n<N; n++){     // N만큼 반복
                damage += D + (D * n * L)/100;  // D(1+n*L%)를 수식으로 변경
            }
            System.out.println("#"+test_case+" "+damage);
        }
    }
}