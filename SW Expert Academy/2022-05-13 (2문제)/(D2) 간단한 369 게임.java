import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        String result = "";

        for(int test_case = 1; test_case <= T; test_case++)
        {
            boolean threesixnine = false;
            for(int i = 0; i <Integer.toString(test_case).length(); i++){
                if(Integer.toString(test_case).charAt(i)=='3' || Integer.toString(test_case).charAt(i)=='6' || Integer.toString(test_case).charAt(i)=='9') {
                    result += '-';
                    threesixnine = true;
                }
            }
            if(!threesixnine)
                result += Integer.toString(test_case);
            if(test_case!=T)
                result += " ";
        }
        System.out.println(result);
    }
}