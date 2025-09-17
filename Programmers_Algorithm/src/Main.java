import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        lv3.Solution1 run = new lv3.Solution1();
        //System.out.println(run.solution());
        System.out.println(
                run.solution(20,
                        new int[][] {
                                {1, 2}, {1, 3}, {2, 14}, {14, 16}, {16, 20},
                                {2, 15}, {15, 17}, {17, 18}, {17, 19},
                                {3, 4}, {4, 5}, {5, 6}, {5, 7},
                                {6, 12}, {6, 11}, {7, 8}, {8, 10}, {8, 9},
                                {3, 13}
                        }
                )
        );
    }
}