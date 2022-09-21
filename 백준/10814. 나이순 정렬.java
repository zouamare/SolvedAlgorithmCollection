package coding_test.Algo20220921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data[] data = new Data[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i] = new Data(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(data);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(data[i].age).append(" ").append(data[i].name).append("\n");
        }
        System.out.println(sb);
    }

    static class Data implements Comparable<Data>{
        int age, idx;
        String name;

        public Data(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }


        @Override
        public int compareTo(Data o) {
            if(this.age == o.age)   return this.idx - o.idx;
            return this.age - o.age;
        }
    }
}
