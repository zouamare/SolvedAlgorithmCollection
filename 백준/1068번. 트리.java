import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // number of nodes
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tree = new int[N];    // array to save nodes

        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        int nodeToDelete = Integer.parseInt(br.readLine()); // node's index to delete

        Queue<Integer> queue = new LinkedList<>();

        queue.add(nodeToDelete);
        tree[nodeToDelete] = -2;    // fill '-2' in deleted node's index

        while(!queue.isEmpty()){
            int deleted = queue.poll();
            for(int i = 0; i < tree.length; i++){
                if(tree[i] == deleted) {    // if deleted node has child, delete child and child's child too.
                    queue.add(i);
                    tree[i] = -2;
                }
            }
        }

        int leapNodeCnt = 0;
        for(int i = 0 ; i < tree.length; i++){
            if(tree[i] == -1){  // find root node
                queue.add(i);
                break;
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            int hasChild = 0;
            for(int i = 0; i < tree.length; i++){
                if(tree[i] == node){    // figure out node what has child
                    hasChild++;
                    queue.add(i);
                }
            }
            if(hasChild == 0)   // if node doesn't have child nodes, node is leaf node.
                leapNodeCnt++;
        }

        System.out.println(leapNodeCnt);    // print count of leaf nodes
    }
}