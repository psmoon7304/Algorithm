package Baekjoon.Silver.Main_2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, answer, tempValue, maxHeight;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static int bfs(int r, int c, int waterHeight) {
        Deque<int[]> que = new LinkedList<>();
        que.offer(new int[] {r,c});
        isVisited[r][c] = true;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for(int i = 0; i < 4; i++) {
                int tempR = temp[0] + dr[i];
                int tempC = temp[1] + dc[i];
                if(!check(tempR, tempC) || map[tempR][tempC] <= waterHeight || isVisited[tempR][tempC]) continue;
                que.offer(new int[] {tempR, tempC});
                isVisited[tempR][tempC] = true;
            }
        }
        return 1;
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, temp);
                map[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int loop = 0; loop < maxHeight + 1; loop++) {
            tempValue = 0;
            isVisited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] <= loop || isVisited[i][j]) continue;
                    tempValue += bfs(i, j, loop);
                }
            }
            answer = Math.max(tempValue, answer);
        }
        System.out.println(answer);
    }
}
