import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i = 1; i <= test_case; i++){
            int N = sc.nextInt();   //  문서의 개수
            int M = sc.nextInt();   //  target 문서
            Queue<Integer> q = new LinkedList<>();
            for(int j = 0; j < N; j++){
                q.add(sc.nextInt());
            }
            int cnt = 1;    // 번째니까 1부터 시작
            int priority_cnt = M;
            while(!q.isEmpty()){
                int tmp = q.peek();
                if(q.stream().filter(n -> n > tmp).count() > 0){
                    if(priority_cnt > 0)
                        priority_cnt--;
                    else if(priority_cnt == 0)
                        priority_cnt = q.size() - 1;
                    q.poll();
                    q.add(tmp);
                }
                else{
                    if(priority_cnt > 0)
                        priority_cnt--;
                    else if(priority_cnt == 0)
                        break;
                    q.poll();
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}