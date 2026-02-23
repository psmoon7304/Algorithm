package Baekjoon.Gold.Main_1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static PriorityQueue<Integer> pq;
    static int N;

    private static int getAnswer() {
        int answer = 0;
        while(!pq.isEmpty()) {
            if(pq.size() == 1) break;
            int num1 = pq.poll();
            int num2 = pq.poll();
            answer += num1 + num2;
            pq.offer(num1 + num2);
        }
        return answer;
    }

    private static void init() throws Exception {
        pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine().trim()));
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.print(getAnswer());
    }
}
