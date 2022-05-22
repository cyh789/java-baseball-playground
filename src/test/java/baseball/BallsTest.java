package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void strike() {
        assertThat(answers.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        assertThat(answers.play(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertThat(answers.play(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
    }
}
