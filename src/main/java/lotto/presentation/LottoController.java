package lotto.presentation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.application.LottoManager;
import lotto.application.validator.LottoValidator;
import lotto.application.validator.PurchaseAmountValidator;
import lotto.common.NumberValidator;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.Rank;

public class LottoController {

    private final LottoManager lottoManager;
    private final ProfitRateCalculator profitRateCalculator;

    public LottoController() {
        this.lottoManager = new LottoManager();
        this.profitRateCalculator = new ProfitRateCalculator();
    }

    public int purchaseAmount(String number) {
        NumberValidator.validateNumber(number);
        int purchaseAmount = Integer.parseInt(number);
        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public Lotto drawNumbers(String numbers) {
        Set<String> tokens = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableSet());
        NumberValidator.validateNumbers(tokens);
        List<Integer> drawNumbers = tokens.stream()
                .map(Integer::parseInt).toList();
        LottoValidator.validateRanges(drawNumbers);
        return new Lotto(drawNumbers);
    }

    public Bonus drawBonus(String number, Lotto lotto) {
        NumberValidator.validateNumber(number);
        int bonusNumber = Integer.parseInt(number);
        LottoValidator.validateRange(bonusNumber);
        lotto.validateNotDuplicate(bonusNumber);
        return new Bonus(bonusNumber);
    }

    public int purchaseCount(int purchaseAmount) {
        return lottoManager.purchaseCount(purchaseAmount);
    }

    public List<LottoTicket> drawTickets(int purchaseCount) {
        return lottoManager.drawTickets(purchaseCount);
    }

    public double profitRate(int purchaseAmount, Map<Rank, Integer> winningStatistics) {
        return profitRateCalculator.calculateProfitRate(purchaseAmount, winningStatistics);
    }

    public Map<Rank, Integer> winningStatistics(Lotto lotto, Bonus bonus, List<LottoTicket> tickets) {
        return lottoManager.calculateStatistics(lotto, bonus, tickets);
    }
}
