package lotto;

public class LottoValidator {
    public static int validatePurchaseAmount(String raw) {
        int amount = parseInt(raw, "[ERROR] 구입 금액은 정수여야 합니다.");
        if (amount < 1000) throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        if (amount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        return amount;
    }

    private static int parseInt(String s, String errorMsg) {
        try { return Integer.parseInt(s.trim()); }
        catch (NumberFormatException e) { throw new IllegalArgumentException(errorMsg); }
    }

}
