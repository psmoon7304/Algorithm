package Baekjoon.Gold.Main_1486;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
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

public class Main_1486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Node> pq;

    static int[] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M, T, D;

    private static int[] dijk(int start, boolean isReverse) {
        int[] dijkMap = new int[N * M + 1];
        Arrays.fill(dijkMap, Integer.MAX_VALUE);
        dijkMap[start] = 0;
        pq.clear();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(dijkMap[node.e] < node.w) continue;

            int tempR = node.e / M;
            int tempC = node.e % M;
            for(int i = 0; i < 4; i++) {
                int r = tempR + dr[i];
                int c = tempC + dc[i];
                int nextCost = 1;
                if(!check(r, c) || Math.abs(map[node.e] - map[r * M + c]) > T) continue;
                if(isReverse) {
                    if(map[node.e] <= map[r * M + c]) nextCost = 1;
                    else nextCost = (int)Math.pow(map[node.e] - map[r * M + c], 2);
                } else {
                    if(map[node.e] >= map[r * M + c]) nextCost = 1;
                    else nextCost = (int)Math.pow(map[r * M + c] - map[node.e], 2);
                }

                if(dijkMap[r * M + c] <= dijkMap[node.e] + nextCost) continue;
                dijkMap[r * M + c] = dijkMap[node.e] + nextCost;
                pq.offer(new Node(r * M + c, dijkMap[node.e] + nextCost));
            }
        }
        return dijkMap;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static int changeASCII(char c) {
        if(c <= 'Z') {
            return c - 65;
        }
        return c - 71;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        map = new int[N * M];

        for(int i = 0; i < N ; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i * M + j] = changeASCII(input[j]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        int[] startDijk = dijk(0, false);
        int[] reverseDijk = dijk(0, true);
        int answer = 0;
        for(int i = 0; i < N * M; i++) {
            if(startDijk[i] != Integer.MAX_VALUE && reverseDijk[i] != Integer.MAX_VALUE) {
                long temp = startDijk[i] + reverseDijk[i];
                if(temp > D) continue;
                answer = Math.max(answer, map[i]);
            }
        }
        System.out.print(answer);
    }
}
