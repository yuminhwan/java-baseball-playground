package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size는_크기를_반환한다() {
        // given
        // when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest(name = "number : {0}")
    @ValueSource(ints = {1, 2, 3})
    void contains는_값이_존재하는_지를_반환한다(int sut) {
        assertThat(numbers.contains(sut)).isTrue();
    }

    @ParameterizedTest(name = "number : {0}, result : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains는_값이_존재하는_지를_반환한다(int sut, boolean result) {
        assertThat(numbers.contains(sut)).isEqualTo(result);
    }
}
