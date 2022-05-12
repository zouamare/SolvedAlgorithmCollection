class Solution {
    public int solution(int n) {
        String base3 = "";
        while(n>0){
            if(n<3){
                base3 = Integer.toString(n) + base3;
                break;
            }
            base3 = Integer.toString(n%3) + base3;
            n /= 3;
        }
        StringBuffer sb = new StringBuffer(base3);
        base3 = sb.reverse().toString();
        int result = 0;
        int num = base3.length()-1;
        for(int i=0; i<base3.length(); i++){
            if(base3.charAt(i)=='0'){
                num--;
                continue;
            }
            result += Character.getNumericValue(base3.charAt(i))*Math.pow(3,num--);
        }
        return result;
    }
}