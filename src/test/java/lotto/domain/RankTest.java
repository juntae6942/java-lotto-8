package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("로또 번호와 로또 티켓의 수가 3개 일치하면 Rank는 5등(FIFTH)이다.")
    @Test
    void fifthRankTest() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또 티켓이 로또 번호 5개와 보너스 번호를 가지고 있으면 2등(SECOND)이다.")
    @Test
    void secondRankTest() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또 번호와 일치하는 번호가 로또 티켓에 없으면 등수가 없다(NONE).")
    @Test
    void noneRankTest() {
        Rank rank = Rank.valueOf(0, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("보너스 번호만 로또 티켓에 포함되는 경우 등수가 없다(NONE).")
    @Test
    void bonusHasNoneRankTest() {
        Rank rank = Rank.valueOf(0, true);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
