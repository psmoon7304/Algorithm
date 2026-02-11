package Baekjoon.Gold.Main_2589;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_2589 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Deque<int[]> que;

    static int mapR, mapC;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] isVisited;
    static int answer;

    private static int bfs(int[] startPos) {
        isVisited = new boolean[mapR][mapC];
        int[] pos = new int[3];
        que = new LinkedList<>();
        que.offer(new int[] {startPos[0], startPos[1], 0});
        isVisited[startPos[0]][startPos[1]] = true;

        while(!que.isEmpty()) {
            pos = que.poll();
            int tempR = pos[0], tempC = pos[1];
            for(int i = 0; i < 4; i++) {
                int r = tempR + dr[i];
                int c = tempC + dc[i];
                if(!checked(r, c) || isVisited[r][c] || map[r][c] == 'W') continue;
                que.offer(new int[] {r, c, pos[2] + 1});
                isVisited[r][c] = true;
            }
        }
        return pos[2];
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < mapR && c >= 0 && c < mapC;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        mapR = Integer.parseInt(st.nextToken());
        mapC = Integer.parseInt(st.nextToken());

        map = new char[mapR][mapC];
        answer = 0;

        for(int i = 0; i < mapR; i++) map[i] = br.readLine().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < mapR; i++) {
            for(int j = 0; j < mapC; j++) {
                if(map[i][j] == 'W') continue;
                answer = Math.max(answer, bfs(new int[] {i, j}));
            }
        }
        System.out.print(answer);
    }
}
