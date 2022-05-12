import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int[] point = new int[3];   // 점수를 담을 배열
        int p = -1; // 배열에서 현재 점수의 위치
        for(int i=0; i<dartResult.length(); i++){   //string의 길이만큼 반복한다.
            char c = dartResult.charAt(i);  //i 인덱스의 char 값을 가져와 저장한다.
            if(Character.isDigit(c)){   //만약 c가 숫자일 경우
                if(c=='1' && dartResult.charAt(i+1)=='0'){  //10의 경우 (10은 1과 0으로 읽히기 때문에 따로 예외처리 함)
                    point[++p] += 10;   // 10을 더하고
                    i++;    //0 부분을 스킵한다.
                }
                else
                    point[++p] += Character.getNumericValue(c); // 그 외에는 0 ~ 9 이므로 바로 저장한다.
            }
            else if(Character.isLetter(c)){ // c가 'S' 거나 'D' 거나 'T' 인 경우,
                int n = 0;
                switch(c){
                    case 'S':
                        n = 1;
                        break;
                    case 'D':
                        n = 2;
                        break;
                    case 'T':
                        n = 3;
                }
                point[p] = (int) Math.pow(point[p],n);    // 현재저장된 값을 n 제곱 하여 저장한다.
            }
            else if(c == '*'){  // c가 '*' 인 경우,
                if(p!=0)   // 첫번째 점수가 아닐 때는
                    point[p-1] *= 2;    // 이전 점수를 *2 한다.
                point[p] *= 2;  // 공통적으로는 현재 점수를 *2 한다.
            }
            else if(c == '#'){  // c가 '#' 인 경우,
                point[p] = -point[p];   // 음수로 변한다.
            }
        }
        return Arrays.stream(point).sum();  //stream()을 이용하여 point 배열의 합을 반환한다.
    }
}