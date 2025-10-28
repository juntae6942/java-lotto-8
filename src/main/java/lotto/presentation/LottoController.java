package lotto.presentation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.application.validator.LottoValidator;
import lotto.application.validator.PurchaseAmountValidator;
import lotto.common.NumberValidator;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.ui.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public int purchaseAmount() {
        while (true) {
            try {
                String input = inputView.purchaseAmount();
                NumberValidator.validateNumber(input);
                int purchaseAmount = Integer.parseInt(input);

                PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto drawNumbers() {
        while (true) {
            try {
                String input = inputView.drawNumbers();
                Set<String> tokens = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .collect(Collectors.toUnmodifiableSet());
                NumberValidator.validateNumbers(tokens);

                List<Integer> numbers = tokens.stream()
                        .map(Integer::parseInt).toList();
                LottoValidator.validateRanges(numbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
