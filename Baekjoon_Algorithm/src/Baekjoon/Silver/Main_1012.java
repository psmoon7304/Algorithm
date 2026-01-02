package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int TC, M, N, K, fill;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0},
                 dc = {0, 1, 0, -1};

    private static void dfs(int r, int c, int fill) {
        map[r][c] = fill;

        for(int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];
            if(!checked(tr, tc) || map[tr][tc] != 1) continue;
            dfs(tr, tc, fill);
        }
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void runCode() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 1) continue;
                dfs(i, j, ++fill);
            }
        }
        sb.append(fill - 1).append("\n");
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fill = 1;
        map = new int[N][M];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

    }

    public static void main(String[] args) throws Exception {
        TC = Integer.parseInt(br.readLine().trim());
        for(int T = 0; T < TC; T++) {
            init();
            runCode();
        }
        System.out.print(sb.toString());
    }
}
