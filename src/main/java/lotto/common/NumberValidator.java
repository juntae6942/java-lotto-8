package lotto.common;

import java.util.List;
import java.util.regex.Pattern;

public class NumberValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    public static void validateNumber(String input) {
        if (input == null || !NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 잘못된 문자열 입력입니다.");
        }
    }

    public static void validateNumbers(List<String> inputs) {
        inputs.forEach(NumberValidator::validateNumber);
    }
}
