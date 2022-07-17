import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());   //number of vertexes
            int E = Integer.parseInt(st.nextToken());   //number of edges

            int child1 = Integer.parseInt(st.nextToken());  // first child to find parent
            int child2 = Integer.parseInt(st.nextToken());  // second child to find parent

            ArrayList<Integer>[] graph = new ArrayList[V+1];    // arraylist to save children

            for(int i = 0; i < graph.length; i++){   // init arraylist (1)
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < E; i++){   // init arraylist (2)
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                graph[parent].add(child);
            }

            ArrayList<Integer> child1_path = new ArrayList<>();
            child1_path.add(child1);
            boolean isChanged = true;
            int index = 0;
            while(isChanged){   // save child1's routes to root
                isChanged = false;
                int child = child1_path.get(index++);
                for(int i = 1 ; i < graph.length; i++){
                    if(graph[i].contains(child)){
                        child1_path.add(i);
                        isChanged = true;
                    }
                }
            }

            ArrayList<Integer> child2_path = new ArrayList<>();
            child2_path.add(child2);
            isChanged = true;
            index = 0;
            while(isChanged){   // save child2's routes to root
                isChanged = false;
                int child = child2_path.get(index++);
                for(int i = 1 ; i < graph.length; i++){
                    if(graph[i].contains(child)){
                        child2_path.add(i);
                        isChanged = true;
                    }
                }
            }

            int commonParent = -1;
            for(int v : child1_path){   // compare with child1_path and child2_path to find the first common parent
                if(child2_path.contains(v)){
                    commonParent = v;   // find out!
                    break;
                }
            }

            Queue<Integer> queue = new LinkedList<>();  // queue for BFS
            queue.add(commonParent);
            boolean[] visited = new boolean[V+1];
            visited[commonParent] = true;
            int treeCnt = 1;
            while(!queue.isEmpty()){    // BFS Algorithm to find tree's nodes counts
                int parent = queue.poll();
                for(int child : graph[parent]){
                    if(!visited[child]){
                        queue.add(child);
                        visited[child] = true;
                        treeCnt++;
                    }
                }
            }
            System.out.println("#"+test_case+" "+commonParent+" "+treeCnt);
        }
    }
}