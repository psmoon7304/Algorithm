package lv1.Solution80;

public class Solution80 {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        char lastChar = ' ';
        new_id = new_id.toLowerCase();
        for(char c : new_id.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c - '0' >= 0 && c - '0' <= 9) || c == '_' || c == '-') {
                lastChar = c;
                answer.append(c);
            } else if( c == '.' && lastChar != '.') {
                lastChar = c;
                answer.append(c);
            }
        }
        if(answer.length() != 0 && answer.charAt(0) == '.') answer.deleteCharAt(0);
        if(answer.length() != 0 && answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);
        if(answer.length() == 0) answer.append('a');
        if(answer.length() > 15) answer.replace(15,answer.length(),"");
        if(answer.length() != 0 && answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);
        while(answer.length() < 3) answer.append(answer.charAt(answer.length()-1));
        return answer.toString();
    }
}
