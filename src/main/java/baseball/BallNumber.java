package baseball;

public class BallNumber {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    private int no;

    public BallNumber(int no) {
        if(no < MIN_NO && no > MAX_NO) {
            throw new IllegalArgumentException("볼 숫자의 값은 반드시 1~9 사이 값이여야 합니다.");
        }
        this.no = no;
    }
}
