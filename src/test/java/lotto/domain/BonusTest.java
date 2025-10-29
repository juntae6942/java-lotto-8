package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 번호가 로또 티켓에 포함되어있으면 true를 반환한다.")
    @Test
    void matchTest() {
        LottoTicket ticket = new CustomLottoTicket(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(1);

        boolean result = bonus.matches(ticket);

        assertThat(result).isTrue();
    }

    @DisplayName("보너스 번호가 로또 티켓에 포함되어있지 않으면 false를 반환한다.")
    @Test
    void notMatchTest() {
        LottoTicket ticket = new CustomLottoTicket(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(10);

        boolean result = bonus.matches(ticket);

        assertThat(result).isFalse();
    }
}