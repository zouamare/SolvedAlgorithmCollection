import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int R = sc.nextInt();
            int S = sc.nextInt();
            int W = sc.nextInt();

            if(R>=W){
                if(P*W > Q)
                    System.out.println("#"+test_case+" "+Q);
                else
                    System.out.println("#"+test_case+" "+P*W);
            }else{
                if(P*W > Q+(W-R)*S)
                    System.out.println("#"+test_case+" "+(Q+(W-R)*S));
                else
                    System.out.println("#"+test_case+" "+P*W);
            }
        }
    }
}