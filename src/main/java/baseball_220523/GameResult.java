package baseball_220523;

import java.util.List;

public class GameResult {
    private int ballCount = 0;
    private int strikeCount = 0;

    public GameResult(List<BallStatus> statuses) {
        for (BallStatus status : statuses) {
            if (status.isBall()) {
                ballCount++;
            }
            if (status.isStrike()) {
                strikeCount++;
            }
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}