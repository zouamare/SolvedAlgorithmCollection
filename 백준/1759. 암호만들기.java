package coding_test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
    static int L, C;
    static char[] alpha;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());   // 암호의 길이
        C = Integer.parseInt(st.nextToken());   // 전체 문자의 갯수
        st = new StringTokenizer(br.readLine());
        alpha = new char[C];
        for(int i = 0; i < C; i++)  alpha[i] = st.nextToken().charAt(0);
        Arrays.sort(alpha); // 정렬을 한번 해준다.

        comb(new char[L],new boolean[C],0,0);   // 조합 시작

        bw.flush(); // 출력
        bw.close();
    }

    private static void comb(char[] output, boolean[] visited, int start, int depth) throws IOException {
        if(depth == L){
            // 여기서 모음 + 자음 구조가 맞지 않으면 return;
            if(!isValid(output))  return;
            // 모음 + 자음 구조가 맞으면 BufferedWriter에 추가.
            printCode(output);
            return;
        }
        for(int i = start; i < C; i++){
            if(visited[i])  continue;
            visited[i] = true;
            output[depth] = alpha[i];
            comb(output, visited, i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static boolean isValid(char[] output) {
        int v = 0, c = 0;
        for (int i = 0; i < L; i++) {
            if (output[i] == 'a' || output[i] == 'e' || output[i] == 'i' || output[i] == 'o' || output[i] == 'u') v++;
            else c++;
        }
        return v >= 1 && c >= 2;
    }

    private static void printCode(char[] output) throws IOException {
        for(int i = 0; i < L; i++){
            bw.append(output[i]);
        }
        bw.append("\n");
    }
}
