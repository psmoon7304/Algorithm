package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10836 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int M, N;
    static int[][] map;

    private static void runCode() throws Exception {
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int pointer = 0, count = 0;
            for(int k = 0; k < 3; k++) {
                int value = Integer.parseInt(st.nextToken());
                for (int j = 0; j < value; j++) {
                    if (pointer < M) map[M - (pointer + 1)][0] += count;
                    else map[0][(pointer + 1) - M] += count;
                    pointer++;
                }
                count++;
            }
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][M];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) map[i][j] = 1;
        }
    }

    private static void getResult() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                if(j == 0) sb.append(map[i][j]).append(" ");
                else sb.append(map[0][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        runCode();
        getResult();
        System.out.print(sb.toString());
    }

}
