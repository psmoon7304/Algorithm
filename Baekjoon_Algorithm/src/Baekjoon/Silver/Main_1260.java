package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1260 {
    static int N, M, V;
    static ArrayList<Integer>[] values;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken()) + 1;
        V = Integer.parseInt(st.nextToken());

        values = new ArrayList[N];
        for(int i = 1; i < N; i++) values[i] = new ArrayList<>();

        for(int i = 1; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            values[r].add(c);
            values[c].add(r);
        }

        for(int i = 1; i < N; i++) values[i].sort(null);

        visited = new boolean[N];
        dfs(V);
        System.out.println();
        visited = new boolean[N];
        bfs(V);
    }

    static void dfs(int pointer) {
        visited[pointer] = true;
        System.out.print(pointer + " ");
        for(int i = 0; i < values[pointer].size(); i++) {
            int temp = values[pointer].get(i);
            if(!visited[temp]) dfs(temp);
        }
    }

    static void bfs(int pointer) {
        Deque<Integer> deque = new ArrayDeque<>();
        visited[pointer] = true;
        deque.offerLast(pointer);
        while(!deque.isEmpty()) {
            int temp = deque.pollFirst();
            System.out.print(temp + " ");
            for(int i = 0; i < values[temp].size(); i++) {
                int tempArray = values[temp].get(i);
                if(!visited[tempArray]) {
                    visited[tempArray] = true;
                    deque.offerLast(tempArray);
                }
            }
        }

    }
}
