import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int test_case = 0; test_case < T; test_case++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        System.out.println(list.get(T/2));
    }
}