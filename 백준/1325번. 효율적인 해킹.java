import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] line_cnt;
    static int[] answer;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);    // B -> A 는 가능하지만 그 역은 성립하지 않는다.
        }

        answer = new int[N+1];

        for(int i = 1; i <= N; i++){    // i = 시작지점
            line_cnt = new int[N+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            line_cnt[i]++;
            while(!q.isEmpty()){    // 방문하기
                int polled = q.poll();
                for(int com : list[polled]){    // 연결이 가능한 컴퓨터를 찾는다
                    if(line_cnt[com]==0){
                        answer[i]++;
                        line_cnt[com]++;
                        q.add(com);
                    }
                }
            }
        }

        int max = Arrays.stream(answer).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N ; i++){
            if(answer[i] == max){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}