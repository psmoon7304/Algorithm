package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14846 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static int[][] map;
    static int[][][] numList;

    private static int getNum(int x1, int y1, int x2, int y2) {
        int count = 0, temp = 0;
        for(int i = 1; i <= 10; i++) {
            temp = numList[i][x2][y2] - numList[i][x2][y1 - 1] - numList[i][x1 - 1][y2] + numList[i][x1 -1][y1 - 1];
            if(temp > 0) count++;
        }
        return count;
    }

    private static void runCode() throws Exception {
        for(int T = 0; T < Q; T++) {
            st = new StringTokenizer(br.readLine().trim());
            sb.append(getNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
    }

    private static void prefixSum() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int mapNum = map[i][j];
                for(int k = 1; k <= 10; k++) numList[k][i][j] = numList[k][i - 1][j] + numList[k][i][j - 1] - numList[k][i - 1][j - 1];
                numList[mapNum][i][j] += 1;
            }
        }
    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        numList = new int[11][N + 1][N + 1];
        prefixSum();
        Q = Integer.parseInt(br.readLine().trim());
    }

    public static void main(String[] args) throws Exception {
        init();
        runCode();
        System.out.print(sb.toString());
    }

}
