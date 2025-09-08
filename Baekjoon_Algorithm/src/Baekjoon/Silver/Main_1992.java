package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] map;

    static void testPrint() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean check(int r, int c, int size) {
        int checkValue = map[r][c];
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(map[i][j] != checkValue) return false;
            }
        }
        return true;
    }

    static void div(int r, int c, int size) { // 분할 정복 시작
        if(check(r, c, size)) { // 한 사분면이 전부 같은 값인지 비교
            if(map[r][c] == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            return;
        }

        // 아니라면 4등분 시작
        sb.append("(");
        size /= 2;
        div(r, c, size);
        div(r, c + size, size);
        div(r + size, c, size);
        div(r + size, c + size, size);
        sb.append(")");
    }

    static void init() throws Exception { // init 초기설정
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }

    static public void main(String[] args) throws Exception {
        init();
        div(0, 0, N);
        System.out.println(sb.toString());
    }
}
