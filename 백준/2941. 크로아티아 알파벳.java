package coding_test.Algo2022년_10월.day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i + 2 < s.length() && s.substring(i, i + 3).equals("dz=")){
                i += 2;
            }
            else if(i + 1 < s.length()){
                switch (s.substring(i, i + 2)){
                    case "c=": case "c-": case "d-": case "s=": case "z=": case "lj": case "nj":
                        i++;
                    break;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
