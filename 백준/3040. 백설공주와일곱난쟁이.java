package coding_test;

import java.util.Scanner;

public class BOJ_3040_백설공주와일곱난쟁이 {
    static final int MAX_DWARF_NUM = 9;
    static final int BASIC_DWARF_NUM = 7;
    static final int VALID_SUM = 100;
    static int[] dwarfs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dwarfs = new int[MAX_DWARF_NUM];
        for(int i = 0; i < MAX_DWARF_NUM; i++){
            dwarfs[i] = sc.nextInt();
        }
        // 9C7 이므로 넥퍼를 이용해서 풀이할 수는 없다.
        // 그렇다면, 비트 마스킹을 이용해서 풀이해보자.
        comb(0,0,0,0);
    }

    private static void comb(int depth, int start, int flag, int sum) {
        if(depth == BASIC_DWARF_NUM){
            if(sum == VALID_SUM) {
                for(int i = 0; i < MAX_DWARF_NUM; i++){
                    if((flag & 1<<i) != 0){
                        System.out.println(dwarfs[i]);
                    }
                }
            }
            return;
        }
        for(int i = start; i < MAX_DWARF_NUM; i++){
            if((flag & 1<<i) == 1)  continue;
            comb(depth+1, i+1, (flag | 1 << i), sum + dwarfs[i]);
        }
    }
}
