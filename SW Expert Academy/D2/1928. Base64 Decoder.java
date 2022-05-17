import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,Integer> hm = makeHashMap();
        int T = sc.nextInt();
        for(int test_case = 1; test_case<=T; test_case++){
            String input_str = sc.next();
            String output_str = "";
            ByteBuffer bb = ByteBuffer.allocate(3);
            for(int i=0; i<input_str.length(); i+=4){
                String tmp = "";
                tmp += String.format("%06d",Integer.parseInt(Integer.toBinaryString(hm.get(input_str.charAt(i)))));
                tmp += String.format("%06d",Integer.parseInt(Integer.toBinaryString(hm.get(input_str.charAt(i+1)))));
                tmp += String.format("%06d",Integer.parseInt(Integer.toBinaryString(hm.get(input_str.charAt(i+2)))));
                tmp += String.format("%06d",Integer.parseInt(Integer.toBinaryString(hm.get(input_str.charAt(i+3)))));
                output_str += (char) Integer.parseInt(tmp.substring(0,8),2);
                output_str += (char) Integer.parseInt(tmp.substring(8,16),2);
                output_str += (char) Integer.parseInt(tmp.substring(16,24),2);
            }
            System.out.println("#"+test_case+" "+output_str);
        }
    }

    private static HashMap<Character, Integer> makeHashMap() {
        HashMap<Character, Integer> hm = new HashMap<>();
        //대문자
        hm.put('A',0);
        hm.put('B',1);
        hm.put('C',2);
        hm.put('D',3);
        hm.put('E',4);
        hm.put('F',5);
        hm.put('G',6);
        hm.put('H',7);
        hm.put('I',8);
        hm.put('J',9);
        hm.put('K',10);
        hm.put('L',11);
        hm.put('M',12);
        hm.put('N',13);
        hm.put('O',14);
        hm.put('P',15);
        hm.put('Q',16);
        hm.put('R',17);
        hm.put('S',18);
        hm.put('T',19);
        hm.put('U',20);
        hm.put('V',21);
        hm.put('W',22);
        hm.put('X',23);
        hm.put('Y',24);
        hm.put('Z',25);
        //소문자
        hm.put('a',26);
        hm.put('b',27);
        hm.put('c',28);
        hm.put('d',29);
        hm.put('e',30);
        hm.put('f',31);
        hm.put('g',32);
        hm.put('h',33);
        hm.put('i',34);
        hm.put('j',35);
        hm.put('k',36);
        hm.put('l',37);
        hm.put('m',38);
        hm.put('n',39);
        hm.put('o',40);
        hm.put('p',41);
        hm.put('q',42);
        hm.put('r',43);
        hm.put('s',44);
        hm.put('t',45);
        hm.put('u',46);
        hm.put('v',47);
        hm.put('w',48);
        hm.put('x',49);
        hm.put('y',50);
        hm.put('z',51);
        //숫자
        hm.put('0',52);
        hm.put('1',53);
        hm.put('2',54);
        hm.put('3',55);
        hm.put('4',56);
        hm.put('5',57);
        hm.put('6',58);
        hm.put('7',59);
        hm.put('8',60);
        hm.put('9',61);
        //특수문자
        hm.put('+',62);
        hm.put('/',63);

        return hm;
    }
}