package lv1.Solution82;

public class Solution82 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {-1,-1,-1,-1};
        for(int i = 0; i < wallpaper.length; i++) {
            if(wallpaper[i].contains("#")) {
                if(answer[0] == -1) answer[0] = i;
                if(answer[2] < i + 1) answer[2] = i + 1;
            }
        }
        for(int i = 0; i < wallpaper[0].length(); i++) {
            for(int j = 0; j < wallpaper.length; j++) {
                if(wallpaper[j].toCharArray()[i] == '#') {
                    if(answer[1] == -1) answer[1] = i;
                    if(answer[3] < i + 1) answer[3] = i + 1;
                }
            }
        }
        return answer;
    }
}
