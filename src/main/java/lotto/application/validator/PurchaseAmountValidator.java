package lotto.application.validator;

public class PurchaseAmountValidator {

    private static final int LOTTO_PRICE = 1000;

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 구입 금액 단위입니다.");
        }
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 양수 값이 아닙니다.");
        }
    }
}
