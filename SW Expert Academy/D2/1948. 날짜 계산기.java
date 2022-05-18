import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int Fmonth = sc.nextInt();
            int Fday = sc.nextInt();

            int Smonth = sc.nextInt();
            int Sday = sc.nextInt();

            int cnt = 0;

            switch (Smonth){
                case 12:
                    cnt += 30;
                case 11:
                    cnt += 31;
                case 10:
                    cnt += 30;
                case 9:
                    cnt += 31;
                case 8:
                    cnt += 31;
                case 7:
                    cnt += 30;
                case 6:
                    cnt += 31;
                case 5:
                    cnt += 30;
                case 4:
                    cnt += 31;
                case 3:
                    cnt += 28;
                case 2:
                    cnt += 31;
            }

            switch (Fmonth){
                case 12:
                    cnt -= 30;
                case 11:
                    cnt -= 31;
                case 10:
                    cnt -= 30;
                case 9:
                    cnt -= 31;
                case 8:
                    cnt -= 31;
                case 7:
                    cnt -= 30;
                case 6:
                    cnt -= 31;
                case 5:
                    cnt -= 30;
                case 4:
                    cnt -= 31;
                case 3:
                    cnt -= 28;
                case 2:
                    cnt -= 31;
            }

            cnt += Sday - Fday + 1;

            System.out.println("#"+test_case+" "+cnt);
        }
    }
}