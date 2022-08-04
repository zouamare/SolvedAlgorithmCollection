class Solution {
    int index;
    int[][] answer;
    public int[][] solution(int n) {
        int N = (int) Math.pow(2,n) - 1;
        answer = new int[N][2];
        index = 0;
        hanoi(n, 1, 3, 2);
        return answer;
    }

    public void hanoi(int n, int start, int target, int sub){
        if(n == 1){
            answer[index][0] = start;
            answer[index++][1] = target;
            return;
        }
        hanoi(n-1, start, sub, target);
        answer[index][0] = start;
        answer[index++][1] = target;
        hanoi(n-1, sub, target, start);
    }
}