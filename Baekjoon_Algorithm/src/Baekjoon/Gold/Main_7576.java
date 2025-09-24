package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main_7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, answer = 0;
    static ArrayList<int[]> startPoint;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void bfs() {
        Deque<int[]> que = new LinkedList<>();
        for (int[] ints : startPoint) que.offer(ints);

        while(!que.isEmpty()) {
            int[] tempArray = que.poll();
            for(int i = 0; i < 4; i++) {
                int r = tempArray[0] + dr[i];
                int c = tempArray[1] + dc[i];
                if(!checked(r, c) || map[r][c] != 0) continue;
                map[r][c] = tempArray[2] + 1;
                que.offer(new int[] {r, c, tempArray[2] + 1});
            }
        }
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        startPoint = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1) startPoint.add(new int[] {i, j, 1});
            }
        }

    }

    public static void main(String[] args) throws Exception {
        init();
        bfs();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0)  {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, map[i][j] - 1);
            }
        }
        System.out.println(answer);
    }
}
