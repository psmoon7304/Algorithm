package b.단어암기장_25313;

public class UserSolution {
    static class bucket {
        int[] maxColSize;
        int maxBucketColSize = 0;
    }
    static int N, M;

    static int[] wordStatus;

    public void init(int inputN, int inputM) {
        N = inputN;
        M = inputM;

        wordStatus = new int[N];
    }

    public int writeWord(int mId, int mLen) {
        return -1;
    }

    public int eraseWord(int mId) {
        if(wordStatus[mId] == -1) return -1;
        return wordStatus[mId];
    }
}

/*
버킷 생성 - N / 200
버킷안에 데이터 : 각 행의 열 최대 길이, 버킷의 열 최대 길이

wordStatus = 해당 mId에 해당되는 값이 현재 존재하는지 판단하기 위함, 행의 위치를 기록

 */