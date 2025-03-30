package lv1;

public class Solution22 {
    public int solution(String t, String p) {
        int answer = 0;
        long tmp = 0;
        int loopCount = t.length() - p.length();
        for(int i = 0; i <= loopCount; i++) {
            tmp = Long.parseLong(t.substring(i, i + p.length()));
            if (tmp <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}

