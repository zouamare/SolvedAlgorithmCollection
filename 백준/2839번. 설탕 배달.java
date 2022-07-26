import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sugarBags = {3,5};
        int[] kg = new int[N+1];
        Arrays.fill(kg, 5000);
        kg[0] = 0;
        for(int i = 0; i < sugarBags.length; i++){
            int index = sugarBags[i];
            while(index <= N){
                kg[index] = Math.min(kg[index], kg[index - sugarBags[i]] + 1);
                index++;
            }
        }
        System.out.println(kg[N]==5000?-1:kg[N]);
    }
}