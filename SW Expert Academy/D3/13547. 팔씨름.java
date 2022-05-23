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
            String s = sc.next();
            int so = 0;
            int se = 0;
            for(char c: s.toCharArray()){
                if(c=='o')
                    so++;
                else
                    se++;
            }
            if(so+se<15){
                so += (15 - s.length());
            }
            if(so>=8)
                System.out.println("#"+test_case+" YES");
            else
                System.out.println("#"+test_case+" NO");

        }
    }
}