package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoManager manager = new LottoManager();

        int purchaseAmount = readValidPurchaseAmount(inputView);

        List<Lotto> purchasedLottos = manager.buyLottos(purchaseAmount);

        outputView.printPurchasedCount(purchasedLottos.size());
        outputView.printLottos(purchasedLottos);

        List<Integer> winningNumbers = readValidWinningNumbers(inputView);

    }

    private static int readValidPurchaseAmount(InputView inputView) {
        while (true) {
            try {
                String raw = inputView.readPurchaseAmount();
                return LottoValidator.validatePurchaseAmount(raw);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> readValidWinningNumbers(InputView inputView) {
        while (true) {
            try {
                String raw = inputView.readWinningNumbers();
                return LottoValidator.validateWinningNumbers(raw);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
