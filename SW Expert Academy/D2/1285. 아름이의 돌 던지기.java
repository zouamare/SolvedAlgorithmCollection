import java.util.HashMap;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int P = sc.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i<P; i++){
                int input = sc.nextInt();
                map.put(Math.abs(input),map.getOrDefault(input,0)+1);
            }
            System.out.println("#"+test_case+" " +map.entrySet().stream().min((i, j) -> i.getKey() < j.getKey() ? -1: 1).get().getKey()+" "+map.entrySet().stream().min((i, j) -> i.getKey() < j.getKey() ? -1: 1).get().getValue());
        }
    }
}