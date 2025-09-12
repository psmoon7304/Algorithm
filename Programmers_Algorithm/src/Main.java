public class Main {
    public static void main(String[] args) {
        lv2.Solution4 run = new lv2.Solution4();
        //System.out.println(run.solution());
        System.out.println(
                run.solution(
                        new int[][] {
                                {0, 0, 0, 1, 1, 1, 0, 0},
                                {0, 0, 0, 0, 1, 1, 0, 0},
                                {1, 1, 0, 0, 0, 1, 1, 0},
                                {1, 1, 1, 0, 0, 0, 0, 0},
                                {1, 1, 1, 0, 0, 0, 1, 1}
                        }
                )
        );
    }
}