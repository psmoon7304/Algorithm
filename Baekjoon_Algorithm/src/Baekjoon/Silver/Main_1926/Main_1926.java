package Baekjoon.Silver.Main_1926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, answer, fill, cnt;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void dfs(int r, int c, int fill) {
        map[r][c] = fill;
        for(int i = 0; i < 4; i++) {
            int tempR = r + dr[i];
            int tempC = c + dc[i];
            if(!checked(tempR, tempC) || map[tempR][tempC] != 1) continue;
            cnt++;
            dfs(tempR, tempC, fill);
        }
    }

    static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static void init() throws Exception {
        answer = 0;
        fill = 2;
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    cnt = 1;
                    dfs(i, j, fill++);
                    answer = Math.max(answer, cnt);
                }
            }
        }
        System.out.println((fill - 2) + "\n" + answer);
    }
}
