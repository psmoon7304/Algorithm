package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Road implements Comparable<Road> {
    int e, w;
    Road(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Road r) {
        return this.w - r.w;
    }
}

public class Main_1446 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Road> pq = new PriorityQueue<>();

    static ArrayList<Road>[] graph;
    static int[] dist;
    static int N, D;

    private static void dijk() {
        dist[0] = 0;
        pq.offer(new Road(0, 0));
        while (!pq.isEmpty()) {
            Road curr = pq.poll();
            int now = curr.e;
            int dis = curr.w;

            if (dist[now] < dis) continue;

            for (Road next : graph[now]) {
                int nextCost = dist[now] + next.w;
                if (nextCost < dist[next.e]) {
                    dist[next.e] = nextCost;
                    pq.offer(new Road(next.e, nextCost));
                }
            }
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[D + 1];
        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < D; i++) {
            graph[i].add(new Road(i + 1, 1));
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(e <= D && e - s > w) {
                graph[s].add(new Road(e, w));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        dijk();
        System.out.print(dist[D]);
    }
}
