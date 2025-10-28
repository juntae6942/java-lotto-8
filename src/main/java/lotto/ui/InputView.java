package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.validator.PurchaseAmountValidator;
import lotto.common.NumberValidator;

public class InputView {

    public int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        NumberValidator.validateNumber(input);
        int purchaseAmount = Integer.parseInt(input);

        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }


}
