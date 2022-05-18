import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            String output = "";
            int j = 0;
            for(int i = 0; i<N; i++){
                String alpha = sc.next();
                int num = sc.nextInt();
                while(num>0){
                    output += alpha;
                    num--;
                    j++;
                    if(j==10){
                        output += "\n";
                        j = 0;
                    }
                }
            }
            System.out.println("#"+test_case);
            System.out.println(output);
        }
    }
}