package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0,cal.add(""));
        assertEquals(0,cal.add(null));
    }

    @Test
    public void add_숫자하나() {
        assertEquals(1,cal.add("1"));
    }

    @Test
    public void add_쉼표구분() {
        assertEquals(3,cal.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() {
        assertEquals(6,cal.add("1,2:3"));
    }

    @Test
    public void add_커스텀_구분자() {
        assertEquals(6,cal.add("//;\n1;2;3"));
    }

    @Test
    public void add_negative() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    cal.add("-1,2,3");
                }).withMessageContaining("Runtime");
    }

    @Test
    public void split(){
        assertThat(new String[] {"1"}).isEqualTo("1".split(","));
        assertThat(new String[] {"1","2"}).isEqualTo("1,2".split(","));
    }




}