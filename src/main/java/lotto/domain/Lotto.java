package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    public int matchCount(LottoTicket ticket) {
        return (int) numbers.stream()
                .filter(ticket.numbers()::contains)
                .count();
    }

    public void validateNotDuplicate(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복되는 보너스 번호입니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
           throw new IllegalArgumentException("[ERROR] 중복된 로또 번호를 포함하고 있습니다.");
        }
    }
}
