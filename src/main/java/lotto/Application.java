package lotto;

import java.util.List;
import java.util.Map;

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
        int bonusNumber = readValidBonusNumber(inputView, winningNumbers);

        WinningLotto winning = new WinningLotto(winningNumbers, bonusNumber);

        Map<Rank, Integer> stats = manager.judge(purchasedLottos, winning);
        outputView.printStatistics(stats);
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

    private static int readValidBonusNumber(InputView inputView, List<Integer> winningNumbers) {
        while (true) {
            try {
                String raw = inputView.readBonusNumber();
                return LottoValidator.validateBonusNumber(raw, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
