package Baekjoon.Silver.Main_2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
    static int N;
    static int[][] map;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    cnt++;
                    bfs(i,j,cnt+1);
                }
            }
        }
        System.out.println(cnt);
        int[] answer = new int[cnt];
        for(int j = 0; j < N; j++) {
            for(int k = 0; k < N; k++) {
                if(map[j][k] != 0) {
                    answer[map[j][k] - 2]++;
                }
            }
        }
        Arrays.sort(answer);
        for(int i : answer) System.out.println(i);
    }

    private static void bfs(int cr, int cc, int group) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {cr,cc});
        map[cr][cc] = group;
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!check(nr,nc)) continue;
                if(map[nr][nc] == 1) {
                    que.offer(new int[] {nr,nc});
                    map[nr][nc] = group;
                }
            }
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
