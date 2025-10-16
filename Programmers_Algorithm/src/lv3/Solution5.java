package lv3;

public class Solution5 {
    static int[][] map;
    static int actType, answer = 0;

    public int solution(int[][] board, int[][] skill) {
        map = new int[board.length + 1][board[0].length + 1];

        for(int[] act : skill) {
            if(act[0] == 1) actType = -1;
            else actType = 1;

            map[act[1]][act[2]] += act[5] * actType;
            map[act[1]][act[4] + 1] += -act[5] * actType;
            map[act[3] + 1][act[2]] += -act[5] * actType;
            map[act[3] + 1][act[4] + 1] += act[5] * actType;
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 1; j < map[i].length; j++) {
                map[i][j] += map[i][j - 1];
            }
        }

        for(int i = 0; i < map[0].length; i++) {
            for(int j = 1; j < map.length; j++) {
                map[j][i] += map[j - 1][i];
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] += map[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}
