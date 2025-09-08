package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2448 {
    static char[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N * 2 - 1];
        for(int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        drawTriangle(N, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void drawTriangle(int n, int r, int c) {
        if(n == 3) {
            map[r][c] = '*';
            map[r + 1][c - 1] = '*';
            map[r + 1][c + 1] = '*';
            for(int i = 0; i < 5; i++) {
                map[r + 2][c - 2 + i] = '*';
            }
            return;
        }

        n /= 2;
        drawTriangle(n, r, c);
        drawTriangle(n, r + n, c - n);
        drawTriangle(n, r + n, c + n);
    }
}
