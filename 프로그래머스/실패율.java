import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        int cnt = stages.length;
        int[] arr = new int[N+1];
        for(int i: stages){
            arr[i-1]++;
        }
        ArrayList<Stage> list = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]== 0)
                list.add(new Stage(i+1,(double) 0));
            else
                list.add(new Stage(i+1,(double) arr[i]/cnt));
            cnt -= arr[i];
        }
        return list.stream().sorted().mapToInt(Stage -> Stage.num).toArray();
    }

    class Stage implements Comparable<Stage>{
        int num;
        double fail_percent;

        Stage(int num, double fail_percent){
            this.num = num;
            this.fail_percent = fail_percent;
        }

        @Override
        public int compareTo(Stage o){
            if(this.fail_percent > o.fail_percent)
                return -1;
            else if(this.fail_percent == o.fail_percent)
                return 0;
            else
                return 1;
        }

    }
}