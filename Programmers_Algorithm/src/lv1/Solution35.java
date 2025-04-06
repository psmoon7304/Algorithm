package lv1;

public class Solution35 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoLen = Integer.parseInt(video_len.replace(":", ""));
        int nowPos = Integer.parseInt(pos.replace(":", ""));
        int opStart = Integer.parseInt(op_start.replace(":", ""));
        int opEnd = Integer.parseInt(op_end.replace(":", ""));

        if(nowPos >= opStart && nowPos <= opEnd) nowPos = opEnd;
        for(String command : commands) {
            if(command.equals("next")) {
                nowPos += 10;
                if(nowPos % 100 > 59) {
                    nowPos += 40;
                }
                if(nowPos > videoLen) nowPos = videoLen;
            } else {
                nowPos -= 10;
                if(nowPos % 100 > 59) {
                    nowPos -= 40;
                }
                if(nowPos < 0) nowPos = 0;
            }
            if(nowPos >= opStart && nowPos <= opEnd) nowPos = opEnd;
        }
        return String.valueOf(nowPos / 1000) + String.valueOf(nowPos % 1000 / 100) + ":" + String.valueOf(nowPos % 100 / 10) + String.valueOf(nowPos % 10);
    }
}
