package Baekjoon.Gold.Main_4485;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int r, c, cost;
    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main_4485 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static int[][] map;
    static int[] dijkMap;
    static int[] dr = {-1, 0, 1, 0},
            dc = {0, 1, 0, -1};
    static int N, count;

    private static void dijk() {
        dijkMap[0] = map[0][0];
        pq.offer(new Node(0, 0, map[0][0]));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int nR = n.r;
            int nC = n.c;
            int cost = n.cost;

            if(dijkMap[nR * N + nC] < cost) continue;

            for(int i = 0; i < 4; i++) {
                int r = nR + dr[i];
                int c = nC + dc[i];
                if(!check(r, c)) continue;
                int nextCost = dijkMap[nR * N + nC] + map[r][c];
                if(dijkMap[r * N + c] <= nextCost) continue;
                dijkMap[r * N + c] = nextCost;
                pq.offer(new Node(r, c, nextCost));
            }
        }

        stringBuilderAdd(dijkMap[N * N - 1]);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void stringBuilderAdd(int answer) {
        sb.append("Problem ").append(++count).append(": ").append(answer).append("\n");
    }

    private static void init() throws Exception {
        map = new int[N][N];
        dijkMap = new int[N * N];
        pq.clear();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dijkMap[i * N + j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        do {
            N = Integer.parseInt(br.readLine().trim());
            if(N == 0) break;
            init();
            dijk();
        } while(N != 0);
        System.out.print(sb.toString());
    }
}
