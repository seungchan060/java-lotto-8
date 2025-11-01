package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class LottoManager {
    private static final int PRICE_PER_TICKET = 1000;

    public List<Lotto> buyLottos(int purchaseAmount) {
        int count = purchaseAmount / PRICE_PER_TICKET;
        List<Lotto> tickets = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            tickets.add(generateOneLotto());
        }
        return tickets;
    }

    private Lotto generateOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public Map<Rank, Integer> judge(List<Lotto> tickets, WinningLotto winning) {
        EnumMap<Rank, Integer> stats = new EnumMap<>(Rank.class);
        stats.put(Rank.FIFTH, 0);
        stats.put(Rank.FOURTH, 0);
        stats.put(Rank.THIRD, 0);
        stats.put(Rank.SECOND, 0);
        stats.put(Rank.FIRST, 0);

        for (Lotto t : tickets) {
            Rank r = t.determineRank(winning);
            if (r == Rank.MISS) continue;
            stats.put(r, stats.get(r) + 1);
        }
        return stats;
    }
}
