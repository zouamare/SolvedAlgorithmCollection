import java.util.HashMap;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int speed = 0;
            int d = 0;
            for(int i=0; i<N; i++){
                switch (sc.nextInt()){
                    case 1:
                        speed += sc.nextInt();
                        break;
                    case 2:
                        int a = sc.nextInt();
                        if(a>speed)
                            speed = 0;
                        else
                            speed -= a;
                }
                d += speed;
            }
            System.out.println("#"+test_case+" "+d);
        }
    }
}