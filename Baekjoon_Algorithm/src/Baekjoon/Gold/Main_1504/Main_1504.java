package Baekjoon.Gold.Main_1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.ArrayList;

class Node implements Comparable<Node> {
    int e, w;
    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main_1504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list;
    static int N, E, T1, T2;

    private static int[] dijk(int start) {
        int[] dijkMap = new int[N + 1];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);
        int pointer = 0;
        dijkMap[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if(dijkMap[n.e] < n.w) continue;

            for(Node temp : list[n.e]) {
                if(dijkMap[temp.e] < dijkMap[n.e] + temp.w) continue;
                dijkMap[temp.e] = dijkMap[n.e] + temp.w;
                pq.offer(new Node(temp.e, dijkMap[n.e] + temp.w));
            }
        }
        return dijkMap;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine().trim());
        T1 = Integer.parseInt(st.nextToken());
        T2 = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        init();
        int[] dijk = dijk(1);
        int[] dijkT1 = dijk(T1);
        int[] dijkT2 = dijk(T2);
        long minValue = Math.min((long)dijk[T1] + dijkT1[T2] + dijkT2[N], (long)dijk[T2] + dijkT2[T1] + dijkT1[N]);
        System.out.print(minValue >= Integer.MAX_VALUE ? -1 : minValue );
    }
}