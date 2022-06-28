import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine());    // 연결할 수 있는 선의 수
        int[][] vertex = new int[M][3];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex[i][0] = Integer.parseInt(st.nextToken()) -1;
            vertex[i][1] = Integer.parseInt(st.nextToken()) -1;
            vertex[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(vertex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        parent = new int[N];
        for(int i = 0; i < N; i++)
            parent[i] = i;

        int cost = 0;
        for(int[] arr : vertex){
            if(Arrays.stream(parent).sum() == 0)
                break;
            if(!isSameParent(arr[0],arr[1])){
                union(arr[0],arr[1]);
                cost += arr[2];
            }
        }
        System.out.println(cost);
    }

    private static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x!=y)
            parent[y] = x;
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y)
            return false;
        return true;
    }
}