import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        for(int i =0; i<S.length(); i++){
            System.out.print(S.charAt(i) - 64);
            if(i!=S.length()-1)
                System.out.print(" ");
        }
    }
}