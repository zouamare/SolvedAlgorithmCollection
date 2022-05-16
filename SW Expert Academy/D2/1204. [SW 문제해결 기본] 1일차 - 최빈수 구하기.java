import java.util.HashMap;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        HashMap<Integer,Integer> map;
        for(int test_case = 1; test_case<=T; test_case++){
            map = new HashMap<>();
            sc.nextInt();
            for(int i = 0; i<1000; i++){
                int key = sc.nextInt();
                map.put(key,map.getOrDefault(key,0)+1);
            }
            System.out.println("#"+test_case+" "+ map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey());
        }
    }
}