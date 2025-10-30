package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoManager manager = new LottoManager();

        String raw = inputView.readPurchaseAmount();
        int purchaseAmount = LottoValidator.validatePurchaseAmount(raw);

        List<Lotto> purchasedLottos = manager.buyLottos(purchaseAmount);

        outputView.printPurchasedCount(purchasedLottos.size());
        outputView.printLottos(purchasedLottos);

    }
}
