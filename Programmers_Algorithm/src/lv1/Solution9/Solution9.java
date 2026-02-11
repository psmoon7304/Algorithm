package lv1.Solution9;

public class Solution9 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0,0};
        int endX = park[0].length()-1, endY = park.length-1;
        if(park[0].charAt(0) != 'S') {
            for (int posY = 0; posY < park.length; posY++) {
                int StartPos = park[posY].indexOf('S');
                if (StartPos != -1) {
                    answer[0] = posY;
                    answer[1] = StartPos;
                    break;
                }
            }
        }

        for(String moving : routes) {
            char movingPos = moving.charAt(0);
            int movingDistance = Integer.parseInt(String.valueOf(moving.charAt(2))); // Char를 먼저 String으로 변환 후 int로 변환
            int[] tempNowPos = {answer[0], answer[1]};

            if(movingPos == 'N' && tempNowPos[0] - movingDistance < 0) continue;
            else if(movingPos == 'S' && tempNowPos[0] + movingDistance > endY) continue;
            else if(movingPos == 'W' && tempNowPos[1] - movingDistance < 0) continue;
            else if(movingPos == 'E' && tempNowPos[1] + movingDistance > endX) continue;

            int error = 0;
            for(int i = 0; i < movingDistance; i++) {
                if (movingPos == 'N') {
                    if (park[tempNowPos[0] - 1].charAt(tempNowPos[1]) == 'X') {
                        error = 1;
                        break;
                    }
                    tempNowPos[0]--;
                } else if (movingPos == 'S') {
                    if (park[tempNowPos[0] + 1].charAt(tempNowPos[1]) == 'X') {
                        error = 1;
                        break;
                    }
                    tempNowPos[0]++;
                } else if (movingPos == 'W') {
                    if (park[tempNowPos[0]].charAt(tempNowPos[1] - 1) == 'X') {
                        error = 1;
                        break;
                    }
                    tempNowPos[1]--;
                } else if (movingPos == 'E') {
                    if (park[tempNowPos[0]].charAt(tempNowPos[1] + 1) == 'X') {
                        error = 1;
                        break;
                    }
                    tempNowPos[1]++;
                }
            }
            if(error == 0) answer = tempNowPos;
        }
        return answer;
    }
}
