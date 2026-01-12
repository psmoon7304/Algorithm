package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Deque;

public class Main_14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, answer;
    static int[] robotPos;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void getResult(int r, int c, int d) {

    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        robotPos = new int[3];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < 3; i++) robotPos[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        getResult(robotPos[0], robotPos[1], robotPos[2]);
        System.out.print(answer);
    }
}
