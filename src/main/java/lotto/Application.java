package lotto;

import camp.nextstep.edu.missionutils.Console;
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
        OutputView outputView = new OutputView();
        LottoController controller = new LottoController();

        int purchaseAmount = readPurchaseAmount(inputView, outputView, controller);
        int purchaseCount = controller.purchaseCount(purchaseAmount);

        outputView.purchaseCount(purchaseCount);
        List<LottoTicket> tickets = controller.drawTickets(purchaseCount);
        outputView.lottoTickets(tickets);

        Lotto lotto = readDrawNumbers(inputView, outputView, controller);
        Bonus bonus = readBonus(lotto, inputView, outputView, controller);
        winningStatisticsResult(lotto, bonus, tickets, purchaseAmount, outputView, controller);
        Console.close();
    }

    private static void winningStatisticsResult(Lotto lotto, Bonus bonus, List<LottoTicket> tickets,
                                  int purchaseAmount, OutputView outputView, LottoController controller) {
        Map<Rank, Integer> winningStatistics = controller.winningStatistics(lotto, bonus, tickets);
        outputView.winningStatistics(winningStatistics);

        double profitRate = controller.profitRate(purchaseAmount, winningStatistics);
        outputView.profitRate(profitRate);
    }

    private static int readPurchaseAmount(InputView inputView, OutputView outputView, LottoController controller) {
        while (true) {
            try {
                String purchaseAmount = inputView.purchaseAmount();
                return controller.purchaseAmount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private static Lotto readDrawNumbers(InputView inputView, OutputView outputView, LottoController controller) {
        while (true) {
            try {
                String drawNumbers = inputView.drawNumbers();
                return controller.drawNumbers(drawNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private static Bonus readBonus(Lotto lotto, InputView inputView, OutputView outputView, LottoController controller) {
        while (true) {
            try {
                String input = inputView.drawBonusNumber();
                return controller.drawBonus(input, lotto);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
