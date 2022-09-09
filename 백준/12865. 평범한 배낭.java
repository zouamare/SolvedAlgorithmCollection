package coding_test.Algo20220909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  이 문제를 어떻게 풀어야 할까..
 *  물건의 개수 N이 최대 100이다..
 *  준서가 버틸 수 있는 무게는 최대 10만.
 *  N개의 줄마다 각 물건의 무게 W(최대 10만)
 *  해당 물건의 가치 V(최대 1000)가 주어짐.
 *
 * 문제만 봤을 때 생각나는 풀이.
 * 1. 그리디
 * 2. DP
 * 3. 완탐 -> 절대 불가능. N이 최대 100이기 때문
 *
 * 1. 그리디로 풀 수 있는가? 그렇다면 어떻게?
 * 안댐.... 배낭 문제자나....
 *
 *
 * 2. DP로 접근을 해볼까? (여기 까진 접근 맞음
 * 가치순으로 정렬해서 비교하면서 dp배열에 쌓아가면 될 거 같은데.. => 안됨.
 *
 * 결국 인터넷에 검색해서 풀이했다.
 * 참고한 블로그 : https://st-lab.tistory.com/141
 *
 * */

public class BOJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N+1];
        int[] V = new int[N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= K; i++){
            for(int j = 1; j <= N; j++){
                if(W[j] > i){
                    dp[j][i] = dp[j-1][i];
                }else{  // 현재 접근한 무게 i가 각 인덱스의 무게보다 커지면, 고려할 수 있는 방향이 생긴다.
                    // 위의 것을 선택할 것인지, 또는 나의 위치에서 해당 값을 뺀 만큼의 위치를 더한 값을 선택할 것인지 골라야 함
                    dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-W[j]] + V[j]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
