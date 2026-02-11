package Baekjoon.Silver.Main_2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2630 {
    static int N;
    static int blue = 0, white = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int temp = 0;
        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        div(0, 0, N);

        System.out.println(white + "\n" + blue);
    }

    public static void div(int r, int c, int size) {
        if(colorCheck(r,c,size)) {
            if(map[r][c] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        size = size / 2;
        div(r, c, size);
        div(r, c + size, size);
        div(r + size, c, size);
        div(r + size, c + size, size);
    }

    public static boolean colorCheck(int r, int c, int size) {
        int value = map[r][c];

        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(map[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
