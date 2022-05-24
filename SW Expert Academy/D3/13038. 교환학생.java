import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        final int days_num = 7;

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();   // 수업을 들어야 하는 일 수를 저장하는 변수
            int min = Integer.MAX_VALUE;    // 최소값을 저장할 변수

            ArrayList<Integer> list = new ArrayList<>();    // 요일 값 저장 리스트
            for(int i = 0; i<days_num; i++)
                list.add(sc.nextInt());

            for(int i = 0; i<days_num; i++){
                if(list.get(i)==1){ // 1로 시작하는 경우마다 계산
                    int n = N;  // 수업 일 수 변수
                    int index = i;  // 현재 인덱스 변수
                    int cnt = 0;    // 일 수 카운트 변수
                    while(n>0){ //
                        if(list.get(index)==1){ // 1이면
                            n--;    // 수업 일 수 -1
                        }
                        cnt++;  // 반복마다 일 수 카운트 + 1
                        index++;    // 반복마다 index + 1
                        if(index>6) // index가 6보다 클 경우는
                            index = index%7;    // 다시 처음부터
                    }
                    min = Math.min(min, cnt);   // 1로 시작하는 경우마다 계산한 값의 최솟값을 저장하여
                }
            }
            System.out.println("#"+test_case+" "+min);  // 출력
        }
    }
}