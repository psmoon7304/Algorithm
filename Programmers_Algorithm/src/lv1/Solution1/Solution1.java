package lv1.Solution1;

public class Solution1 {
    public int solution(int n, int w, int num) {
        int boxColumn = (int)Math.ceil((double)n/w);
        int[][] box = new int[boxColumn][w];
        int index = -1, target = -1, boxNum = 0; // index = 찾으려는 상자의 세로 index / target = 찾으려는 상자의 가로 index

        for(int i = 0; i < boxColumn; i++) {
            for(int j = 0; j < w; j++) {
                if(( i * w ) + j + 1 > n) {
                    boxNum = 0;
                } else {
                    boxNum = ( i * w ) + j + 1;
                }
                if(boxNum == num) {
                    index = i;
                    if(i % 2 != 0) {
                        target = w - ( j + 1 );
                    } else {
                        target = j;
                    }
                }
                if(i % 2 == 0) {
                    box[i][j] = boxNum;
                } else {
                    box[i][w - ( j + 1 )] = boxNum;
                }
            }
        }
        if(box[boxColumn-1][target] != 0) {
            return boxColumn - index;
        }
        return boxColumn - (index + 1);
    }
}