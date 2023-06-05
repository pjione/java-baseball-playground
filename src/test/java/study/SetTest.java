package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    @Test
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }
    @Test
    void contains(){
        assertThat(numbers).containsExactly(1,2,3);
        assertThat(numbers.contains(1)).isTrue();
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains_v2(int number){
        assertTrue(numbers.contains(number));
        assertThat(numbers.contains(number)).isTrue();
    }
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains_v3(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
