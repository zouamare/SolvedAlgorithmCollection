import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        ArrayList<String> days = init_days();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.next();
            System.out.println("#"+test_case+" "+(days.indexOf(s)+1));
        }
    }

    private static ArrayList<String> init_days() {
        ArrayList<String> days = new ArrayList<>();
        days.add("SAT");
        days.add("FRI");
        days.add("THU");
        days.add("WED");
        days.add("TUE");
        days.add("MON");
        days.add("SUN");
        return days;
    }
}