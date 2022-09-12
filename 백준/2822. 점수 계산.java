package coding_test.Algo20220912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2822_점수계산 {
    final static int EXAM_NUM = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Exam[] scores = new Exam[EXAM_NUM];
        for(int i = 0; i < EXAM_NUM; i++) scores[i] = new Exam(Integer.parseInt(br.readLine()), i + 1);
        Arrays.sort(scores, (o1, o2) -> o2.grade - o1.grade);
        Exam[] success = new Exam[5];
        System.arraycopy(scores, 0, success, 0, 5);
        Arrays.sort(success, (o1, o2) -> o1.idx - o2.idx);
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += success[i].grade;
            sb.append(success[i].idx).append(" ");
        }
        System.out.println(sum);
        System.out.println(sb);
    }

    static class Exam{
        int grade, idx;

        public Exam(int grade, int idx) {
            this.grade = grade;
            this.idx = idx;
        }
    }
}
