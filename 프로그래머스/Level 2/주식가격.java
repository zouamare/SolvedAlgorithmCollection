import java.util.Stack;

/**
 * 거의 다 접근했었는데 아쉽게 못풀었다.
 * 스택문제를 더 풀어봐야 할 듯.
 * 매커니즘 자체는 비슷하게 생각해서 그래도 조금은 만족!
 */

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int popped = stack.pop();
                answer[popped] = i - popped;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){
            int popped = stack.pop();
            answer[popped] = prices.length - popped - 1;
        }

        return answer;
    }
}