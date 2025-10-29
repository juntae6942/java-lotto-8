package lotto.application.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    @DisplayName("로또 번호에 음수값이 들어오면 예외가 발생한다.")
    @Test
    void negativeNumberTest() {
        assertThatThrownBy(() -> LottoValidator.validateRanges(List.of(1,2,3,4,10,-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 음수값이 들어오면 예외가 발생한다.")
    @Test
    void negativeBonusNumberTest() {
        assertThatThrownBy(() -> LottoValidator.validateRange(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어난 값이 들어오면 예외가 발생한다.")
    @Test
    void numberRangeTest() {
        assertThatThrownBy(() -> LottoValidator.validateRanges(List.of(50, 3, 4, 10, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위를 벗어난 값이 들어오면 예외가 발생한다.")
    @Test
    void bonusNumberRangeTest() {
        assertThatThrownBy(() -> LottoValidator.validateRange(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
