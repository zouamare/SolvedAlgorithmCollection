import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int[] a = new int[sc.nextInt()];
            int[] b = new int[sc.nextInt()];
            int A = a.length;
            int B = b.length;
            for(int i = 0; i<A; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0; i<B; i++){
                b[i] = sc.nextInt();
            }
            int num = 0;
            if(A>B){
                for(int i = 0; i<=A-B; i++){
                    int n = 0;
                    for(int j = 0;j<B; j++){
                        n += a[j+i] * b[j];
                    }
                    num = Math.max(num,n);
                }
            }
            else{
                for(int i = 0; i<=B-A; i++){
                    int n = 0;
                    for(int j = 0; j<A; j++){
                        n += a[j] * b[j+i];
                    }
                    num = Math.max(num, n);
                }
            }
            System.out.println("#"+test_case+" "+num);
        }
    }
}