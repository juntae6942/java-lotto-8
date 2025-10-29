package lotto.application;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.RandomLottoTicket;
import lotto.domain.Rank;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;

    public int matchCount(Lotto lotto, LottoTicket ticket) {
        return lotto.matchCount(ticket);
    }

    public int purchaseCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<LottoTicket> drawTickets(int purchaseCount) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(i -> new RandomLottoTicket())
                .collect(Collectors.toList());
    }

    public Map<Rank, Integer> calculateStatistics(Lotto lotto, Bonus bonus, List<LottoTicket> tickets) {
        Map<Rank, Integer> ranks = initRank();
        for (LottoTicket ticket : tickets) {
            int count = matchCount(lotto, ticket);
            boolean bonusMatch = bonus.matches(ticket);
            Rank rank = Rank.valueOf(count, bonusMatch);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return ranks;
    }

    private Map<Rank, Integer> initRank() {
        Map<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
        return ranks;
    }
}
