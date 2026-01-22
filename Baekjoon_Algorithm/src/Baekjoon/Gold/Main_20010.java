package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;


class Node implements Comparable<Node> {
    int start, end, w;

    public Node(int s, int e, int w) {
        this.start = s;
        this.end = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Main_20010 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static int N, K, lastNode, maxAnswer;
    static ArrayList<Node>[] tree;
    static ArrayList<Node>[] list;
    static boolean[] isVisited;

    private static void dfs(int n, int answer) {
        isVisited[n] = true;
        if(answer > maxAnswer) {
            maxAnswer = answer;
            lastNode = n;
        }

        for(Node node : tree[n]) {
            if(isVisited[node.end]) continue;
            dfs(node.end, answer + node.w);
        }
    }

    private static int minCost(Node node) {
        int answer = 0, count = 0;
        pq.offer(node);
        while(!pq.isEmpty()) {
            Node nowNode = pq.poll();
            if(isVisited[nowNode.end]) continue;
            isVisited[nowNode.end] = true;
            answer += nowNode.w;
            count++;
            if(nowNode.start != -1) {
                tree[nowNode.start].add(new Node(nowNode.start, nowNode.end, nowNode.w));
                tree[nowNode.end].add(new Node(nowNode.end, nowNode.start, nowNode.w));
            }
            if(count == N) break;
            for(Node n : list[nowNode.end]) {
                if(!isVisited[n.end]) pq.offer(new Node(nowNode.end, n.end, n.w));
            }
            lastNode = nowNode.end;
        }
        return answer;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N];
        list = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Node(s, e, w));
            list[e].add(new Node(e, s, w));
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        isVisited = new boolean[N];
        sb.append(minCost(new Node(-1,0, 0))).append("\n");

        isVisited = new boolean[N];
        dfs(0, 0);

        isVisited = new boolean[N];
        maxAnswer = 0;
        dfs(lastNode, 0);
        sb.append(maxAnswer).append("\n");

        System.out.print(sb.toString());
    }

}
