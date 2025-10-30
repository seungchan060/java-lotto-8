package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String raw = inputView.readPurchaseAmount();
        int purchaseAmount = LottoValidator.validatePurchaseAmount(raw);

        LottoManager manager = new LottoManager();
        List<Lotto> purchasedLottos = manager.buyLottos(purchaseAmount);

    }
}
