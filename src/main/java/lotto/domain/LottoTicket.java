package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

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
