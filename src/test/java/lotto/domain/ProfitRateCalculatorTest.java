package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorTest {

    private final ProfitRateCalculator calculator = new ProfitRateCalculator();

    @Test
    @DisplayName("당첨금 합계가 구매금액과 같을 경우 수익률은 100.0%이어야 한다")
    void profitRateEqualPurchaseAmountTest() {
        int purchaseAmount = 5000;
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        winningStatistics.put(Rank.FIFTH, 1);

        double profitRate = calculator.calculateProfitRate(purchaseAmount, winningStatistics);

        assertThat(profitRate).isEqualTo(100.0);
    }

    @Test
    @DisplayName("총 당첨금이 구매금액보다 많을 경우 100% 초과 수익률이 계산되어야 한다")
    void profitRateBiggerPurchaseAmountTest() {
        int purchaseAmount = 5000;
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        winningStatistics.put(Rank.FIFTH, 2);

        double profitRate = calculator.calculateProfitRate(purchaseAmount, winningStatistics);

        assertThat(profitRate).isEqualTo(200.0);
    }

    @Test
    @DisplayName("총 당첨금이 없을 경우 수익률은 0.0%이어야 한다")
    void profitRateNoPrizeTest() {
        int purchaseAmount = 5000;
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        winningStatistics.put(Rank.NONE, 1);

        double profitRate = calculator.calculateProfitRate(purchaseAmount, winningStatistics);

        assertThat(profitRate).isEqualTo(0.0);
    }

    @Test
    @DisplayName("여러 등수의 당첨금이 합산되어 올바른 수익률이 계산되어야 한다")
    void profitRateMultipleRanksTest() {
        int purchaseAmount = 10000;
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        winningStatistics.put(Rank.FOURTH, 1);
        winningStatistics.put(Rank.FIFTH, 2);

        double profitRate = calculator.calculateProfitRate(purchaseAmount, winningStatistics);

        assertThat(profitRate).isEqualTo(600.0);
    }
}