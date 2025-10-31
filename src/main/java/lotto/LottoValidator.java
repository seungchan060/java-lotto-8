package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoValidator {
    public static int validatePurchaseAmount(String raw) {
        int amount = parseInt(raw, "[ERROR] 구입 금액은 정수여야 합니다.");
        if (amount < 1000) throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        if (amount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        return amount;
    }

    public static List<Integer> validateWinningNumbers(String raw) {
        if (raw == null || raw.trim().isEmpty()) throw new IllegalArgumentException("[ERROR] 당첨 번호는 비어 있을 수 없습니다.");

        List<Integer> nums = Arrays.stream(raw.split(","))
                .map(String::trim)
                .map(s -> parseInt(s, "[ERROR] 당첨 번호는 정수여야 합니다."))
                .collect(Collectors.toList());

        if (nums.size() != 6) throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        ensureRange(nums, 1, 45, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        ensureNoDup(nums, "[ERROR] 당첨 번호는 중복될 수 없습니다.");
        return nums;
    }

    public static int validateBonusNumber(String raw, List<Integer> winningNumbers) {
        if (raw == null || raw.trim().isEmpty()) throw new IllegalArgumentException("[ERROR] 보너스 번호는 비어 있을 수 없습니다.");
        int bonus = parseInt(raw, "[ERROR] 보너스 번호는 정수여야 합니다.");
        if (bonus < 1 || bonus > 45) throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        if (winningNumbers.contains(bonus)) throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        return bonus;
    }

    private static int parseInt(String s, String errorMsg) {
        try { return Integer.parseInt(s.trim()); }
        catch (NumberFormatException e) { throw new IllegalArgumentException(errorMsg); }
    }

    private static void ensureRange(List<Integer> nums, int min, int max, String msg) {
        for (int n : nums) if (n < min || n > max) throw new IllegalArgumentException(msg);
    }

    private static void ensureNoDup(List<Integer> nums, String msg) {
        if (new HashSet<>(nums).size() != nums.size()) throw new IllegalArgumentException(msg);
    }

}
