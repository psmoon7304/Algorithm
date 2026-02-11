package Baekjoon.Gold.Main_17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144 {
    static int R,C,T;
    static int[][] map;
    static int purifier;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        init();
        for(int i = 0; i < T; i++) {
            map = action();
            air();
        }
        answer();
    }

    static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int tempValue = 0;
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                tempValue = Integer.parseInt(st.nextToken());
                if(tempValue == -1 && purifier == 0) purifier = i;
                map[i][j] = tempValue;
            }
        }
    }

    static int[][] action() {
        int[][] tMap = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == -1) {
                    tMap[i][j] = -1;
                    continue;
                }
                if(map[i][j] > 0) {
                    tMap[i][j] += map[i][j];
                    for(int k = 0; k < 4; k++) {
                        int tempR = i + dr[k];
                        int tempC = j + dc[k];
                        if(!check(tempR,tempC) || map[tempR][tempC] == -1) continue;
                        tMap[tempR][tempC] += map[i][j] / 5;
                        tMap[i][j] -= map[i][j] / 5;
                    }
                }
            }
        }
        return tMap;
    }

    static void air() {
        if(purifier - 1 > 0) map[purifier - 1][0] = 0;
        for(int i = purifier - 1; i > 0; i--) {
            map[i][0] = map[i-1][0];
        }
        for(int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for(int i = 0; i < purifier; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for(int i = C - 1; i > 1; i--) {
            map[purifier][i] = map[purifier][i - 1];
        }
        map[purifier][1] = 0;

        if(purifier + 2 < R - 1) map[purifier + 2][0] = 0;
        for(int i = purifier + 2; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for(int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for(int i = R - 1; i > purifier + 1; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for(int i = C - 1; i > 1; i--) {
            map[purifier + 1][i] = map[purifier + 1][i - 1];
        }
        map[purifier + 1][1] = 0;
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static void answer() {
        int answer = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) answer += map[i][j];
        }
        System.out.println(answer + 2);
    }
}
