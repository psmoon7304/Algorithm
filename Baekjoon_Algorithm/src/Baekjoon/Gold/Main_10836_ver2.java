package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10836_ver2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int M, N;
    static int[] map;

    private static void getResult() {
        for(int i = 1; i <= M; i++) {
            sb.append(map[M - i]).append(" ");
            for(int j = M; j < (M + M) - 1; j++) sb.append(map[j]).append(" ");
            sb.append("\n");
        }
    }

    private static void changeNum() throws Exception {
        int value;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int pointer = 0;
            for(int j = 0; j < 3; j++) {
                value = Integer.parseInt(st.nextToken());
                map[pointer] += j;
                pointer += value;
                map[pointer] += -j;
            }
        }

        value = 0;
        for(int i = 0; i < map.length; i++) {
            value += map[i];
            map[i] = value;
        }
        for(int i = 0; i < map.length; i++) map[i] += 1;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M + M];
    }

    public static void main(String[] args) throws Exception {
        init();
        changeNum();
        getResult();
        System.out.print(sb.toString());
    }
}
