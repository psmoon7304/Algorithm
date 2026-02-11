package lv1.Solution27;

import java.util.Arrays;

public class Solution27 {
    public int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int answer = 0, replaceCount, check;

        for(String s : babbling) {
            if(s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) continue;
            if(Arrays.asList(word).contains(s)) {
                answer++;
                continue;
            }
            for(String w : word) {
                s = s.replace(w, " ");
            }
            s = s.replace(" ", "");
            if(s.length() == 0) answer++;
        }
        return answer;
    }
}

/*
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] voice={"aya", "woo", "ye", "ma"};


        for(String s : babbling){
            int cusor=0;
            int sEnd=s.length()-1;
            boolean check=true;
            String prev="";
            while(true){
                boolean ok=false;
                if (cusor==sEnd+1) break;
                for(int i=0;i<4;i++){
                    if(cusor+voice[i].length()-1<=sEnd && !(prev.equals(voice[i])) && s.substring(cusor, cusor+voice[i].length()).equals(voice[i])){
                        cusor=cusor+voice[i].length();
                        prev=voice[i];
                        ok=true;
                        break
                    }
                }
                if(오케이) continue;

                check=false;
                break;
            }
            if(check) answer++;
        }
        return answer;
    }
}
 */