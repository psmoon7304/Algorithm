package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int answer = 0;
    static int[] dr ={-1, -1, 0, 1, 1, 1, 0, -1},
                dc ={0, -1, -1 ,-1, 0 , 1, 1, 1};

    private static void dfs(int sr, int sc, int sDir, int score, int[][] map, int[][] fish) {
        answer = Math.max(answer, score);

        int[][] curMap = new int[4][4];
        int[][] curFish = new int[17][3];

        for(int i = 0; i < 4; i++) curMap[i] = map[i].clone();
        for(int i = 1; i <= 16; i++) curFish[i] = fish[i].clone();

        moveFish(curMap, curFish, sr, sc);

        for (int step = 1; step <= 3; step++) {
            int nr = sr + dr[sDir] * step;
            int nc = sc + dc[sDir] * step;
            if (!checked(nr, nc)) break;

            if (curMap[nr][nc] == 0) continue;

            int fishId = curMap[nr][nc];
            int nextScore = score + fishId;
            int nextDir = curFish[fishId][2];

            curMap[nr][nc] = -1;
            curMap[sr][sc] = 0;
            curFish[fishId][0] = -1;
            dfs(nr, nc, nextDir, nextScore, curMap, curFish);

            curMap[nr][nc] = fishId;
            curMap[sr][sc] = -1;
            curFish[fishId][0] = nr;
        }

    }

    private static void moveFish(int[][] map, int[][] fish, int sr, int sc) {
        for (int i = 1; i <= 16; i++) {
            if (fish[i][0] == -1) continue;

            int r = fish[i][0];
            int c = fish[i][1];
            int dir = fish[i][2];

            for (int d = 0; d < 8; d++) {
                int nd = (dir + d) % 8;
                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if (checked(nr, nc) && !(nr == sr && nc == sc)) {
                    fish[i][2] = nd;
                    int targetId = map[nr][nc];
                    map[r][c] = targetId;
                    map[nr][nc] = i;
                    fish[i][0] = nr;
                    fish[i][1] = nc;
                    if (targetId != 0) {
                        fish[targetId][0] = r;
                        fish[targetId][1] = c;
                    }
                    break;
                }
            }
        }
    }
    
    private static boolean checked(int r, int c) {
        return r >= 0 && r < 4 && c >= 0 && c < 4;
    }

    public static void main(String[] args) throws Exception {
        int[][] map = new int[4][4];
        int[][] fish = new int[17][3];

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                fish[map[i][j]] = new int[] {i, j, Integer.parseInt(st.nextToken()) - 1};
            }
        }

        int fishId = map[0][0];
        int sharkDir = fish[fishId][2];
        fish[fishId][0] = -1;
        map[0][0] = -1;
        dfs(0, 0, sharkDir, fishId, map, fish);
        System.out.print(answer);
    }
}
