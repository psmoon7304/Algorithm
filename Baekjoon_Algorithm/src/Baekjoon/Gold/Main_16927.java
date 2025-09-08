package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16927 {
    static int[][] map;
    static int turn;
    static int N, M;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        init();
        for(int i = 0; i < Math.min(N,M) / 2; i++) {
            int R = (turn % ((N - (2 * i)+M - (2 * i)) * 2 - 4));
            for(int j = 0; j < R; j++) {
                tryTurn(i,i);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        turn = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void tryTurn(int r, int c) {
        int nowR = r, nowC = c;
        int tempNum = map[r][c];
        for(int i = 0; i < 4; i++) {
            int tempR = nowR + dr[i], tempC = nowC + dc[i];
            while(check(tempR, tempC) && rangeCheck(tempR, tempC, r)) {
                if(tempR == r && tempC == c) {
                    map[nowR][nowC] = tempNum;
                    break;
                }
                map[nowR][nowC] = map[tempR][tempC];
                nowR = tempR;
                nowC = tempC;
                tempR = nowR + dr[i];
                tempC = nowC + dc[i];
            }
        }

    }

    public static boolean rangeCheck(int r, int c, int check) {
        return r > check - 1 && c > check - 1 && r <= N - (1 + check) && c <= M - (1 + check);
    }

    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}