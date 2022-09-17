package coding_test.Algo20220917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int cnt = 0;
        String key = null;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > cnt){
                cnt = entry.getValue();
                key = entry.getKey();
            }else if(entry.getValue() == cnt && key.compareTo(entry.getKey()) > 0) {
                key = entry.getKey();
            }
        }

        System.out.println(key);
    }
}
