package baseball.ValidationUtils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("야구_숫자_1_9_검증")
    void 야구_숫자_1_9_검증(){
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(10)).isFalse();
        assertThat(ValidationUtils.validNo(0)).isFalse();
    }

    @Test
    @DisplayName("자리수_3_검증")
    void 자리수_3_검증() {
        assertThat(ValidationUtils.validSizs(100)).isTrue();
        assertThat(ValidationUtils.validSizs(999)).isTrue();
        assertThat(ValidationUtils.validSizs(1000)).isFalse();
        assertThat(ValidationUtils.validSizs(99)).isFalse();
    }
}
