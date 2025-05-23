package lv1;

public class Solution19 {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String pointColor = board[h][w];
        if(h - 1 >= 0 && pointColor.equals(board[h - 1][w])) answer++;
        if(h + 1 < board.length && pointColor.equals(board[h + 1][w])) answer++;
        if(w - 1 >= 0 && pointColor.equals(board[h][w - 1])) answer++;
        if(w + 1 < board.length && pointColor.equals(board[h][w + 1])) answer++;
        return answer;
    }
}
