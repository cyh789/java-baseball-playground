package baseball_220523;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    //369
    //1,4 낫싱
    //1,3 스트라이크
    //2,3 볼
    @Test
    void 낫싱() {
        Balls computer = new Balls(Arrays.asList(3, 6, 9));
        Ball player = new Ball(1, 4);
        BallStatus status = computer.play(player);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 스트라이크() {
        Balls computer = new Balls(Arrays.asList(3, 6, 9));
        Ball player = new Ball(1, 3);
        BallStatus status = computer.play(player);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼() {
        Balls computer = new Balls(Arrays.asList(3, 6, 9));
        Ball player = new Ball(2, 3);
        BallStatus status = computer.play(player);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 원스트라이크_원볼() {
        Balls computer = new Balls(Arrays.asList(3, 6, 9));
        List<Integer> user = Arrays.asList(3, 5, 6);
        GameResult result = computer.createGameResult(user);
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
    }

    @Test
    void 쓰리볼() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        List<Integer> user = Arrays.asList(3, 1, 2);
        GameResult result = computer.createGameResult(user);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(3);
    }

    @Test
    void 쓰리스트라이크() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        List<Integer> user = Arrays.asList(1, 2, 3);
        GameResult result = computer.createGameResult(user);
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

}
