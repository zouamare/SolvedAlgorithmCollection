package coding_test.Algo20220911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
    static int N;
    static int[][] tree;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N][2]; // 0번째 : 왼쪽 자식, 1번째: 오른 쪽 자식
        for(int i = 0; i < N; i++){ // -1로 초기화.
            tree[i][0] = -1;
            tree[i][1] = -1;
        }
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            if(left > 0) tree[idx][0] = left;
            if(right > 0) tree[idx][1] = right;
        }
        doPreOrder(0);
        sb.append("\n");
        doInOrder(0);
        sb.append("\n");
        doPostOrder(0);
        System.out.println(sb);
    }

    private static void doPreOrder(int idx) {
        if(idx == -1)   return; // -1이 Node가 없다는 뜻, 순회를 더이상 할 이유가 없다.
        sb.append((char) (idx + 'A'));
        doPreOrder(tree[idx][0]);
        doPreOrder(tree[idx][1]);
    }

    private static void doInOrder(int idx) {
        if(idx == -1)   return; // -1이 Node가 없다는 뜻, 순회를 더이상 할 이유가 없다.
        doInOrder(tree[idx][0]);
        sb.append((char) (idx + 'A'));
        doInOrder(tree[idx][1]);
    }

    private static void doPostOrder(int idx) {
        if(idx == -1)   return; // -1이 Node가 없다는 뜻, 순회를 더이상 할 이유가 없다.
        doPostOrder(tree[idx][0]);
        doPostOrder(tree[idx][1]);
        sb.append((char) (idx + 'A'));
    }
}
