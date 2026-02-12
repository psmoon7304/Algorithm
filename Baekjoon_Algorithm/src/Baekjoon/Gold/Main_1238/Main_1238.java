package Baekjoon.Gold.Main_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

public class Main_1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Node> pq;
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] reverseList;
    static int[] dijkMap;
    static int N, M, X;

    private static int[] dijk(ArrayList<Node>[] list, int start) {
        dijkMap = new int[N + 1];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);
        pq.clear();

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
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, w));
            reverseList[e].add(new Node(s, w));
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        int answer = 0;
        int[] dijk = dijk(list, X);
        int[] reverseDijk = dijk(reverseList, X);
        for(int i = 1; i <= N; i++) {
            answer = Math.max(answer, dijk[i] + reverseDijk[i]);
        }
        System.out.print(answer);
    }
}
