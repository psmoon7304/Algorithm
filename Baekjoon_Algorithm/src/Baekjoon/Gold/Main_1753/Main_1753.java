package Baekjoon.Gold.Main_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

public class Main_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Node>[] map;
    static PriorityQueue<Node> pq;
    static int[] dijkMap;
    static int V, E, K;

    private static void dijk() {
        dijkMap[K] = 0;
        pq.offer(new Node(K, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int now = n.e;

            if(dijkMap[now] < n.w) continue;

            for(Node temp : map[now]) {
                int nextCost = dijkMap[now] + temp.w;
                if(dijkMap[temp.e] <= nextCost) continue;
                dijkMap[temp.e] = nextCost;
                pq.offer(new Node(temp.e, nextCost));
            }
        }
    }

    private static void getAnswer() {
        for(int i = 1; i <= V; i++) {
            if(dijkMap[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dijkMap[i]);
            sb.append("\n");
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine().trim());

        pq = new PriorityQueue<>();
        map = new ArrayList[V + 1];
        dijkMap = new int[V + 1];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);
        for(int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u].add(new Node(v, w));
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        dijk();
        getAnswer();
        System.out.print(sb.toString());
    }
}
