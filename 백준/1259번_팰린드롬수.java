import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            String input;
            try {
                input = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(input.equals("0"))
                break;

            char[] arr = input.toCharArray();

            boolean correct = true;
            int left = 0;
            int right = arr.length - 1;
            while(left<=right && arr.length>1){
                if(left==right){
                    correct = true;
                    break;
                }
                if(arr[left]==arr[right]){
                    left++;
                    right--;

                }else{
                    correct = false;
                    break;
                }
            }
            if(correct)
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
        }
        System.out.println(sb);
    }
}
