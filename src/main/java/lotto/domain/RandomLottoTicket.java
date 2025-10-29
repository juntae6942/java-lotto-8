package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottoTicket implements LottoTicket {

    private final List<Integer> numbers;

    public RandomLottoTicket() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    @Override
    public List<Integer> numbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
