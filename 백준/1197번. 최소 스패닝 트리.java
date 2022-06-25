import java.io.IOException;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i<E; i++){
            list.add(new int[]{sc.nextInt(),sc.nextInt(),sc.nextInt()});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        parent = new int[V+1];
        for(int i = 1; i<=V; i++)
            parent[i] = i;   //일단 부모를 자기 자신으로

        int answer = 0;
        for(int i = 0; i < E; i++){
            int[] t = list.get(i);
            if(!isSameParent(t[0],t[1])){
                union(t[0],t[1]);
                answer += t[2];
            }
        }
        System.out.println(answer);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        return false;
    }

    private static int find(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}