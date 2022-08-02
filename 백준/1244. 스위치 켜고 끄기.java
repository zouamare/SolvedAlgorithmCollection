import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] switches = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            switches[i] = (st.nextToken().equals("0")?false:true);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String gender = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch (gender){
                case "1":
                    // 남성일 경우 배수의 값을 바꾼다.
                    for(int j = num; j < switches.length; j+=num){
                        switches[j] = !switches[j];
                    }
                    break;
                case "2":
                    // 여성일 경우 주변의 값을 바꾼다.
                    int d = 0;
                    while(num+d+1 < switches.length && num-d-1 > 0){
                        if(switches[num+d+1] != switches[num-d-1])
                            break;
                        d++;
                    }
                    for(int j = num - d; j <= num + d; j++){
                        switches[j] = !switches[j];
                    }
                    break;
            }
        }

        for(int i = 1; i < switches.length; i++){
            if(i != 1 && (i-1)%20 != 0)
                System.out.print(" ");
            System.out.print(switches[i]?"1":"0");
            if(i%20 == 0)
                System.out.println("");
        }
    }
}