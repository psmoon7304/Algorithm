package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Info {
    int deadLine;
    int cup;
    Info(int deadLine, int cup) {
        this.deadLine = deadLine;
        this.cup = cup;
    }
}

public class Main_1781 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Integer> pq;
    static ArrayList<Info> timeLine;
    static int N;

    private static long getAnswer() {
        for(Info info : timeLine) {
            pq.add(info.cup);
            if(pq.size() > info.deadLine) pq.poll();
        }

        long answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        pq = new PriorityQueue<>();
        timeLine = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            timeLine.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(timeLine, (a, b) -> a.deadLine - b.deadLine);
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.print(getAnswer());
    }
}
