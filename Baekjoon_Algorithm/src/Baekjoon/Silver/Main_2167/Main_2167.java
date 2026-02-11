package Baekjoon.Silver.Main_2167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2167 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;
    static int[][] map;

    private static int getResult() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        return map[r2][c2] - map[r1 -1][c2] - map[r2][c1 - 1] + map[r1 -1][c1 -1];
    }

    private static void prefixSum() throws Exception {
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        prefixSum();

        K = Integer.parseInt(br.readLine().trim());
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < K; i++) sb.append(getResult()).append("\n");
        System.out.println(sb.toString());
    }
}
