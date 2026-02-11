package Baekjoon.Silver.Main_3085;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, answer;
    static char[][] map;

    private static void runCode() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(j + 1 < N) {
                    swap(i, j, i, j + 1);
                    checkMax();
                    swap(i, j, i, j + 1);
                }
                if(i + 1 < N) {
                    swap(i, j, i + 1, j);
                    checkMax();
                    swap(i, j, i + 1, j);
                }
            }
        }
    }

    private static void swap(int y1, int x1, int y2, int x2) {
        char temp = map[y1][x1];
        map[y1][x1] = map[y2][x2];
        map[y2][x2] = temp;
    }

    private static void checkMax() {
        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 1; j < N; j++) {
                if(map[i][j] == map[i][j - 1]) {
                    count++;
                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }
            answer = Math.max(answer, count);
        }

        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 1; j < N; j++) {
                if(map[j][i] == map[j - 1][i]) {
                    count++;
                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }
            answer = Math.max(answer, count);
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        map = new char[N][N];
        for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        runCode();
        System.out.print(answer);
    }
}
