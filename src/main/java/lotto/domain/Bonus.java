package lotto.domain;

public class Bonus {

    private final int number;

    public Bonus(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

    public boolean matches(LottoTicket ticket) {
        return ticket.numbers().contains(number);
    }
}
