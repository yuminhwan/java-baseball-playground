package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void replace_학습_테스트() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split는_구분자_기준으로_분리하여_배열을_반환한다() {
        // given
        String sut = "1,2";

        // when
        String[] result = sut.split(",");

        // then
        assertThat(result).contains("1", "2");
    }

    @Test
    void split는_해당하는_구분자가_없다면_그대로_배열을_반환한다() {
        // given
        String sut = "1";

        // when
        String[] result = sut.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring은_문자열을_분리한다() {
        // given
        String sut = "(1,2)";

        // when
        String result = sut.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt은_특정_위치의_문자를_반환한다() {
        // given
        String sut = "abc";

        // when
        char result = sut.charAt(0);

        // then
        assertThat(result).isEqualTo('a');
    }

    @Test
    void charAt은_위치_값이_벗어나면_예외를_발생한다() {
        // given
        String sut = "abc";

        // when
        // then
        assertThatThrownBy(() -> sut.charAt(4))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageMatching("String index out of range: \\d+");
    }
}
