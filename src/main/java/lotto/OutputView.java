package lotto;

import java.util.List;

public class OutputView {

    public void printPurchasedCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.sortedNumbers());
        }
    }
}
