package lotto;

public class LottoValidator {
    public static int validatePurchaseAmount(String raw) {
        int amount = parseInt(raw);
        validateAmount(amount);
        return amount;
    }

    private static int parseInt(String raw) {
        try {
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

    private static void validateAmount(int amount) {
        if (amount < 1000) throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        if (amount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

}
