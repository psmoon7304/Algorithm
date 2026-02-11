package Baekjoon.Silver.Main_4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int h, w, area;
    static int[][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static boolean check(int r, int c) {
        return r >= 0 && r < h && c >= 0 && c < w;
    }

    static void bfs(int r, int c, int area) {
        Deque<int[]> que = new LinkedList<>();
        que.offer(new int[] {r, c});
        map[r][c] = area;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for(int i = 0; i < 8; i++) {
                int tempR = temp[0] + dr[i];
                int tempC = temp[1] + dc[i];
                if(!check(tempR,tempC) || map[tempR][tempC] != 1) continue;
                que.offer(new int[] {tempR, tempC});
                map[tempR][tempC] = area;
            }
        }
    }

    static int init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        w = Integer.parseInt(st.nextToken()); // 입력 순서가 너비, 높이기 때문에 맞춰서 변수값 받기
        h = Integer.parseInt(st.nextToken());
        area = 0; // bfs의 인자값으로 보내는 경우 area + 1 / area 호출시 섬의 갯수 얻음
        map = new int[h][w];
        for(int i = 0; i < h; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return h + w;
    }

    public static void main(String[] args) throws Exception {
        while(init() != 0) {
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] != 1) continue;
                    area++;
                    bfs(i, j, area + 1);
                }
            }
            System.out.println(area);
        }
    }
}
