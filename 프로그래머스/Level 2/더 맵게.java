import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int food: scoville){
            queue.add(food);
        }
        int cnt = 0;
        while(queue.peek() < K){
            if(queue.size() < 2){
                cnt = -1;
                break;
            }
            queue.add(queue.poll() + (queue.poll() * 2));
            cnt++;
        }
        return cnt;
    }
}