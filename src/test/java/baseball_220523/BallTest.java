package baseball_220523;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    //369
    //1,4 낫싱
    //1,3 스트라이크
    //2,3 볼
    @Test
    void 낫싱() {
        Ball computer = new Ball(1, 3);
        Ball player = new Ball(1, 4);
        BallStatus status = computer.play(player);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 스트라이크() {
        Ball computer = new Ball(1, 3);
        Ball player = new Ball(1, 3);
        BallStatus status = computer.play(player);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼() {
        Ball computer = new Ball(1, 3);
        Ball player = new Ball(2, 3);
        BallStatus status = computer.play(player);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

}
