import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case<=T; test_case++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            if(A<B)
                System.out.println("#"+test_case+" <");
            else if(A>B)
                System.out.println("#"+test_case+" >");
            else
                System.out.println("#"+test_case+" =");
        }
    }
}