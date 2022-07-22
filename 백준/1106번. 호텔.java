import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] city = new int[N][2];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            city[i][0] = Integer.parseInt(st.nextToken());  //cost
            city[i][1] = Integer.parseInt(st.nextToken());  //guest
        }

        int[] arr = new int[C + 100];
        Arrays.fill(arr,100000);
        arr[0] = 0;

        for(int i = 0; i < city.length; i++){
            int index = city[i][1];
            while(index < arr.length){
                arr[index] = Math.min(arr[index], arr[index-city[i][1]] + city[i][0]);
                index++;
            }
        }

        int result = arr[C];
        for(int i = C + 1; i < arr.length; i++){
            if(result > arr[i]){
                result = arr[i];
            }
        }

        System.out.println(result);

    }
}