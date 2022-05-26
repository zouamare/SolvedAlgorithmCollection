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
            br.readLine();
            String[] arr = br.readLine().split(" ");
            int cnt = 0;
            if(arr.length>=3){
                for(int i= 1; i<arr.length-1; i++){
                    // i-1, i, i+1 중에서 최댓값
                    int max = Math.max(Math.max(Integer.valueOf(arr[i-1]),Integer.valueOf(arr[i])),Integer.valueOf(arr[i+1]));
                    // i-1, i, i+1 중에서 최솟값
                    int min = Math.min(Math.min(Integer.valueOf(arr[i-1]),Integer.valueOf(arr[i])),Integer.valueOf(arr[i+1]));
                    if(Integer.parseInt(arr[i])!=max && Integer.parseInt(arr[i])!=min)  //가운데 값이 최댓값, 최솟값이 아닐 경우
                        cnt++;
                }
            }
            System.out.println("#"+test_case+" "+cnt);
        }
    }
}