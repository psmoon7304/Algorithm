package Baekjoon.Gold.Main_11779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

class Node implements Comparable<Node> {
    int e, w;
    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main_11779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] map;
    static int[] dijkMap;
    static int[] course;
    static int N, M, A, B;

    private static void dijk() {
        dijkMap[A] = 0;
        pq.offer(new Node(A, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(dijkMap[node.e] < node.w) continue;
            if(node.e == B) return;

            for(Node temp : map[node.e]) {
                if(dijkMap[temp.e] <= dijkMap[node.e] + temp.w) continue;
                dijkMap[temp.e] = dijkMap[node.e] + temp.w;
                course[temp.e] = node.e;
                pq.offer(new Node(temp.e, dijkMap[node.e] + temp.w));
            }
        }
    }

    private static void getAnswer() {
        int curr = B;
        Stack<Integer> path = new Stack<>();
        while(curr != 0) {
            path.push(curr);
            curr = course[curr];
        }
        sb.append(dijkMap[B]).append("\n").append(path.size()).append("\n");
        while(!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }

    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());

        map = new ArrayList[N + 1];
        dijkMap = new int[N + 1];
        course = new int[N + 1];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start].add(new Node(end, cost));
        }
        st = new StringTokenizer(br.readLine().trim());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        init();
        dijk();
        getAnswer();
        System.out.print(sb.toString());
    }
}
