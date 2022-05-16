import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String T = sc.next();
        int sum = 0;
        for(int test_case = 0; test_case < T.length(); test_case++){
            sum += Character.getNumericValue(T.charAt(test_case));
        }
        System.out.println(sum);
    }
}