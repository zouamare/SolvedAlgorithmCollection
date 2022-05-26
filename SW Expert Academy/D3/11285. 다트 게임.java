import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int test_case = 1; test_case<=TC; test_case++){
            int N = sc.nextInt();
            int sum_of_scores = 0;
            for(int i=0; i<N; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                double z = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
                if(0<=z && z<=200){ // 0 ~ 200사이의 값일 때
                    if(z%20==0) // 20으로 나누어지는 수라면
                        z -=1;  // 강제로 -1
                    sum_of_scores += 10-(int)(z/20);    // 10 - (z/20) 으로 점수 계산
                }
            }
            System.out.println("#"+test_case+" "+sum_of_scores);
        }
    }
}