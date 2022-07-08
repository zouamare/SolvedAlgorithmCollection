class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        DFS(numbers, target,visited,0,0,numbers.length);
        return answer;
    }

    public void DFS(int[] numbers, int target, boolean[] visited, int start,int sum, int cnt) {
        if(cnt == 0){
            if(sum == target)
                answer++;
            return;
        }
        for(int i = start; i < numbers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(numbers, target, visited, i+1, sum+numbers[i],cnt-1);
                DFS(numbers, target, visited, i+1, sum-numbers[i],cnt-1);
                visited[i] = false;
            }
        }
    }
}