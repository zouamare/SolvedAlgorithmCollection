package coding_test.Algo2022년_10월.day24;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1094_막대기 {
    public static void main(String[] args) throws NumberFormatException, IOException {	// 메인 메소드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 위한 BufferedReader br

        int X = Integer.parseInt(br.readLine());	// 입력값
        PriorityQueue<Integer> stickQ = new PriorityQueue<>();	// 내부의 값을 저장할 Prioirty Queue
        stickQ.offer(64);	// 초기값 64
        int sum = 64;	// 총 합 64
        while(sum > X) {	// X보다 sum이 클 경우 반복
            int min = stickQ.poll();	// 제일 작은 값 꺼내옴 (PQ 이므로)
            while(min == 1)	min = stickQ.poll();	// 만약 제일 작은 값이 1이라면 1을 나누면 1보다 작아지므로 다른 작은 것을 가져옴
            min /= 2;	// 최솟값을 2로 나눔
            if(sum - min < X) {	//만약 합 - 최솟값이 X보다 작다면
                stickQ.offer(min);	// 나뉘어진 막대기 두개를 모두 큐에 넣음
                stickQ.offer(min);	// 나뉘어진 막대기 두개를 모두 큐에 넣음
            }
            else {	// 만약 합 - 최솟값이 X보다 크다면
                sum -= min;	// 합에서 min만큼을 뺌
                stickQ.offer(min);	// 남은 한개의 막대기를 큐에 넣음
            }

        }

        System.out.println(stickQ.size());	// 최종 출력
    }
}
