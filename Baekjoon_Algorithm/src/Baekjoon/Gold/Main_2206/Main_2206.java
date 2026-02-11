package Baekjoon.Gold.Main_2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main_2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, answer;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int bfs(int r, int c, int block, int move) {
        Deque<int[]> que = new LinkedList<>();
        isVisited[r][c][0] = true;
        isVisited[r][c][1] = true;
        que.offer(new int[] {r,c,block,move});
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            if(temp[0] == N - 1 && temp[1] == M - 1) return temp[3];
            for(int i = 0; i < 4; i++) {
                int tempR = temp[0] + dr[i];
                int tempC = temp[1] + dc[i];
                if(!checked(tempR,tempC)) continue;
                if(map[tempR][tempC] == 0) {
                    if(!isVisited[tempR][tempC][temp[2]]) {
                        isVisited[tempR][tempC][temp[2]] = true;
                        que.offer(new int[] {tempR, tempC, temp[2], temp[3] + 1});
                    }
                } else if(map[tempR][tempC] == 1){
                    if(temp[2] == 0 && !isVisited[tempR][tempC][1]) {
                        isVisited[tempR][tempC][1] = true;
                        que.offer(new int[] {tempR, tempC, 1, temp[3] + 1});
                    }
                }

            }
        }
        return -1;
    }

    static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws Exception {
        init();
        answer = bfs(0,0,0,1); // r, c, 블럭 파괴 횟수, 이동거리
        System.out.println(answer);
    }
}
