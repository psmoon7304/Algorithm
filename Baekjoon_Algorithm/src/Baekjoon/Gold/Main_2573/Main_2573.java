package Baekjoon.Gold.Main_2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_2573 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] isVisited;
    static Deque<int[]> mountain = new LinkedList<>();

    private static void bfs(int tr, int tc) {
        Deque<int[]> que = new LinkedList<>();
        isVisited[tr][tc] = true;
        que.offer(new int[] {tr, tc});
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            int zeroCount = 0;
            for(int i = 0; i < 4; i++) {
                int r = temp[0] + dr[i];
                int c = temp[1] + dc[i];
                if(!checked(r, c)) continue;
                if(map[r][c] == 0) zeroCount++;
                if(isVisited[r][c] || map[r][c] == 0) continue;
                isVisited[r][c] = true;
                que.offer(new int[] {r, c});
            }
            mountain.offer(new int[] {temp[0], temp[1], zeroCount});
        }
    }

    private static void sizeChange() {
        while(!mountain.isEmpty()) {
            int[] temp = mountain.poll();
            map[temp[0]][temp[1]] -= temp[2];
            if(map[temp[0]][temp[1]] < 0) map[temp[0]][temp[1]] = 0;
        }
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        int year = 0;
        while(true) {
            int runCheck = 0;
            isVisited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 0 || isVisited[i][j]) continue;
                    if(runCheck > 0) {
                        System.out.print(year);
                        return;
                    }
                    runCheck++;
                    bfs(i, j);
                    sizeChange();
                }
            }
            if(runCheck == 0) {
                System.out.print(0);
                return;
            }
            year++;
        }
    }
}
