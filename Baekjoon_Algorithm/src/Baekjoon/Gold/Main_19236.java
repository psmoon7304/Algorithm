package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int answer;
    static int[] sharkPos = {0, 0, 0};
    static int[][] map, fish;

    static int[] dr ={-1, -1, 0, 1, 1, 1, 0, -1},
                dc ={0, -1, -1 ,-1, 0 , 1, 1, 1};
    
    private static boolean checked(int r, int c) {
        return r >= 0 && r < 4 && c >= 0 && c < 4;
    }
    
    private static void fishMove() {
        for(int i = 1; i <= 16; i++) {
            for(int j = fish[i][2]; j < fish[i][2] + 8; j++) {
                int r = fish[i][0] + dr[j];
                int c = fish[i][1] + dc[j];
                if(!checked(r, c) || (sharkPos[0] == r && sharkPos[1] == c)) continue;
                if(map[r][c] == 0) {
                    fish[i][0] = r;
                    fish[i][1] = c;
                    fish[i][2] = j;
                    break;
                }
                fish[map[r][c]][0] = fish[i][0];
                fish[map[r][c]][1] = fish[i][1];
                break;
            }
        }
    }

    private static void mapLoad() {
        for(int i = 1; i <= 16; i++) {
            map[fish[i][0]][fish[i][1]] = i;
        }
    }

    private static void init() throws Exception {
        answer = 0;
        
        map = new int[4][4];
        fish = new int[17][3]; // 0 인덱스 사용 x
        
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 4; j++) {
                fish[Integer.parseInt(st.nextToken())] = new int[] {i, j, Integer.parseInt(st.nextToken()) - 1};
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        mapLoad();
        sharkPos = new int[] {0, 0, fish[map[0][0]][2]};
        answer += map[0][0];
        map[0][0] = 0;
        
        fishMove();
        //sharkMove();
    }
}
