package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String raw = inputView.readPurchaseAmount();
        int purchaseAmount = LottoValidator.validatePurchaseAmount(raw);

    }
}
