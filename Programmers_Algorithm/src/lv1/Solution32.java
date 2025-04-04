package lv1;

import java.util.ArrayList;

public class Solution32 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList<>();
        for(int move : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][move-1] != 0) {
                    if(!(stack.isEmpty()) && stack.get(stack.size() - 1) == board[i][move-1]) {
                        answer += 2;
                        stack.remove(stack.size() - 1);
                    }
                    else stack.add(board[i][move-1]);
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}

/* 초기 코드 ( 문제 잘못 생각했음 )
package lv1;

import java.util.ArrayList;

public class Solution32 {
    private int answer = 0;
    private ArrayList<Integer> clearStack(ArrayList<Integer> stack, int pointer) {
        if(pointer < stack.size() && stack.get(pointer) == stack.get(pointer - 1)) {
            stack.remove(pointer);
            stack.remove(pointer - 1);
            answer += 2;
            return clearStack(stack, pointer - 1);
        }
        return stack;
    }
    public int solution(int[][] board, int[] moves) {
        int pointer = 0;
        ArrayList<Integer> stack = new ArrayList<>();
        for(int move : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][move-1] != 0) {
                    stack.add(board[i][move-1]);
                    board[i][move-1] = 0;
                    break;
                }
            }
            if(stack.size() > 1) {
                clearStack(stack, stack.size()-1);
            }
        }
        return answer;
    }
}
 */
