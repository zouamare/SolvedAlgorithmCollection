import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        final int DAYS = 7;

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int min = Integer.MAX_VALUE;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i<DAYS; i++)
                list.add(sc.nextInt());

            for(int i = 0; i<DAYS; i++){    // 완전 탐색 용도
                if(list.get(i)==0)  // 0인지 판별
                    continue;
                int cnt = 0;    // 일 수 count
                int class_cnt = N;  // 들어야 할 강의 수
                int total = (int) list.stream().filter(n->n==1).count();    // 일주일 동안의 강의 수의 합
                if(class_cnt > total){
                    int echo = (class_cnt-1) / (total); // 반복을 나타내는 변수
                    cnt = echo * 7;
                    class_cnt = class_cnt - (echo * total);
                }
                if(class_cnt > 0){  // 마지막 한줄을 차례대로 탐색
                    int index = i;
                    for(int j = 0; j<DAYS; j++){    // 최대 6회 탐색
                        if(class_cnt==0)
                            break;
                        if(list.get(index++)!=0)
                            class_cnt--;
                        cnt++;
                        if(index>6)
                            index = index%7;
                    }
                }
                min = Math.min(min, cnt);
            }
            System.out.println("#"+test_case+" "+min);
        }
    }
}