package lotto.application.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void negativeNumberTest() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void amountUnitTest() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(1100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void zeroAmountTest() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}