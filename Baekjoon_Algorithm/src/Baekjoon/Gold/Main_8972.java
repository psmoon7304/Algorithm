package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main_8972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<int[]> enemyQue;

    static int R, C;

    static char[][] map;
    static char[] playerAction;
    static int[] player,
            dr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1},
            dc = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};

    private static void enemyMove(int r, int c) {
        enemyQue.offer(new int[] {r, c});
    }

    private static void enemySearch() {
        int size = enemyQue.size();
        for(int i = 0; i < size; i++) {
            int[] moveAct = new int[] {0, 0, Integer.MAX_VALUE};
            int[] temp = enemyQue.poll();
            for(int j = 1; j <= 9; j++) {
                int r = temp[0] + dr[j];
                int c = temp[1] + dc[j];
                if(!chekced(r, c)) continue;

                int tempValue = Math.abs(player[0] - r) + Math.abs(player[1] - c);
                if(moveAct[2] > tempValue) {
                    moveAct[0] = r;
                    moveAct[1] = c;
                    moveAct[2] = tempValue;
                }
            }
            enemyMove(moveAct[0], moveAct[1]);
        }
    }

    private static void enemyOverlap() {
        HashMap<String, Integer> hMap = new HashMap<>();
        while(!enemyQue.isEmpty()) {
            int[] temp = enemyQue.poll();
            String key = temp[0] + "," + temp[1];
            hMap.put(key, hMap.getOrDefault(key, 0) + 1);
        }
        for(Map.Entry<String, Integer>entry : hMap.entrySet()) {
            if(entry.getValue() != 1) continue;
            String[] temp = entry.getKey().split(",");
            enemyQue.offer(new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])});
        }
    }

    private static void playerMove(int act) {
        player[0] += dr[act];
        player[1] += dc[act];
    }

    private static boolean gameEnd() {
        int size = enemyQue.size();
        for(int i = 0; i < size; i++) {
            int[] temp = enemyQue.poll();
            if(player[0] == temp[0] && player[1] == temp[1]) return true;
            enemyQue.offer(temp);
        }
        return false;
    }

    private static boolean chekced(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    private static void getResult(int x) {
        if(x != playerAction.length) {
            sb.append("kraj ").append(x + 1);
            return;
        }

        while(!enemyQue.isEmpty()) {
            int[] temp = enemyQue.poll();
            map[temp[0]][temp[1]] = 'R';
        }
        map[player[0]][player[1]] = 'I';

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        player = new int[2];
        enemyQue = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            char[] data = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(data[j] == 'I') {
                    player[0] = i;
                    player[1] = j;
                } else if(data[j] == 'R') {
                    enemyQue.offer(new int[] {i, j});
                }
                map[i][j] = '.';
            }
        }
        playerAction = br.readLine().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        init();
        int i;
        for(i = 0; i < playerAction.length; i++) {
            playerMove(playerAction[i] - '0');
            if(gameEnd()) break;
            enemySearch();
            if(gameEnd()) break;
            enemyOverlap();
        }
        getResult(i);
        System.out.println(sb.toString());
    }
}
