package Baekjoon.Silver.Main_18352;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Node implements Comparable<Node> {
    int e, w;
    Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }

}

public class Main_18352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list;
    static int[] dist;
    static int N, M, K, X;

    private static void dijk() {
        dist[X] = 0;
        pq.add(new Node(X, 0));

        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            int now = temp.e;
            int w = temp.w;

            if(dist[now] < w) continue;

            for(Node n : list[now]) {
                int nextW = dist[now] + n.w;
                if(nextW < dist[n.e]) {
                    dist[n.e] = nextW;
                    pq.add(new Node(n.e, nextW));
                }
            }
        }
    }

    private static void getAnswer() {
        for(int i = 1; i <= N; i++) {
            if(dist[i] != K) continue;
            sb.append(i).append("\n");
        }
        if(sb.length() == 0) sb.append(-1);
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 2];
        dist = new int[N + 2];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, 1));
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        dijk();
        getAnswer();
        System.out.print(sb.toString());
    }
}
