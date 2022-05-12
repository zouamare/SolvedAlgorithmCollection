import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num_of_water = sc.nextInt();
        int tape_length = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<num_of_water; i++){
            list.add(Integer.parseInt(sc.next()));
        }

        Collections.sort(list);

        int tape = tape_length;
        int cnt = 1;

        for(int i =1; i<list.size(); i++){
            if(list.get(i)-list.get(i-1) < tape){
                tape -= list.get(i)-list.get(i-1);
            }
            else{
                cnt++;
                tape = tape_length;
            }
        }

        System.out.println(cnt);
    }
}
