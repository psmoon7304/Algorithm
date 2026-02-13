package Baekjoon.Gold.Main_14938;

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

public class Main_14938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list;
    static int[] dijkMap;
    static int[] item;
    static int N, M, R;

    private static int dijk(int start) {
        dijkMap = new int[N + 1];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);
        pq.clear();
        dijkMap[start] = 0;
        int answer = item[start];
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(dijkMap[node.e] < node.w) continue;
            for(Node temp : list[node.e]) {
                if(dijkMap[temp.e] <= dijkMap[node.e] + temp.w || dijkMap[node.e] + temp.w > M) continue;
                dijkMap[temp.e] = dijkMap[node.e] + temp.w;
                answer += item[temp.e];
                pq.offer(new Node(temp.e, dijkMap[node.e] + temp.w));
            }
        }
        return answer;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        item = new int[N + 1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i <= N; i++) item[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, w));
            list[end].add(new Node(start, w));
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            answer = Math.max(answer, dijk(i));
        }
        System.out.print(answer);
    }
}
