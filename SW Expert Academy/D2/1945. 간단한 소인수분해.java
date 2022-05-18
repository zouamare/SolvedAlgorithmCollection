import java.util.HashMap;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = {2,3,5,7,11};
        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            StringBuffer sb = new StringBuffer();
            for(int a : arr){
                int num = 0;
                while(N%a==0){
                    num++;
                    N /= a;
                }
                sb.append(num);
                if(a!=arr[arr.length-1])
                    sb.append(" ");
            }
            System.out.println("#"+test_case+" "+sb);
        }
    }
}