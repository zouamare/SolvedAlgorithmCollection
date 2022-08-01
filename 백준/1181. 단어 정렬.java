import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();
        for(int i = 0; i < N; i++)
            words.add(br.readLine());
        ArrayList<String> list = (ArrayList<String>) words.stream().collect(Collectors.toList());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                }else{
                    return o1.compareTo(o2);
                }
            }
        });
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}