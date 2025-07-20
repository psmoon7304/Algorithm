package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int[][] plusDirs = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        int[][] xDirs = { {-1,-1}, {-1,1}, {1,-1}, {1,1} };

        for (int tc = 1; tc <= testCase; tc++) {
            int[] sprayInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int N = sprayInfo[0];
            int M = sprayInfo[1];
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int maxValue = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int plusKill = map[i][j];
                    int xKill = map[i][j];

                    for (int[] dir : plusDirs) {
                        for (int m = 1; m < M; m++) {
                            int ni = i + dir[0] * m;
                            int nj = j + dir[1] * m;
                            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                                plusKill += map[ni][nj];
                            }
                        }
                    }

                    for (int[] dir : xDirs) {
                        for (int m = 1; m < M; m++) {
                            int ni = i + dir[0] * m;
                            int nj = j + dir[1] * m;
                            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                                xKill += map[ni][nj];
                            }
                        }
                    }

                    maxValue = Math.max(maxValue, Math.max(plusKill, xKill));
                }
            }

            System.out.println("#" + tc + " " + maxValue);
        }
    }
}
