package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

public class OutputView {

    public void purchaseCount(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public void lottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void winningStatistics(Map<Rank, Integer> winningStatistics) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : winningStatistics.keySet()) {
            if(rank == Rank.NONE) {
                continue;
            }
            System.out.println(rank + " - " + winningStatistics.get(rank) + "개");
        }
    }
}
