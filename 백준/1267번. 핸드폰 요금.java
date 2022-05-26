import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M_Money = 0;
        int Y_money = 0;

        for(int i =0; i<N; i++){
            int time = sc.nextInt();
            Y_money += 10 + (time/30)*10;
            M_Money += 15 + (time/60)*15;
        }

        String result;

        if(Y_money<M_Money)
            result = "Y "+Y_money;
        else if(Y_money>M_Money)
            result = "M "+M_Money;
        else
            result = "Y M "+Y_money;

        System.out.println(result);
    }
}
