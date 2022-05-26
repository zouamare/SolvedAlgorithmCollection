import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int time = sc.nextInt();
        final int max_value = 1000000;

        int[][] arr = new int[num][3];

        for(int i=0; i<num;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt() - 1;
        }

        for(int i=0; i<num; i++){
            while(arr[i][0]<time && arr[i][0] < max_value && arr[i][2]>0){
                    arr[i][0] += arr[i][1];
                    arr[i][2]--;
            }
        }

        int min_time = Integer.MAX_VALUE;

        for(int i=0; i<num; i++){
            if(arr[i][0] >= time && (arr[i][0]-time) < min_time && arr[i][0] <= max_value){
                min_time = arr[i][0] - time;
            }
        }

        if(min_time==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min_time);
    }
}
