import java.io.*;
public class Main {
    static int N;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
         *
         * - 오히려 에라토스테네스의 체를 쓰면 안되는 문제였다.
         *   => 2,3,5,7로 시작하고 (맨 앞의 숫자도 소수여야 하므로) 점차 경우의 수가 줄어드므로
         *
         * - 그리고 재귀의 for문에서 소수가 아닐경우 재귀를 호출하지 않도록 구현하여 재귀 호출횟수를 최소화 했다.
         *
         * */
        findPrime("2",1,N);
        findPrime("3",1,N);
        findPrime("5",1,N);
        findPrime("7",1,N);
        bw.flush();
        bw.close();
    }

    private static void findPrime(String s, int depth, int n) throws IOException {
        if(depth == n){
            bw.write(s+"\n");
            return;
        }
        for(int i = 0; i < 10; i++){
            if(isNotPrime(s + i))    continue;  // 소수인지 확인
            findPrime(s + i, depth+1, n);
        }
    }

    private static boolean isNotPrime(String s) {
        String newS = "";
        for(int i = 0; i < s.length(); i++){
            newS += s.charAt(i);
            int num = Integer.parseInt(newS);
            for(int j = 2; j <= Math.sqrt(num); j++){
                if(num%j == 0)  return true;
            }
        }
        return false;
    }
}