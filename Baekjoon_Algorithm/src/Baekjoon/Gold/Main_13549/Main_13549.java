package Baekjoon.Gold.Main_13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_13549 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static final int MAX = 100000;
    static boolean[] isVisited;

    private static int bfs(int X, int time) {
        Deque<int[]> que = new LinkedList<>();
        que.offer(new int[] {X, time});

        while(!que.isEmpty()) {
            int[] temp = que.poll();
            isVisited[temp[0]] = true;
            if(temp[0] == K) return temp[1];
            if(temp[0] * 2 <= MAX && !isVisited[temp[0] * 2 ]) que.addFirst(new int[] {2 * temp[0], temp[1]});
            if(temp[0] - 1 >= 0 && !isVisited[temp[0] - 1]) que.offer(new int[] {temp[0] - 1, temp[1] + 1});
            if(temp[0] + 1 <= MAX && !isVisited[temp[0] + 1]) que.offer(new int[] {temp[0] + 1, temp[1] + 1});
        }
        return 0;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisited = new boolean[MAX + 1];
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.print(bfs(N, 0));
    }
}
