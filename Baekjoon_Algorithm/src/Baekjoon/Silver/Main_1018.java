package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] map;
    static int M, N, answer;

    private static int getResult(int r, int c) {
        int aCount = 0, bCount = 0, pointer = map[r][c] == 'W' ? 1 : -1;
        for(int i = r; i < r + 8; i++) {
            for(int j = c; j < c + 8; j++) {
                if(pointer == 1 && map[i][j] != 'W') aCount++;
                if(pointer == -1 && map[i][j] != 'B') aCount++;
                if(pointer == 1 && map[i][j] == 'W') bCount++;
                if(pointer == -1 && map[i][j] == 'B') bCount++;
                pointer *= -1;
            }
            pointer *= -1;
        }
        return Math.min(aCount, bCount);
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = temp[j].charAt(0);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                answer = Math.min(answer, getResult(i, j));
            }
        }
        System.out.println(answer);
    }
}
