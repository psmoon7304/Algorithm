package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K, sN, sM, answer, blockSize;
    static int[][] map, sMap;

    static void turn(int type) {
        int[][] tempMap = new int[sM][sN];
        for(int i = 0; i < tempMap.length; i++) {
            for(int j = tempMap[i].length - 1; j >= 0; j--) {
                tempMap[i][tempMap[i].length - (j + 1)] = sMap[j][i];
            }
        }
        sN = tempMap.length;
        sM = tempMap[0].length;
        sMap = tempMap;
    }

    static boolean check(int r, int c) {
        for(int i = 0; i < sN; i++) {
            for(int j = 0; j < sM; j++) if(sMap[i][j] == 1 && map[i + r][j + c] == 1) return false;
        }
        return true;
    }

    static void put(int r, int c) {
        for(int i = 0; i < sN; i++) {
            for(int j = 0; j < sM; j++) {
                if(sMap[i][j] != 1) continue;
                map[i + r][j + c] = sMap[i][j];
            }
        }
    }

    static void search() {
        for(int k = 0; k < 4; k++) {
            for (int i = 0; i <= (N - sN); i++) {
                for (int j = 0; j <= (M - sM); j++) {
                    if(map[i][j] == 1 && sMap[0][0] == 1) continue;
                    if(check(i, j)) {
                        put(i, j);
                        answer += blockSize;
                        return;
                    }
                }
            }
            turn(k);
        }
    }

    static void setting() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        sN = Integer.parseInt(st.nextToken());
        sM = Integer.parseInt(st.nextToken());
        sMap = new int[sN][sM];
        blockSize = 0;
        for(int i = 0; i < sN; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < sM; j++) {
                if(Integer.parseInt(st.nextToken()) == 0) continue;
                sMap[i][j] = 1;
                blockSize++;
            }
        }
    }

    static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < K; i++) {
            setting();
            search();
        }
        System.out.println(answer);
    }
}