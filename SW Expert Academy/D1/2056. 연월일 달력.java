import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case<= T; test_case++){
            String s = sc.next();
            String year = s.substring(0,4);
            String month = s.substring(4,6);
            String day = s.substring(6, 8);

            if(Integer.parseInt(year)<=0){
                System.out.println("#"+test_case+" -1");
                continue;
            }

            switch (month){
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    if(Integer.parseInt(day)<1 || Integer.parseInt(day)>31){
                        System.out.println("#"+test_case+" -1");
                        continue;
                    }
                    break;
                case "02":
                    if(Integer.parseInt(day)<1 || Integer.parseInt(day)>28){
                        System.out.println("#"+test_case+" -1");
                        continue;
                    }
                    break;
                case "04":
                case "06":
                case "09":
                case "11":
                    if(Integer.parseInt(day)<1 || Integer.parseInt(day)>30){
                        System.out.println("#"+test_case+" -1");
                        continue;
                    }
                    break;
                default:
                    System.out.println("#"+test_case+" -1");
                    continue;
            }
            System.out.println("#"+test_case+" "+year+"/"+month+"/"+day);
        }
    }
}