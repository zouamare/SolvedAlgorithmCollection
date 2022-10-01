package coding_test.Algo2022년_10월.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 접수 창고, 정비 창고가 나뉘어져 있음
* 우선순위 큐 배열 만들어서 하면 되지 않나?
* 일단 대기 큐 두개를 만듦.
* 접수 대기 : priorityQueue 고객번호 순
* 정비 대기 : priorityQueue 시간 > 접수 번호 순
* */
public class SWEA_2477_차량정비소 {
    static int N, M, K, A, B, completedCustomerCnt;
    static int[] receptionTime, repairTime;
    static Status[] receptionDesk, repairDesk;
    static Customer[] customers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            completedCustomerCnt = 0;

            receptionTime = new int[N];
            repairTime = new int[M];
            receptionDesk = new Status[N];
            repairDesk = new Status[M];
            customers = new Customer[K];
            PriorityQueue<Integer> receptionWait = new PriorityQueue<>();
            PriorityQueue<Status> repairWait = new PriorityQueue<>((o1, o2) -> {
                if(o1.endTime == o2.endTime)    return customers[o1.customerNum].receptionDeskNum - customers[o2.customerNum].receptionDeskNum;
                return o1.endTime - o2.endTime;
            });

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                receptionTime[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                repairTime[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                customers[i] = new Customer(Integer.parseInt(st.nextToken()));
            }

            int time = 0;
            int idx = 0;
            while(!isLastCustomerDone()){
                // wait 상태로 만듦
                while(idx < K && customers[idx].time <= time){
                    receptionWait.add(idx);
                    idx++;
                }

                // reception 상태 -> repair wait 상태
                for (int i = 0; i < N; i++) {
                    if(receptionDesk[i] != null && receptionDesk[i].endTime <= time){
                        int customerNum = receptionDesk[i].customerNum;
                        customers[customerNum].receptionDeskNum = i + 1;
                        repairWait.add(new Status(customerNum, time));
                        receptionDesk[i] = null;
                    }
                }

                // reception wait 상태 -> reception 상태
                for(int i = 0; i < N; i++){
                    if(receptionWait.isEmpty())    break;
                    if(receptionDesk[i] == null){
                        int customerNum = receptionWait.poll();
                        receptionDesk[i] = new Status(customerNum, time + receptionTime[i]);
                    }
                }

                // repair 상태 -> 종료
                for (int i = 0; i < M; i++) {
                    if(repairDesk[i] != null && repairDesk[i].endTime <= time){
                        int customerNum = repairDesk[i].customerNum;
                        customers[customerNum].repairDeskNum = i + 1;
                        repairDesk[i] = null;
                        completedCustomerCnt++;
                    }
                }

                // repair wait 상태 -> repair 상태
                for(int i = 0; i < M; i++){
                    if(repairWait.isEmpty())    break;
                    if(repairDesk[i] == null){
                        int customerNum = repairWait.poll().customerNum;
                        repairDesk[i] = new Status(customerNum, time + repairTime[i]);
                    }
                }

                time++;
            }

            int result = 0; // 결과 합산

            for(int i = 0; i < K; i++){
                if(customers[i].receptionDeskNum == A && customers[i].repairDeskNum == B)   result += i + 1;
            }

            System.out.println("#"+t+" "+(result == 0 ? -1 : result));
        }
    }

    private static boolean isLastCustomerDone() {
        if(completedCustomerCnt != K) return false;
        return true;
    }

    static class Status{
        int customerNum, endTime;

        public Status(int customerNum, int endTime) {
            this.customerNum = customerNum;
            this.endTime = endTime;
        }
    }

    static class Customer{
        int receptionDeskNum, repairDeskNum, time;

        public Customer(int time){
            this.receptionDeskNum = -1;
            this.repairDeskNum = -1;
            this.time = time;
        }

    }
}
