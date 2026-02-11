package Baekjoon.Gold.Main_14497;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Deque;

public class Main_14497 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Deque<int[]> que;

    static int N, M;
    static int[] playerPos = new int[2];
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static int actionJump(int px, int py) {
        que = new LinkedList<>();
        isVisited[px][py] = true;
        que.offer(new int[]{px, py, 1});

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int tempR = temp[0];
            int tempC = temp[1];
            for (int i = 0; i < 4; i++) {
                int r = tempR + dr[i];
                int c = tempC + dc[i];
                if (!checked(r, c) || isVisited[r][c]) continue;
                isVisited[r][c] = true;
                if (map[r][c] == '#') return temp[2];
                else if (map[r][c] == '1') {
                    map[r][c] = '0';
                    que.offer(new int[]{r, c, temp[2] + 1});
                    continue;
                }
                que.addFirst(new int[]{r, c, temp[2]});
            }
        }
        return 0;
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M];

        String[] temp = br.readLine().split(" ");
        playerPos[0] = Integer.parseInt(temp[0]) - 1;
        playerPos[1] = Integer.parseInt(temp[1]) - 1;
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.print(actionJump(playerPos[0], playerPos[1]));
    }

}