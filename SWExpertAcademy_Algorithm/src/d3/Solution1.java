package d3;

import java.util.Scanner;
//import java.io.FileInputStream;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int testCase = 1; testCase <= T; testCase++) {
            int n = sc.nextInt();
            sc.nextLine();
            char[] player = new char[n];
            int aPointer = 0, bPointer = 0, turn = 0;
            String[] aPlayer = sc.nextLine().split(" ");
            String[] bPlayer = sc.nextLine().split(" ");
            while(turn < n) {
                if(turn % 2 == 0) {
                    if(player[Integer.parseInt(aPlayer[aPointer]) - 1] == '\u0000') player[Integer.parseInt(aPlayer[aPointer]) - 1] = 'A';
                    else {
                        aPointer++;
                        continue;
                    }
                    turn++;
                } else {
                    if(player[Integer.parseInt(bPlayer[bPointer]) - 1] == '\u0000') player[Integer.parseInt(bPlayer[bPointer]) - 1] = 'B';
                    else {
                        bPointer++;
                        continue;
                    }
                    turn++;
                }
            }
            for(int i = 0; i < player.length; i++) System.out.print(player[i]);
            System.out.println();
        }
    }
}
