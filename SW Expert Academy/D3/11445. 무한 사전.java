import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=TC; test_case++){
            String P = br.readLine().trim();
            String Q = br.readLine().trim();
            String answer ="Y";
            if(Q.length()==P.length()+1){
                if(Q.charAt(Q.length()-1)=='a' && (Q.equals(P+'a')))    // Tip! Q와 (P+'a')를 직접비교 해야 함
                    answer = "N";
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}