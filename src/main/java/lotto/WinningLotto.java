package lotto;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = List.copyOf(numbers); // 불변화
        this.bonus = bonus;
    }

}
