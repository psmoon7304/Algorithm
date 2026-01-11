package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, safeZone = -3, answer;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] isVisited;
    static Deque<int[]> virusPos = new LinkedList<>();

    private static void buildWall() {
        for(int i = 0; i < N * M; i++) {
            if(map[i / M][i % M] != 0) continue;
            map[i / M][i % M] = 1;
            for(int j = i + 1; j < N * M; j++) {
                if(map[j / M][j % M] != 0) continue;
                map[j / M][j % M] = 1;
                for(int k = j + 1; k < N * M; k++) {
                    if(map[k / M][k % M] != 0) continue;
                    map[k / M][k % M] = 1;
                    answer = Math.max(answer,virusDiffuse());
                    map[k / M][k % M] = 0;
                }
                map[j / M][j % M] = 0;
            }
            map[i / M][i % M] = 0;
        }
    }

    private static int virusDiffuse() {
        int count = 0;
        isVisited = new boolean[N][M];
        Deque<int[]> que = new LinkedList<>(virusPos);

        while(!que.isEmpty()) {
            int temp[] = que.poll();
            int tempR = temp[0];
            int tempC = temp[1];
            count++;
            isVisited[tempR][tempC] = true;
            for(int i = 0 ; i < 4; i++) {
                int r = tempR + dr[i];
                int c = tempC + dc[i];
                if(!checked(r, c) || map[r][c] != 0 || isVisited[r][c]) continue;
                isVisited[r][c] = true;
                que.offer(new int[] {r, c});
            }
        }
        return safeZone - (count - virusPos.size());
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 2) virusPos.offer(new int[] {i, j});
                else if(num == 0) safeZone++;
                map[i][j] = num;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        buildWall();
        System.out.print(answer);
    }
}
