package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        if (new java.util.HashSet<>(numbers).size() != numbers.size())  throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        for (int n : numbers) {
            if (n < 1 || n > 45) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> sortedNumbers() {
        List<Integer> copy = new ArrayList<>(numbers);
        Collections.sort(copy);
        return Collections.unmodifiableList(copy);
    }

    public Rank determineRank(WinningLotto winning) {
        int matchCount = 0;
        for (int n : numbers) {
            if (winning.contains(n)) {
                matchCount++;
            }
        }
        boolean bonusMatched = numbers.stream().anyMatch(winning::isBonus);
        return Rank.from(matchCount, bonusMatched);
    }
}
