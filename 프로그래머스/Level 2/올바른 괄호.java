class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(cnt < 0)
                return false;
            if(s.charAt(i)=='(')
                cnt++;
            else
                cnt--;
        }
        if(cnt != 0)
            return false;
        return true;
    }
}