package lotto.ui;

import java.util.List;
import lotto.domain.LottoTicket;

public class OutputView {

    public void purchaseCount(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public void lottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
