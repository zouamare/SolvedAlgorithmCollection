package coding_test.Algo2022년_11월.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        // stack 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input.equals("."))   break;
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0, size = input.length(); i < size; i++) {
                switch (input.charAt(i)){
                    case '[':
                        stack.add('[');
                        break;
                    case '(':
                        stack.add('(');
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '['){
                            stack.pop();
                        }
                        else{
                            flag = false;
                            break;
                        }
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '('){
                            stack.pop();
                        }
                        else{
                            flag = false;
                            break;
                        }
                        break;
                }
            }
            if(!stack.isEmpty())    flag = false;
            ans.append((flag ? "yes" : "no")).append("\n");
        }
        System.out.println(ans);
    }
}
