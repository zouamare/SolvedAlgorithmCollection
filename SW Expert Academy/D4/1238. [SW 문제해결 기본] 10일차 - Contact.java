import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int data_length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String[] s = br.readLine().split(" ");
            int max_index = Arrays.stream(s).mapToInt(Integer::parseInt).max().getAsInt();
            for(int i =0; i <= max_index; i++){
                list.add(new ArrayList<>());
            }
            for(int i = 0; i < data_length; i+=2){
                int from = Integer.parseInt(s[i]);
                int to = Integer.parseInt(s[i+1]);
                list.get(from).add(to);
            }
            // DFS는 메모리 초과 오류가 발생하여 BFS로 구현
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            int[] visited = new int[max_index+1];
            visited[start] = 1;
            while(!queue.isEmpty()){
                int deleted = queue.poll();
                for(int x : list.get(deleted)){
                    if(visited[x] == 0){
                        queue.add(x);
                        visited[x] += visited[deleted] + 1;
                    }
                }
            }
            int max_result = Arrays.stream(visited).max().getAsInt();
            for(int i = max_index; i>=0; i--){
                if(visited[i] == max_result) {
                    System.out.println("#" + test_case + " " + i);
                    break;
                }
            }
        }
    }


}