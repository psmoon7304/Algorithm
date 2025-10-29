package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;


public class Main_20058 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Deque<int[]> que;
    static int N, Q, sum, high, tempHigh;
    static boolean[][] isVisited;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void rotate(int L) {
        int[][] tempMap = new int[(1<<N)][(1<<N)];

        for(int mapI = 0; mapI < (1<<N); mapI += (1<<L)) {
            for(int mapJ = 0; mapJ < (1<<N); mapJ += (1<<L)) {
                for(int i = mapI; i < mapI + (1<<L); i++) {
                    for(int j = mapJ; j < mapJ + (1<<L); j++) {
                        tempMap[mapI + (j - mapJ)][mapJ + ((1<<L) - 1 - (i - mapI))] = map[i][j];
                    }
                }
            }
        }
        map = tempMap;
    }

    private static void searchIce() {
        for(int i = 0; i < (1<<N); i++) {
            for(int j = 0; j < (1<<N); j++) {
                int iceCount = 0;
                for(int k = 0; k < 4; k++) {
                    int tempR = i + dr[k];
                    int tempC = j + dc[k];
                    if(!checked(tempR, tempC) || map[tempR][tempC] == 0) continue;
                    iceCount++;
                }
                if(iceCount < 3) que.offer(new int[] {i, j});
            }
        }
    }

    private static void changeIce() {
        while(!que.isEmpty()) {
            int[] pos = que.poll();
            if(map[pos[0]][pos[1]] > 0) map[pos[0]][pos[1]]--;
        }
    }

    private static boolean checked(int r, int c) {
        return r >= 0 && r < (1<<N) && c >= 0 && c < (1<<N);
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map = new int[1<<N][1<<N];
        que = new LinkedList<>();
        for(int i = 0; i < (1<<N); i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < (1<<N); j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void dfs(int r, int c) {
        isVisited[r][c] = true;
        tempHigh++;
        for(int i = 0; i < 4; i++) {
            int tempR = r + dr[i];
            int tempC = c + dc[i];
            if(!checked(tempR, tempC) || map[tempR][tempC] == 0 || isVisited[tempR][tempC]) continue;
            dfs(tempR, tempC);
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            rotate(L);
            searchIce();
            changeIce();
        }
        que.clear();
        isVisited = new boolean[(1<<N)][(1<<N)];
        for(int i = 0; i < (1<<N); i++) {
            for(int j = 0; j < (1<<N); j++) {
                sum += map[i][j];
                if(isVisited[i][j] || map[i][j] == 0) continue;
                tempHigh = 0;
                dfs(i, j);
                high = Math.max(high, tempHigh);
            }
        }
        sb.append(sum).append("\n").append(high);
        System.out.println(sb.toString());


    }
}
