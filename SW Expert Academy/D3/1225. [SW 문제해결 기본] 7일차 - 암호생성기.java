package coding_test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
    static final int T = 10;
    static final int NUM_CNT = 8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t = 1; t <= T; t++){
            sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < NUM_CNT; i++)
                queue.add(sc.nextInt());
            int adder = 1;
            while(true){
                int num = queue.poll() - adder++;
                if(num <= 0) {
                    queue.add(0);
                    break;
                }
                queue.add(num);
                if(adder == 6)
                    adder = 1;
            }

            System.out.print("#"+t);
            for(int i = 1; i <= NUM_CNT; i++){
                System.out.print(" "+queue.poll());
            }
            System.out.println();
        }
    }
}
