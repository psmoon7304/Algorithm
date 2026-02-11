package lv2.Solution7;

import java.util.*;

public class Solution7 {
    static Deque<Integer> que1 = new LinkedList<>();
    static Deque<Integer> que2 = new LinkedList<>();
    static long[] queSize = {0, 0};

    static long getTarget(int[] q1, int[] q2) {
        for(int i = 0; i < q1.length; i++) {
            que1.offer(q1[i]);
            que2.offer(q2[i]);
            queSize[0] += q1[i];
            queSize[1] += q2[i];
        }
        long temp = (queSize[0] + queSize[1]);
        return temp % 2 == 1 ? -1 : (temp / 2);
    }

    static int runCode(long target) {
        int action = 0;
        while(true) {
            if(action > (que1.size() + que2.size())*2) return -1;
            if(queSize[0] == queSize[1]) return action;
            if(queSize[0] > queSize[1]) {
                int tempValue = que1.poll();
                if(tempValue > target) break;
                queSize[0] -= tempValue;
                queSize[1] += tempValue;
                que2.offer(tempValue);
            } else {
                int tempValue = que2.poll();
                if(tempValue > target) break;
                queSize[1] -= tempValue;
                queSize[0] += tempValue;
                que1.offer(tempValue);
            }
            action++;
        }
        return -1;
    }

    public int solution(int[] q1, int[] q2) {
        long temp = getTarget(q1, q2);
        return temp == -1 ? -1 : runCode(temp);
    }
}
