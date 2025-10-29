package lotto.domain;

import java.util.Map;

public class ProfitRateCalculator {

    private final Map<Rank, Integer> prizeByRank = Map.of(
            Rank.FIRST, 2000000000,
            Rank.SECOND, 30000000,
            Rank.THIRD, 1500000,
            Rank.FOURTH, 50000,
            Rank.FIFTH, 5000,
            Rank.NONE, 0
    );

    public double calculateProfitRate(int purchaseAmount, Map<Rank, Integer> winningStatistics) {
        double totalPrizes = 0;
        for (Rank rank : winningStatistics.keySet()) {
            int prize = prizeByRank.get(rank);
            int count = winningStatistics.get(rank);
            totalPrizes += prize * count;
        }
        return Math.round((totalPrizes / purchaseAmount) * 1000) / 10.0;
    }
}
