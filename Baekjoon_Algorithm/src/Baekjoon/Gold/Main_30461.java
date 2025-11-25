package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30461 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, Q;
    static int[][] map;

    private static int fishing(int W, int P) {
        return map[W][P];
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 1; j <= M; j++) {
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j] + Integer.parseInt(st.nextToken());
                if(i - 2 < 0) continue;
                map[i][j] -= map[i - 2][j - 1];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine().trim());
            sb.append(fishing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.print(sb.toString());
    }
}
