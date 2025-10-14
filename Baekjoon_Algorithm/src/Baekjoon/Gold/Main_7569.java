package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main_7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Deque<int[]> que = new LinkedList<>();

    static int N, M, H;
    static int[][][] map;
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    private static int bfs() {
        int days = 0;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            days = Math.max(days, temp[3]);
            for(int i = 0; i < 6; i++) {
                int r = temp[0] + dr[i];
                int c = temp[1] + dc[i];
                int z = temp[2] + dz[i];
                if(!checked(r, c, z) || map[r][c][z] != 0) continue;
                map[r][c][z] = temp[3] + 1;
                que.offer(new int[] {r, c, z, temp[3] + 1});
            }
        }
        return days - 1;
    }

    private static boolean checked(int r, int c, int z) {
        return r >= 0 && r < N && c >= 0 && c < M && z >= 0 && z < H;
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];

        for(int z = 0; z < H; z++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int j = 0; j < M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j][z] = value;
                    if(value == 1) que.offer(new int[] {i, j, z, 1});
                }
            }
        }
    }

    private static int resultPrint(int days) {
        for(int z = 0; z < H; z++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j][z] == 0) return -1;
                }
            }
        }
        return days;
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(resultPrint(bfs()));
    }
}
