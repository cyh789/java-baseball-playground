package baseball_220523;

import java.util.Objects;

public class Ball {

    private final int position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BallNumber(number);
    }

    public BallStatus play(Ball player) {
        if (this.equals(player)) {
            return BallStatus.STRIKE;
        }
        if (this.matchNumber(player.number)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchNumber(BallNumber number) {
        return this.number.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
