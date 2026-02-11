package lv1.Solution59;

public class Solution59 {
    public int[] solution(int[] answers) {
        int p1Answer = 0, p2Answer = 0, p3Answer = 0, size = 0;
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[i % p1.length]) p1Answer += 1;
            if(answers[i] == p2[i % p2.length]) p2Answer += 1;
            if(answers[i] == p3[i % p3.length]) p3Answer += 1;
        }
        if(p1Answer == p2Answer && p3Answer == p1Answer) return new int[] {1,2,3};
        else if(p1Answer == p2Answer && p1Answer > p3Answer) return new int[] {1,2};
        else if(p2Answer == p3Answer && p2Answer > p1Answer) return new int[] {2,3};
        else if(p3Answer == p1Answer && p3Answer > p2Answer) return new int[] {1,3};
        else if(p1Answer > p2Answer && p1Answer > p3Answer) return new int[] {1};
        else if(p2Answer > p3Answer) return new int[] {2};
        else return new int[] {3};
    }
}
