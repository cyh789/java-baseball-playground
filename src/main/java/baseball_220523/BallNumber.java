package baseball_220523;

import java.util.Objects;

public class BallNumber {

    private final static int MAX_NUMBER = 9;
    private final static int MIN_NUMBER = 1;
    private final int number;

    public BallNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException("숫자는 1~9 사이의 값이어야 합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
