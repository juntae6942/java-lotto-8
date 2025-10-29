package lotto.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

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
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }
}
