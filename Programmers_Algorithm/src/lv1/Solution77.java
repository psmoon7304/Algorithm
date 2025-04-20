package lv1;

public class Solution77 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder tempString = new StringBuilder();
        while(n >= 3) {
            tempString.append(n % 3);
            n /= 3;
        }
        tempString.append(n);
        for(int i = 0; i < tempString.length(); i++) {
            answer += (int)Math.pow(3, i) * Integer.parseInt(String.valueOf(tempString.charAt(tempString.length() - i - 1)));
        }
        return answer;
    }
}
