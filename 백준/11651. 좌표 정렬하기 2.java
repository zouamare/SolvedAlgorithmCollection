package coding_test.Algo2022년_11월.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// lambda를 이용하여 배열 정렬 후 출력
public class BOJ_11651_좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[n] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points, (o1, o2) -> {
            if(o1.y == o2. y)   return o1.x -o2.x;
            return o1.y - o2.y;
        });

        StringBuilder ans = new StringBuilder();
        for (Point point : points) {
            ans.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(ans);
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
