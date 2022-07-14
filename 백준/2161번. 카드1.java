import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new LinkedList<>();
        ArrayList<Integer> deleted = new ArrayList<>();

        // 카드들을 순서대로 삽입한다.
        for(int i = 1; i <= N; i++)
            cards.add(i);

        // 카드가 하나 남을 때까지 동작을 반복한다.
        // 동작: 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
         while(cards.size() > 1){
             deleted.add(cards.poll());
             cards.add(cards.poll());
         }

         // 버린 카드를 먼저 출력한다.
         for(int i = 0; i < deleted.size(); i++)
             System.out.print(deleted.get(i)+" ");

        // 이후 남아있는 카드도 출력한다.
        System.out.println(cards.poll());
    }

}