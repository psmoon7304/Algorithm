package Baekjoon.Gold.Main_1261;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int e, breakWall;
    public Node(int e, int w) {
        this.e = e;
        this.breakWall = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.breakWall - o.breakWall;
    }
}

public class Main_1261 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int M, N;
    static int[] map;
    static int[] dijkMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void dijk() {
        dijkMap[0] = 0;
        pq.offer(new Node(0, 0));

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if(dijkMap[n.e] < n.breakWall) continue;
            int tempR = n.e / M;
            int tempC = n.e % M;
            for(int i = 0; i < 4; i++) {
                int r = tempR + dr[i];
                int c = tempC + dc[i];
                if(!check(r, c)) continue;

                int index = r * M + c;
                if(dijkMap[index] <= dijkMap[n.e] + map[index]) continue;
                dijkMap[index] = dijkMap[n.e] + map[index];
                pq.offer(new Node(index, dijkMap[n.e] + map[index]));
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N * M];
        dijkMap = new int[N * M];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++) {
            String[] lineInfo = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i * M + j] = Integer.parseInt(lineInfo[j]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        dijk();
        System.out.print(dijkMap[N * M - 1]);
    }
}
