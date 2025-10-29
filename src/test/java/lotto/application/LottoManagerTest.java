package lotto.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Bonus;
import lotto.domain.CustomLottoTicket;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @DisplayName("구매 금액 5,000원은 로또 티켓 5개를 반환한다.")
    @Test
    void purchaseAmount5000Test() {
        int count = lottoManager.purchaseCount(5000);
        assertThat(count).isEqualTo(5);
    }

    @DisplayName("구매 금액이 1,000원 보다 작으면 로또 티켓은 생성하지 않는다.")
    @Test
    void purchaseAmountUnder1000Test() {
        int count = lottoManager.purchaseCount(900);
        assertThat(count).isEqualTo(0);
    }

    @DisplayName("구매 갯수가 5개면 로또 티켓을 5개 만든다.")
    @Test
    void drawTicketsTest() {
        int purchaseCount = 5;
        List<LottoTicket> tickets = lottoManager.drawTickets(purchaseCount);
        assertThat(tickets).hasSize(5);
    }

    @DisplayName("구매 갯수가 0개면 로또 티켓을 0개 만든다.")
    @Test
    void drawTicketsZeroTest() {
        int purchaseCount = 0;
        List<LottoTicket> tickets = lottoManager.drawTickets(purchaseCount);
        assertThat(tickets).isEmpty();
    }

    @DisplayName("5등이 2개 나머지가 1개씩 있는 당첨 통계를 계산한다")
    @Test
    void calculateStatisticsRankTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);

        List<LottoTicket> tickets = List.of(
                new CustomLottoTicket(List.of(1, 2, 3, 4, 5, 6)),
                new CustomLottoTicket(List.of(1, 2, 3, 4, 5, 7)),
                new CustomLottoTicket(List.of(1, 2, 3, 4, 5, 8)),
                new CustomLottoTicket(List.of(1, 2, 3, 4, 8, 9)),
                new CustomLottoTicket(List.of(1, 2, 3, 8, 9, 10)),
                new CustomLottoTicket(List.of(1, 2, 3, 11, 12, 13)),
                new CustomLottoTicket(List.of(10, 11, 12, 13, 14, 15))
        );
        Map<Rank, Integer> result = lottoManager.calculateStatistics(lotto, bonus, tickets);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(1);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(2);
        assertThat(result.get(Rank.NONE)).isEqualTo(1);
    }
}