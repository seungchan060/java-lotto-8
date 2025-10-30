package lotto;

public class LottoValidator {
    public static int validatePurchaseAmount(String raw) {
        int amount = parseInt(raw);
        return amount;
    }

    private static int parseInt(String raw) {
        try {
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

}
