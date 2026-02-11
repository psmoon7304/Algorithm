package Baekjoon.Silver.Main_2583;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2583 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, K, area, count;
    static int[][] map;
    static boolean[][] isVisited;
    static ArrayList<Integer> answer;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean check(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }

    static int dfs(int r, int c, int area) {
        isVisited[r][c] = true;
        map[r][c] = area;
        for(int i = 0; i < 4; i++) {
            int tempR = r + dr[i];
            int tempC = c + dc[i];
            if(!check(tempR,tempC) || isVisited[tempR][tempC] || map[tempR][tempC] == -1) continue;
            count++;
            dfs(tempR,tempC,area);
        }
        return count + 1;
    }

    static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = new ArrayList<>();
        map = new int[M][N];
        isVisited = new boolean[M][N];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int y = M - y1 - 1; y >= M - y2; y--) {
                for(int x = x1; x < x2; x++) {
                    if(map[y][x] == -1) continue;
                    map[y][x] = -1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == -1 || isVisited[i][j]) continue;
                count = 0;
                answer.add(dfs(i, j, ++area));
            }
        }
        System.out.println(area);
        answer.sort(null);
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }
}
