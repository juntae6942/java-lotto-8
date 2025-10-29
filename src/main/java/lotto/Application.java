package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.presentation.LottoController;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController controller = new LottoController(inputView);
        int purchaseAmount = controller.purchaseAmount();
        int purchaseCount = controller.purchaseCount(purchaseAmount);

        OutputView outputView = new OutputView();
        outputView.purchaseCount(purchaseCount);

        List<LottoTicket> tickets = controller.drawTickets(purchaseCount);
        outputView.lottoTickets(tickets);

        Lotto lotto = controller.drawNumbers();
        Bonus bonus = controller.drawBonus(lotto);

        Map<Rank, Integer> winningStatistics = controller.winningStatistics(lotto, bonus, tickets);
        outputView.winningStatistics(winningStatistics);

    }
}
