import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= N; i++)
            list.add(i);
        int index = 0;  // 리스트 인덱스 변수
        int cnt = 1;    // K번째를 충족하는 곳을 구하기 위한 cnt 변수
        while(!list.isEmpty()){
            if(cnt == K){
                ans.add(list.remove(index));
                cnt = 1;
            }else{
                cnt++;
                index = (index + 1) % list.size();  // list 범위를 넘어갈 경우 자동으로 변환
            }
            if(list.isEmpty())  break;
        }
        System.out.print("<");
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i));
            if(i != ans.size() - 1)
                System.out.print(", ");
        }
        System.out.print(">");
    }
}