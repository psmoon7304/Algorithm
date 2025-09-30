package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int TC, N;
    static int[] playerPos;
    static int[] targetPos;
    static boolean[][] isVisited;
    static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

    static int bfs() {
        Deque<int[]> que = new LinkedList<>();
        que.offer(new int[] {playerPos[0], playerPos[1], 1});
        isVisited[playerPos[0]][playerPos[1]] = true;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for(int i = 0; i < 8; i++) {
                int r = temp[0] + dr[i];
                int c = temp[1] + dc[i];
                if(!checked(r,c) || isVisited[r][c]) continue;
                if(targetPos[0] == r && targetPos[1] == c) return temp[2];
                que.offer(new int[] {r,c,temp[2]+1});
                isVisited[r][c] = true;
            }
        }
        return 0;
    }

    static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void init() throws Exception {
        playerPos = new int[2];
        targetPos = new int[2];
        N = Integer.parseInt(br.readLine().trim());
        isVisited = new boolean[N][N];
        st = new StringTokenizer(br.readLine());
        playerPos[0] = Integer.parseInt(st.nextToken());
        playerPos[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        targetPos[0] = Integer.parseInt(st.nextToken());
        targetPos[1] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        TC = Integer.parseInt(br.readLine().trim());
        for(int testCase = 0; testCase < TC; testCase++) {
            init();
            if(playerPos[0] == targetPos[0] && playerPos[1] == targetPos[1]) sb.append(0);
            else sb.append(bfs());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
