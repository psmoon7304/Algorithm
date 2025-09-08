package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class SolutionTest11 {
    static int[] tankPos;
    static final int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static final int[] dx = {0, 0, -1, 1};
    static final char[] directionChar = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int actLen = Integer.parseInt(br.readLine());
            char[] actList = br.readLine().toCharArray();

            tankPos = getTankPos(map);

            for (char act : actList) {
                int y = tankPos[0];
                int x = tankPos[1];

                switch (act) {
                    case 'U':
                        map[y][x] = '^';
                        if (isMove(map, y - 1, x)) {
                            map[y][x] = '.';
                            tankPos[0] = y - 1;
                            map[tankPos[0]][x] = '^';
                        }
                        break;
                    case 'D':
                        map[y][x] = 'v';
                        if (isMove(map, y + 1, x)) {
                            map[y][x] = '.';
                            tankPos[0] = y + 1;
                            map[tankPos[0]][x] = 'v';
                        }
                        break;
                    case 'L':
                        map[y][x] = '<';
                        if (isMove(map, y, x - 1)) {
                            map[y][x] = '.';
                            tankPos[1] = x - 1;
                            map[y][tankPos[1]] = '<';
                        }
                        break;
                    case 'R':
                        map[y][x] = '>';
                        if (isMove(map, y, x + 1)) {
                            map[y][x] = '.';
                            tankPos[1] = x + 1;
                            map[y][tankPos[1]] = '>';
                        }
                        break;
                    case 'S':
                        tryShoot(map);
                        break;
                }
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < h; i++) {
                System.out.println(new String(map[i]));
            }
        }
    }

    private static int[] getTankPos(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                char c = map[i][j];
                if (c == '<' || c == '>' || c == '^' || c == 'v') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean isMove(char[][] map, int ny, int nx) {
        return ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length && map[ny][nx] == '.';
    }

    private static void tryShoot(char[][] map) {
        int y = tankPos[0];
        int x = tankPos[1];
        char dir = map[y][x];
        int d = 0;
        if (dir == '^') d = 0;
        else if (dir == 'v') d = 1;
        else if (dir == '<') d = 2;
        else if (dir == '>') d = 3;

        int ny = y + dy[d];
        int nx = x + dx[d];

        while (ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
            if (map[ny][nx] == '*') {
                map[ny][nx] = '.';
                break;
            } else if (map[ny][nx] == '#') {
                break;
            }
            ny += dy[d];
            nx += dx[d];
        }
    }
}
