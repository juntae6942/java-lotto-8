package lotto;

import lotto.ui.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        int purchaseAmount = purchaseAmount(inputView);


    }

    private static int purchaseAmount(InputView inputView) {
        while (true) {
            try {
                return inputView.purchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
