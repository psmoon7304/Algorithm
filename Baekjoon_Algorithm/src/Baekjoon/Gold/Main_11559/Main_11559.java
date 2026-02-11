package Baekjoon.Gold.Main_11559;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11559 {
    static char[][] map;
    static int answer;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        init();

        int tryAction = 0;

        do {
            a:
            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(map[i][j] != '.') {
                        visited = new boolean[12][6];
                        tryAction = bfs(i,j,map[i][j]);
                        answer++;
                        break a;
                    }
                }
            }
            for(int i = 0; i < 12; i++) System.out.println(Arrays.toString(map[i]));
        } while(tryAction > 3);
        System.out.println(answer);
    }
    static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for(int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
    static int bfs(int ir, int ic, char target) {
        Deque<int[]> deque = new LinkedList<>();
        Deque<int[]> targetPos = new LinkedList<>();
        HashMap<Integer, Integer> moveCount = new HashMap<>();
        int boom = 1;
        deque.offer(new int[] {ir,ic});
        visited[ir][ic] = true;
        while(!deque.isEmpty()) {
            int[] temp = deque.poll();
            int tempR = temp[0], tempC = temp[1];
            for (int i = 0; i < 4; i++) {
                int r = tempR + dr[i];
                int c = tempC + dc[i];
                if(!check(r,c) || visited[r][c] || map[r][c] != target) continue;
                visited[r][c] = true;
                deque.offer(new int[] {r,c});
                targetPos.offer(new int[] {r,c});
                boom++;
            }
        }

        if(boom > 3) {
            while (!targetPos.isEmpty()) {
                int[] temp = targetPos.poll();
                moveCount.put(temp[1], moveCount.getOrDefault(temp[1],0) + 1);
                map[temp[0]][temp[1]] = '.';
            }
        }

        for(Map.Entry<Integer,Integer> entry : moveCount.entrySet()) {
            int temp = entry.getKey();
            for(int i = 0; i < entry.getValue(); i++) {
                for (int j = 11; j > 0; j--) {
                    if (map[j][entry.getKey()] == '.') {
                        map[j][temp] = map[j - 1][temp];
                        map[j - 1][temp] = '.';
                    }
                }
            }
        }
        return boom;
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < 12 && c >= 0 && c < 6;
    }
}
