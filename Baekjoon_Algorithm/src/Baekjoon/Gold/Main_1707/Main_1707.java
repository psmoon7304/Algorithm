package Baekjoon.Gold.Main_1707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] isVisited;
    static ArrayList<Integer>[] tree;
    static int K, V, E, breakPoint;

    static void dfs(int pointer, int color) { // color 초기 값 : 0 / 색 두가지 : 1, -1;
        if(isVisited[pointer] != 0) return;
        isVisited[pointer] = color;
        ArrayList<Integer> tempTreeValue = tree[pointer];
        for(Integer value : tempTreeValue) {
            if(isVisited[value] == color) {
                breakPoint = 1;
                return;
            }
            dfs(value, color * -1);
        }
    }

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine().trim());

        for(int testCase = 0; testCase < K; testCase++) {
            st = new StringTokenizer(br.readLine().trim());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            isVisited = new int[V + 1];
            tree = new ArrayList[V + 1];
            breakPoint = 0;
            for(int i = 1; i <= V; i++) tree[i] = new ArrayList<>();

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int tempA = Integer.parseInt(st.nextToken());
                int tempB = Integer.parseInt(st.nextToken());

                tree[tempA].add(tempB);
                tree[tempB].add(tempA);
            }
            for(int i = 1; i <= V; i++) {
                dfs(i, 1);
            }
            sb.append(breakPoint == 0?"YES":"NO").append("\n");
        }
        System.out.print(sb.toString());
    }

}
