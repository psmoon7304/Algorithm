package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {
    static int N, M;
    static int chz;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int cnt = 0, answer = 0;
        do {
            visit = new boolean[N][M];
            answer = chz;
            chz = bfs(0,0);
            cnt++;
        } while(chz != 0);
        System.out.println(cnt - 1);
        System.out.println(answer);
    }

    public static int bfs(int ir, int ic) throws InterruptedException {
        Queue<int[]> que = new LinkedList<>();
        int deleteChz = 0;
        visit[ir][ic] = true;
        que.offer(new int[] {ir,ic});
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            int tempR = temp[0], tempC = temp[1];
            for(int i = 0; i < 4; i++) {
                int r = tempR + dr[i], c = tempC + dc[i];
                if(!check(r,c) || visit[r][c]) continue;
                visit[r][c] = true;
                if(map[r][c] == 1) {
                    deleteChz++;
                    map[r][c] = 0;
                } else {
                    que.offer(new int[] {r,c});
                }
            }
        }
        return deleteChz;
    }

    public static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
