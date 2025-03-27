package lv1;

public class Solution18 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int timeStamp, maxHealth = health;
        health -= attacks[0][1];
        for(int i = 1; i < attacks.length; i++) {

            timeStamp = attacks[i][0] - attacks[i-1][0] - 1;
            health += bandage[1] * (timeStamp);
            health += timeStamp / bandage[0] * bandage[2];
            if(health > maxHealth) health = maxHealth;

            health -= attacks[i][1];
            if(health <= 0) return -1;

        }
        return health;
    }
}
