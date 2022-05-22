package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls answerBalls;
//    private PlayResult PlayResult result;

    @BeforeEach
    void setUp() {
        answerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("마지막단계. 3개의 값을 가지는 play")
    void play_nothing() {
        PlayResult result = answerBalls.play(Arrays.asList(4, 5, 6));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }
    @Test
    void play_1s_1b() {
        PlayResult result = answerBalls.play(Arrays.asList(1, 4, 2));

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }
    @Test
    void play_3s() {
        PlayResult result = answerBalls.play(Arrays.asList(1, 2, 3));

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void strike() {
        assertThat(answerBalls.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        assertThat(answerBalls.play(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertThat(answerBalls.play(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
    }
}
