package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual = "1,2".split(",");
        String[] actual2 = "1".split(",");

        assertThat(actual).contains("1","2");
        assertThat(actual2).contains("1");
    }

    @Test
    void substring(){
        String actual = "(1,2)";
        String subActual = actual.substring(1, actual.length()-1);

        assertThat(subActual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()으로 특정 위치 문자 가져오기")
    void charAt1(){
        String actual = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(()->{
            char val = actual.charAt(3);
            System.out.println(val);
            throw new Exception("범위 초과");
        }).withMessageContaining("String");
    }
}
