package lotto;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.presentation.LottoController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController();
        int purchaseAmount = controller.purchaseAmount();
        Lotto lotto = controller.drawNumbers();
        Bonus bonus = controller.drawBonus(lotto);
    }




}
