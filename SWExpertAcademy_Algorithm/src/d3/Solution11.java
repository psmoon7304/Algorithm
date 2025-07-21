package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution11 {

    private static int[] getTankPos(char[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }

    private static boolean isMove(char[][] map, int[] tankPos, int y, int x) {
        if(tankPos[1] + x < 0 || tankPos[1] + x >= map[0].length || tankPos[0] + y < 0 || tankPos[0] + y >= map.length) return false;
        else if(map[tankPos[0] + y][tankPos[1] + x] != '.') return false;
        return true;
    }

    private static void tryShoot(char[][] map, int[] tankPos) {
        int[] moveMissile = {0,0};
        if(map[tankPos[0]][tankPos[1]] =='^') moveMissile[0] = -1;
        else if(map[tankPos[0]][tankPos[1]] == 'v') moveMissile[0] = 1;
        else if(map[tankPos[0]][tankPos[1]] == '<') moveMissile[1] = -1;
        else if(map[tankPos[0]][tankPos[1]] == '>') moveMissile[1] = 1;

        int tempY = tankPos[0];
        int tempX = tankPos[1];

        while(true) {
            tempY += moveMissile[0];
            tempX += moveMissile[1];
            if(tempY < 0 || tempY >= map.length || tempX < 0 || tempX >= map[0].length) return;

            if(map[tempY][tempX] == '*') {
                map[tempY][tempX] = '.';
                return;
            } else if(map[tempY][tempX] == '#') {
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            StringBuilder sb = new StringBuilder();
            int[] tankPos = new int[2];

            int[] mapSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            char[][] map = new char[mapSize[0]][mapSize[1]];
            for(int i = 0; i < mapSize[0]; i++) map[i] = br.readLine().toCharArray();

            int actSize = Integer.parseInt(br.readLine());
            char[] actList = br.readLine().toCharArray();

            for(char act : actList) {
                tankPos = getTankPos(map);
                if(act == 'U') {
                    map[tankPos[0]][tankPos[1]] = '^';
                    if(isMove(map,tankPos,-1,0)) {
                        map[tankPos[0]][tankPos[1]] = '.';
                        map[tankPos[0] - 1][tankPos[1]] = '^';
                    }
                } else if(act == 'D') {
                    map[tankPos[0]][tankPos[1]] = 'v';
                    if(isMove(map,tankPos,1,0)) {
                        map[tankPos[0]][tankPos[1]] = '.';
                        map[tankPos[0] + 1][tankPos[1]] = 'v';
                    }
                } else if(act == 'L') {
                    map[tankPos[0]][tankPos[1]] = '<';
                    if(isMove(map,tankPos,0,-1)) {
                        map[tankPos[0]][tankPos[1]] = '.';
                        map[tankPos[0]][tankPos[1] - 1] = '<';
                    }
                } else if(act == 'R') {
                    map[tankPos[0]][tankPos[1]] = '>';
                    if(isMove(map,tankPos,0,1)) {
                        map[tankPos[0]][tankPos[1]] = '.';
                        map[tankPos[0]][tankPos[1] + 1] = '>';
                    }
                } else {
                    tryShoot(map, tankPos);
                }
            }

            sb.append("#" + tc + " ");
            for(int i = 0; i < mapSize[0]; i++) {
                for(char value : map[i]) {
                    sb.append(value);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }

    }
}
