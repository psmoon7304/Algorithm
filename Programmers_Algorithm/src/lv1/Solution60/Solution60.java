package lv1.Solution60;

public class Solution60 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keyPad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        int[][] handsPos = {{3,0},{3,2}}; // 0 왼손 1 오른손
        for(int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                handsPos[0] = keyPad[i].clone();
                answer.append("L");
            } else if (i == 3 || i == 6 || i == 9) {
                handsPos[1] = keyPad[i].clone();
                answer.append("R");
            } else {
                int leftMove = 0, rightMove = 0;
                leftMove = Math.abs(keyPad[i][0] - handsPos[0][0]) + Math.abs(keyPad[i][1] - handsPos[0][1]);
                rightMove = Math.abs(keyPad[i][0] - handsPos[1][0]) + Math.abs(keyPad[i][1] - handsPos[1][1]);
                if(leftMove == rightMove && hand.equals("left") || leftMove < rightMove) {
                    handsPos[0] = keyPad[i].clone();
                    answer.append("L");
                } else if (leftMove == rightMove && hand.equals("right") || leftMove > rightMove) {
                    handsPos[1] = keyPad[i].clone();
                    answer.append("R");
                }
            }
        }
        return answer.toString();
    }
}
