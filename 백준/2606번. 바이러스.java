import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfComputers = Integer.parseInt(br.readLine());
        int numOfline = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] matrix = new ArrayList[numOfComputers+1];

        for(int i = 0; i < numOfComputers+1; i++){
            matrix[i] = new ArrayList<>();
        }

        for(int i = 0; i < numOfline; i++){
            String[] tmp = br.readLine().split(" ");
            matrix[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
            matrix[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
        }

        boolean[] visited = new boolean[numOfComputers+1];
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int cnt = 0;
        while(!queue.isEmpty()){
            int deleted = queue.poll();
            for(int i = 1; i < matrix.length; i++){
                if(!visited[i] && matrix[deleted].contains(i)){
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}