package lv1.Solution26;

public class Solution26 {
    public int solution(int[] ingredient) {
        int[] table = new int[ingredient.length];
        int answer = 0, pointer = 0;
        for(int a : ingredient) {
            table[pointer] = a;
            if(pointer >= 3 && table[pointer] == 1 && table[pointer-1] == 3 && table[pointer-2] == 2 && table[pointer-3] == 1) {
                answer++;
                pointer -= 3;
            } else {
                pointer++;
            }
        }
        return answer;
    }
}
