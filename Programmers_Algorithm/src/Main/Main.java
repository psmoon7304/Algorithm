package Main;

import lv2.Solution5;

public class Main {
    public static void main(String[] args) {
        Solution5 run = new Solution5();
        //System.out.println(run.solution());
        System.out.println(
                run.solution(new int[]{180, 5000, 10, 600}, new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
                )
        );
    }
}