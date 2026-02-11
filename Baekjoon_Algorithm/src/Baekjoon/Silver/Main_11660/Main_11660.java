package Baekjoon.Silver.Main_11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int N, M;

    private static void runCode() throws Exception {
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            sb.append(map[r2][c2] - map[r1 - 1][c2] - map[r2][c1 - 1] + map[r1 - 1][c1 - 1]).append("\n");
        }
    }

    private static void prefixSum() throws Exception {
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 1; j <= N; j++) {
                map[i][j] = map[i][j - 1] + map[i - 1][j] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        prefixSum();
    }

    public static void main(String[] args) throws Exception {
        init();
        runCode();
        System.out.println(sb.toString());
    }
}
