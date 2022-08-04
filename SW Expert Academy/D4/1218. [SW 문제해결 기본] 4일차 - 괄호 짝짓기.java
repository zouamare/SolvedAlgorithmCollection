package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
    static Map<Character, Character> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        map = new HashMap<>();
        mapInit();
        for(int t = 1; t <= T; t++){
            Stack<Character> stack = new Stack<>();
            int L = Integer.parseInt(br.readLine());
            String s = br.readLine();
            boolean valid = true;
            for(int i = 0; i < L; i++){
                if(!valid)  break;
                char c = s.charAt(i);
                if(c == ')' || c == '>' || c == ']' || c == '}'){
                    if(stack.peek() == map.get(c))
                        stack.pop();
                    else
                        valid = false;
                }else{
                    stack.add(c);
                }
            }
            System.out.println("#"+t+" "+( valid ? 1 : 0 ));
        }
    }

    private static void mapInit() {
        map.put(')','(');
        map.put('>','<');
        map.put(']','[');
        map.put('}','{');
    }
}
