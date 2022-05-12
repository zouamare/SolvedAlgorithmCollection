class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char c: s.toCharArray()){
            if(c==' '){
                answer += " ";
            }
            else if((Character.isUpperCase(c) && c+n > 90) || (Character.isLowerCase(c) && c+n > 122)){
                answer += Character.toString((c+n)-26);
            }
            else{
                answer += Character.toString(c+n);
            }
        }
        return answer;
    }
}