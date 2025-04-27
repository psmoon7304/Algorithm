package lv2;

public class Solution2 {
    private int countChar(String[] str, char ch) {
        int count = 0;
        for(String s : str) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == ch) count++;
            }
        }
        return count;
    }

    private boolean isCan(char[][] storage, int y, int x) {
        if(x == -1 || y == -1 || x == storage.length || y == storage.length) return true;
        else if(storage[y][x] != ' ') return false;

        if(isCan(storage, y - 1, x)) return true;
        if(isCan(storage, y + 1, x)) return true;
        if(isCan(storage, y, x - 1)) return true;
        if(isCan(storage, y, x + 1)) return true;
        return false;
    }

    public int solution(String[] storage, String[] requests) {
        int answer = storage.length * storage[0].length();
        char[][] nowStorage = new char[storage.length][storage[0].length()];
        for(int i = 0; i < storage.length; i++) {
            nowStorage[i] = storage[i].toCharArray();
        }

        for(String r : requests) {
            if(r.length() == 2) {
                for(int i = 0; i < nowStorage.length; i++) {
                    for(int j = 0; j < nowStorage[i].length; j++) {
                        if(nowStorage[i][j] == r.charAt(0)) nowStorage[i][j] = ' ';
                    }
                }
            } else {
                for(int i = 0; i < nowStorage.length; i++) {
                    for(int j = 0; j < nowStorage[i].length; j++) {
                        if(nowStorage[i][j] == r.charAt(0)) {
                            if(i == 0 || i == nowStorage.length - 1 || j == 0 || j == nowStorage.length - 1) {
                                nowStorage[i][j] = ' ';
                            } else if(isCan(nowStorage, i, j)) {
                                nowStorage[i][j] = ' ';
                            }
                        }
                    }
                }
            }
        }
        return answer - countChar(storage, ' ');
    }
}
