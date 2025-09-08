package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10993 {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int r = (1<<N) - 1;
        int c = ((1<<N) - 1) * 2 - 1;
        map = new char[r][c];
        for(int i = 0; i < map.length; i++) Arrays.fill(map[i], ' ');

        if(N % 2 == 0) {
            drawTriangle(N, r - 1, c / 2);
        } else {
            drawTriangle(N, 0, c / 2);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void drawTriangle(int n, int r, int c) {
        if(n == 1) {
            map[r][c] = '*';
            return;
        }

        int tempValue = ((1<<n) - 1);
        if(n % 2 == 0) {
            for (int i = 0; i < tempValue; i++) {
                map[r - i][c - i] = '*'; // 왼쪽 대각선
                map[r - i][c + i] = '*'; // 오른쪽 대각선
            }
            for (int i = 0; i < 2 * tempValue - 1; i++) {
                map[r - tempValue + 1][c - (tempValue - 1) + i] = '*'; // 윗변
            }
            int nextR = (r - tempValue + 1) + (1 << (n - 2));
            drawTriangle(n - 1, nextR, c);
        } else {
            for (int i = 0; i < tempValue; i++) {
                map[r + i][c - i] = '*'; // 왼쪽 대각선
                map[r + i][c + i] = '*'; // 오른쪽 대각선
            }
            for (int i = 0; i < 2 * tempValue - 1; i++) {
                map[r + tempValue - 1][c - (tempValue - 1) + i] = '*'; // 밑변
            }
            int nextR = (r + tempValue - 1) - (1 << (n - 2));
            drawTriangle(n - 1, nextR, c);
        }
    }
}
