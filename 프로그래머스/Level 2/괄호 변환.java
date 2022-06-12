
class Solution {
    public String solution(String p) {
        return makeCorrectStr(p);
    }

    public String makeCorrectStr(String p){
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환한다.
        if(p.length()==0)
            return "";
        int point = findPoint(p);
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리한다.
        String u = p.substring(0, point);
        String v = p.substring(point);
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행한다.
        if(isCorrectString(u)){
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u+makeCorrectStr(v);
        }
        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        else{
            //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            //  4-3. ')'를 다시 붙입니다.
            //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            //  4-5. 생성된 문자열을 반환합니다.
            return "("+makeCorrectStr(v)+")"+reverseStr(u.substring(1,u.length()-1));
        }
    }

    // String을 뒤집어 주는 method
    private String reverseStr(String s) {
        String answer = "";
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='(')
                answer += ')';
            else
                answer += '(';
        }
        return answer;
    }

    // 균형잡힌 문자열로 나눠줄 수 있는 지점을 반환하는 method
    private int findPoint(String p) {
        int point = 0;
        int cnt = 0;
        for(int i = 0; i<p.length(); i++){
            if(p.charAt(i)=='(')
                cnt++;
            else
                cnt--;
            point = i+1;
            if(cnt==0)
                break;
        }
        return point;
    }

    // 올바른 괄호 문자열인지 확인하는 method
   public boolean isCorrectString(String value){
        int cnt = 0;
        for(int i = 0; i<value.length(); i++){
            if(cnt < 0)
                return false;
            if(value.charAt(i)=='(')
                cnt++;
            else
                cnt--;
        }
        if(cnt == 0)
            return true;
        return false;
    }
}