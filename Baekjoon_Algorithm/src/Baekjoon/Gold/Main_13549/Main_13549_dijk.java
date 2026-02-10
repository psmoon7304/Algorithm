package Baekjoon.Gold.Main_13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Node implements Comparable<Node> {
    int pos, time;
    Node(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}

public class Main_13549_dijk {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] dis;
    static int N, K;

    private static void dijk() {
        dis[N] = 0;
        pq.add(new Node(N, 0));

        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            int now = temp.pos;
            int time = temp.time;

            if(dis[now] < time) continue;
            dis[now] = time;
            if(now == K) return;

            if(now * 2 <= 100_000 && dis[now * 2] > time) pq.add(new Node(now * 2, time));
            if(now + 1 <= 100_000 && dis[now + 1] > time + 1) pq.add(new Node(now + 1, time + 1));
            if(now - 1 >= 0 && dis[now - 1] > time + 1) pq.add(new Node(now - 1, time + 1));
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dis = new int[100_001];
        Arrays.fill(dis, Integer.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        init();
        dijk();
        System.out.print(dis[K]);
    }
}
