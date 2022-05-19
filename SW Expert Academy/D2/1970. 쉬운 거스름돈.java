import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] moneys = {50000,10000,5000,1000,500,100,50,10};
        for(int test_case = 1; test_case<=T; test_case++){
            System.out.println("#"+test_case);
            int myMoney = sc.nextInt();
            String s = "";
            for(int i: moneys){
                s += myMoney/ i;
                myMoney %= i;
                if(i!=10)
                    s += " ";
            }
            System.out.println(s);
        }
    }
}