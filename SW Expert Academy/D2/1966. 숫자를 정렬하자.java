import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int[] arr = new int[sc.nextInt()];
            for(int i = 0; i<arr.length; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.print("#"+test_case+" ");
            for(int i = 0; i<arr.length; i++){
                System.out.print(arr[i]);
                if(i!=arr.length-1)
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}