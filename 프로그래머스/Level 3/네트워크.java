import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] arr;
    public int solution(int n, int[][] computers) {
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }

        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                if(computers[i][j] == 1 && !isSameParent(i,j)){
                    union(i,j);
                }
            }
        }

        for(int i = 0; i < arr.length; i++)
            arr[i] = find(i);

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(arr[i]);

        return set.size();
    }

    private boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        return false;
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            arr[y] = x;
    }

    private int find(int x) {
        if(arr[x] == x)
            return x;
        return arr[x] = find(arr[x]);
    }
}