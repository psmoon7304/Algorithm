package Baekjoon.Gold.Main_1916;

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

public class Main_1916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Node> pq;

    static ArrayList<Node>[] list;
    static int[] dijkMap;

    static int N, M, A, B;

    static void dijk() {
        dijkMap[A] = 0;
        pq.offer(new Node(A, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if(dijkMap[n.e] < n.w) continue;
            if(n.e == B) return;
            for(Node temp : list[n.e]) {
                if(dijkMap[temp.e] <= n.w + temp.w) continue;
                dijkMap[temp.e] = n.w + temp.w;
                pq.offer(new Node(temp.e, n.w + temp.w));
            }
        }
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());

        pq = new PriorityQueue<>();
        list = new ArrayList[N + 1];
        dijkMap = new int[N + 1];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, w));
        }
        st = new StringTokenizer(br.readLine().trim());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        init();
        dijk();
        System.out.print(dijkMap[B]);
    }
}
