import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;  test_case <= T; test_case++){
            String s = br.readLine();
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!set.add(c)){
                    set.remove(c);
                }
            }
            String result = set.stream().sorted().map(Object::toString).reduce("", String::concat);
            if(result.length() == 0)
                result = "Good";
            System.out.println("#"+test_case+" "+result);
        }
    }
}