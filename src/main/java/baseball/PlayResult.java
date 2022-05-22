package baseball;

public class PlayResult {

    private int countStrike = 0;
    private int countBall = 0;

    public int getStrike() {
        return this.countStrike;
    }

    public int getBall() {
        return this.countBall;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.countStrike += 1;
        }
        if (status.isBall()) {
            this.countBall += 1;
        }
    }

    public boolean isGameEnd() {
        return countStrike == 3;
    }
}
