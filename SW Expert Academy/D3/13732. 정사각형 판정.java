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
            int N = sc.nextInt();
            int left = 0;   // 정사각형의 좌측 x좌표를 지정할 변수
            int right = N-1;    //정사각형의 우측 x좌표를 지정할 변수
            int height = -1; // 정사각형의 높이를 지정하는 변수 (초기값은 -1로 지정하여 한번이라도 변했는지, 안변했는지 확인가능하게 구현)
            String YorN = "yes";    // 가능여부 저장 변수
            for(int i = 0; i<N; i++){   // 줄마다 읽는다.
                StringBuffer sb = new StringBuffer(sc.next());  // indexOf와 lastIndexOf를 사용하기위해 StringBuffer를 사용
                if(sb.toString().contains("#")){    // '#'이 없으면 계산 X, 하나라도 있어야 계산할 수 있도록 구현
                    int first_index = sb.indexOf("#"); // 현재 입력받은 줄의 첫번째 #의 index
                    int last_index = sb.lastIndexOf("#");    //현재 입력받은 줄의 마지막 #의 index
                    for(int j = first_index; j<last_index; j++){    //first_index ~ last_index searching 시작
                        if(sb.toString().charAt(j)=='.') {  // 중간이 비어있을 경우
                            YorN = "no";    //정사각형이 아님 = 실패처리
                            break;  // for문을 더 돌 필요 없으므로 종료
                        }
                    }
                    if(height==-1 && left==0 && right==N-1){    // 맨 처음 초기상태 setting
                        left = first_index; //인덱스 고정
                        right = last_index; //인덱스 고정
                        height = right - left;  //높이 고정
                    }
                    else if(left!=first_index || right!=last_index){    // 고정된 값이랑 인식된 값이 다를 경우
                        YorN = "no";    //정사각형이 아님 = 실패 처리
                    }
                    else if(YorN.equals("yes"))   // 초기도 아니고, 인식된 인덱스 값이 정상이며 현재까지 인식된 값이 정상일 때 읽은 한 줄만큼 height -1 처리
                        height--;
                    if(height<0){   // height가 0 이하이면 위아래가 긴 직사각형 형태를 띰
                        YorN = "no";    // 정사각형이 아님 = 실패 처리
                    }
                }
            }
            if(height>0)    // 반복문 종료 시에 height가 0 이상이면 좌우가 긴 직사각형 형태를 띰
                YorN = "no";    // 정사각형이 아님 = 실패 처리
            System.out.println("#"+test_case+" "+YorN);
        }
    }
}