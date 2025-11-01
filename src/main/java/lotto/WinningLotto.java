package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = List.copyOf(numbers); // 불변화
        this.bonus = bonus;
    }

    private void validate(List<Integer> nums, int bonus) {
        if (nums == null || nums.size() != 6) throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        Set<Integer> set = new HashSet<>(nums);
        if (set.size() != nums.size()) throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        for (int n : nums) {
            if (n < 1 || n > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (bonus < 1 || bonus > 45)  throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        if (set.contains(bonus)) throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}
