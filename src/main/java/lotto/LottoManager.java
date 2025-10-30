package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

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
}
