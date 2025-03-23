package lv1;

public class Solution12 {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += ' ';
                continue;
            }
            if(s.charAt(i) <= 90) {
                if((int)s.charAt(i) + n > 90) {
                    answer += (char)(64 + ((int)s.charAt(i) + n) - 90);
                    continue;
                }
            } else {
                if((int)s.charAt(i) + n > 122) {
                    answer += (char)(96 + ((int)s.charAt(i) + n) - 122);
                    continue;
                }
            }
            answer += String.valueOf((char)((int)s.charAt(i) + n));
        }
        return answer;
    }
}
