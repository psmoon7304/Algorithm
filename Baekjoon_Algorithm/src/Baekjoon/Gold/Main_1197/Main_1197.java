package Baekjoon.Gold.Main_1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E, edgeCount;
    static int[] unionFind;
    static int[] treeSize;
    static long answer;
    static ArrayList<Edge> edge;

    static class Edge implements Comparable<Edge> {
        int start, end;
        int cost;
        Edge(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static int find(int x) {
        if(unionFind[x] == x) return unionFind[x];
        return unionFind[x] = find(unionFind[x]);
    }

    private static void union(int a, int b) {
        int tempA = find(a);
        int tempB = find(b);
        if(tempA == tempB) return;
        if(treeSize[tempA] < treeSize[tempB]) {
            unionFind[tempA] = tempB;
            treeSize[tempB] += treeSize[tempA];
        } else {
            unionFind[tempB] = tempA;
            treeSize[tempA] += treeSize[tempB];
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        unionFind = new int[V + 1];
        treeSize = new int[V + 1];
        edge = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim());
            edge.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i = 1; i <= V; i++) {
            unionFind[i] = i;
            treeSize[i] = 1;
        }

        Collections.sort(edge);

        for(Edge e : edge) {
            if(find(e.start) == find(e.end)) continue;
            union(e.start, e.end);
            answer += e.cost;
            edgeCount++;

            if(edgeCount == V - 1) break;
        }
        System.out.println(answer);
    }
}
