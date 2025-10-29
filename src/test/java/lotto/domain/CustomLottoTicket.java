package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CustomLottoTicket implements LottoTicket {

    List<Integer> numbers;

    public CustomLottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
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
