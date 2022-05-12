import java.util.*;
class Solution {
    public String solution(String s) {
        char[] x = s.toCharArray();
        Arrays.sort(x);
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        return sb.toString();
    }
}