package Baekjoon.Gold.Main_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static char[][] map;
    static int[] colorCount;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] isVisited;

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        char value = map[r][c];
        que.offer(new int[] {r,c});
        isVisited[r][c] = true;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for(int i = 0; i < 4; i++) {
                int tempR = temp[0] + dr[i];
                int tempC = temp[1] + dc[i];
                if(!check(tempR, tempC) || map[tempR][tempC] != value || isVisited[tempR][tempC]) continue;
                que.offer(new int[] {tempR, tempC});
                isVisited[tempR][tempC] = true;
            }
        }
        if(value == 'R') colorCount[0]++;
        else if(value == 'G') colorCount[1]++;
        else if(value == 'B') colorCount[2]++;
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine().trim());
        map = new char[N][N];
        colorCount = new int[3]; // 0 R , 1 G , 2 B
        isVisited = new boolean[N][N];
        for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        init();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(isVisited[i][j])  {
                    continue;
                }
                bfs(i,j);
            }
        }
        int answerSum = colorCount[0] + colorCount[1] + colorCount[2];
        sb.append(answerSum).append(" ");
        isVisited = new boolean[N][N];
        colorCount = new int[3];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(isVisited[i][j])  {
                    continue;
                }
                bfs(i,j);
            }
        }
        answerSum = colorCount[1] + colorCount[2];
        sb.append(answerSum);

        System.out.println(sb.toString());
    }

}
