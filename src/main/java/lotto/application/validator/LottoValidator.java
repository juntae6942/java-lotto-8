package lotto.application.validator;

import java.util.List;

public class LottoValidator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위(1~45)를 벗어난 입력입니다.");
        }
    }

    public static void validateRanges(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateRange);
    }
}
