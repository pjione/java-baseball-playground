package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split(){
        String oneTwo = "1,2";
        String[] split1 = oneTwo.split(",");
        String one = "1";
        String[] split2 = one.split(",");
        assertThat(split1).contains("1","2");
        assertThat(split2).containsExactly("1");
    }
    @Test
    void subString(){
        String st = "(1,2)";
        String substring = st.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }
    @Test
    @DisplayName("특정 위치 문자 가져오기 실패 테스트")
    void charAt(){
        String st = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> st.charAt(4));
        assertThatThrownBy(() -> st.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
