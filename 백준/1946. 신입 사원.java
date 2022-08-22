import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            Grade[] grades = new Grade[N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                grades[i] = new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            // docu 순위가 높은 순으로 정렬
            Arrays.sort(grades);
            int winner = 1;
            int inte = grades[0].inte;
            for(int i = 1; i < N; i++){ // 이전에 합격한 사람보다 inte 성적이 좋아야 한다. 왜냐면 docu 순위는 낮으니까!
                if(grades[i].inte < inte){
                    inte = grades[i].inte;
                    winner++;
                }
            }
            System.out.println(winner);
        }
    }

    static class Grade implements Comparable<Grade>{
        int docu;
        int inte;

        public Grade(int docu, int inte) {
            this.docu = docu;
            this.inte = inte;
        }

        @Override
        public int compareTo(Grade o) {
            return this.docu - o.docu;
        }
    }
}