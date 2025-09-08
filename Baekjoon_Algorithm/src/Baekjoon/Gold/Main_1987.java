package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Character> alphabet = new ArrayList<>();

    static int R, C, answer;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static void dfs(int r, int c) {
        if(alphabet.contains(map[r][c])) {
            return;
        } else {
            alphabet.add(map[r][c]);
        }
        for(int i = 0; i < 4; i++) {
            int tempR = r + dr[i];
            int tempC = c + dc[i];
            if(!check(tempR, tempC) || isVisited[tempR][tempC]) continue;
            isVisited[tempR][tempC] = true;
            dfs(tempR, tempC);
            isVisited[tempR][tempC] = false;
        }
        answer = Math.max(answer, alphabet.size());
        alphabet.remove(alphabet.size() - 1);
    }

    static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];
        for(int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        init();
        dfs(0, 0);
        System.out.println(answer);
    }
}
