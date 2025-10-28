package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main_1197_prim {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Edge> pq;

    static int V, E, edgeCount;
    static long answer;

    static class Edge implements Comparable<Edge>{
        int end;
        int cost;
        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {return Integer.compare(this.cost, o.cost);}
    }
}
