import java.util.*;

public class Main {
    static String[] relationship;
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int most_famous_persons_friends_cnt = 0;
        relationship = new String[N];

        for(int i = 0; i<N; i++){
            relationship[i] = sc.next();    // 초기 설정
        }

        for(int i = 0; i<N; i++){
            most_famous_persons_friends_cnt = Math.max(most_famous_persons_friends_cnt,find_friends(i));    // 값 탐색
        }
        System.out.println(most_famous_persons_friends_cnt);    // 값 출력
    }

    private static int find_friends(int index) {
        int size;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(index);    // 자기 자신의 값 넣기 (나중에 -1로 빼줄 예정)
        for(int i = 0; i<N; i++){   // 1-친구 구하기
            if(relationship[index].charAt(i)=='Y')
                list.add(i);
        }
        size = list.size();
        for(int i = 0;i<size; i++){ // 2-친구 구하기
            for(int j = 0; j<N; j++){
                if(relationship[list.get(i)].charAt(j)=='Y' && !list.contains(j))   //list에 이미 1-친구가 넣어져 있으므로 1-친구가 아닌 2-친구만 삽입
                    list.add(j);
            }
        }
        return list.size()-1;   // 자기 자신 값을 뺀다.
    }
}
