package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main_16935 {
    static int N, M, R;
    static int[] actionList;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        actionList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < R; i++) {
            map = action(actionList[i]);
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int[][] action(int type) {
        int[][] tMap;
        int r, c;
        if(type == 3 || type == 4) {
            tMap = new int[map[0].length][map.length];
        } else {
            tMap = new int[map.length][map[0].length];
        }
        int tR = map.length;
        int tC = map[0].length;

        switch (type) {
            case 1:
                for(int i = tR - 1; i >= 0; i--) {
                    for(int j = 0; j < tC; j++) {
                        tMap[tR - (i + 1)][j] = map[i][j];
                    }
                }
                break;
            case 2:
                for(int i = 0; i < tR; i++) {
                    for(int j = tC - 1; j >=0; j--) {
                        tMap[i][tC - (j + 1)] = map[i][j];
                    }
                }
                break;
            case 3:
                for(int i = 0; i < tC; i++) {
                    for(int j = tR - 1; j >= 0; j--) {
                        tMap[i][tR - (j + 1)] = map[j][i];
                    }
                }
                break;
            case 4:
                for(int i = 0; i < tC; i++) {
                    for(int j = tR - 1; j >= 0; j--) {
                        tMap[tC - (i + 1)][j] = map[j][i];
                    }
                }
                break;
            case 5:
                r = tMap.length / 2;
                c = tMap[0].length / 2;
                for(int i = 0; i < r; i++) {
                    for(int j = 0; j < c; j++) {
                        tMap[i][j + c] = map[i][j];
                        tMap[i + r][j + c] = map[i][j + c];
                        tMap[i + r][j] = map[i + r][j + c];
                        tMap[i][j] = map[i + r][j];
                    }
                }
                break;
            default:
                r = tMap.length / 2;
                c = tMap[0].length / 2;
                for(int i = 0; i < r; i++) {
                    for(int j = 0; j < c; j++) {
                        tMap[i][j + c] = map[i + r][j + c];
                        tMap[i + r][j + c] = map[i + r][j];
                        tMap[i + r][j] = map[i][j];
                        tMap[i][j] = map[i][j + c];
                    }
                }
                break;
        }
        return tMap;
    }
}
