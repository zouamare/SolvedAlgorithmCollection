import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            HashSet<Integer> set = new HashSet<>();
            int N = sc.nextInt();
            int i = 0;
            while(set.size()<10){
                int Ni = N*++i;
                for(int j = 0; j<Integer.toString(Ni).length(); j++){
                    set.add(Character.getNumericValue(Integer.toString(Ni).charAt(j)));
                }
            }
            System.out.println("#"+test_case+" "+N*i);
        }
    }
}