package Baekjoon.Silver.Main_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    static int N, M, answer;
    static int[][] map;
    static int[][] visited;
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        Queue<int[]> que = new LinkedList<>();
        visited[0][0] = 1;
        que.offer(new int[] {0,0});
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            if(r == N - 1 && c == M - 1) break;
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!check(nr,nc)) continue;
                if(map[nr][nc] == 1 && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[r][c] + 1;;
                    que.offer(new int[] {nr,nc});
                }
            }
        }
        System.out.println(visited[N-1][M-1]);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >=0 && c < M;
    }
}
