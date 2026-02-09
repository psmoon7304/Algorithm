package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, T, D, answer, moveTime;
    static int[][] map;

    private static int changeASCII(char c) {
        if(c <= 'Z') return c - 65;
        return c - 71;
    }

    private static void changeIntMap(char[][] tempMap) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) map[i][j] = changeASCII(tempMap[i][j]);
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        char[][] tempMap = new char[N][M];
        for(int i = 0; i < N; i++) tempMap[i] = br.readLine().toCharArray();
        changeIntMap(tempMap);
    }

    private static void test() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        test();
    }
}
