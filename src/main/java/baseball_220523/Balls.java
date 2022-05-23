package baseball_220523;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        this.balls = mappingToBalls(numbers);
    }

    private List<Ball> mappingToBalls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        int position = 1;
        for (Integer number : numbers) {
            Ball ball = new Ball(position, number);
            balls.add(ball);
            position++;
        }
        return balls;
    }

    public BallStatus play(Ball user) {
        List<BallStatus> result = new ArrayList<>();
        for (Ball computer : balls) {
            result.add(computer.play(user));
        }
        for (BallStatus status : result) {
            if (status.isNotNothing()) {
                return status;
            }
        }
        return BallStatus.NOTHING;
    }

    public GameResult createGameResult(List<Integer> balls) {
        List<Ball> players = mappingToBalls(balls);
        List<BallStatus> result = new ArrayList<>();
        for (Ball player : players) {
            BallStatus status = this.play(player);
            result.add(status);
        }
        return new GameResult(result);
    }

}
