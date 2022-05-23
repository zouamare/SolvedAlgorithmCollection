import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.next();
            String min = find_min_value(s);
            String max = find_max_value(s);
            System.out.println("#"+test_case+" "+min+" "+max);
        }
    }

    private static String find_max_value(String s) {
        StringBuffer sb = new StringBuffer(s);
        int left = 0;
        boolean run = true;
        int right = 0;
        while(run&&left<s.length()){
            for(int i = left+1; i<sb.length(); i++){
                if(left > 0 || sb.charAt(i)!='0'){
                    if(sb.charAt(right)<=sb.charAt(i) && sb.charAt(left)!=sb.charAt(i)){
                        right = i;
                    }
                }
            }
            if(right!=left)
                run = false;
            else{
                left++;
                right++;
            }
        }
        if(left!=right){
            char tmp = sb.charAt(left);
            sb.replace(left,left+1,Character.toString(sb.charAt(right)));
            sb.replace(right, right+1, Character.toString(tmp));
        }

        return sb.toString();
    }

    private static String find_min_value(String s) {
        StringBuffer sb = new StringBuffer(s);

        int left = 0;
        boolean run = true;
        int right = 0;
        while(run && left<s.length()){
            for(int i = left+1; i<sb.length(); i++){
                if(left > 0 || sb.charAt(i)!='0'){
                    if(sb.charAt(right)>=sb.charAt(i) && sb.charAt(left)!=sb.charAt(i)){
                        right = i;
                    }
                }
            }
            if(right!=left)
                run = false;
            else{
                left++;
                right++;
            }

        }
        if(left!=right){
            char tmp = sb.charAt(left);
            sb.replace(left,left+1,Character.toString(sb.charAt(right)));
            sb.replace(right, right+1, Character.toString(tmp));
        }

        return sb.toString();
    }
}