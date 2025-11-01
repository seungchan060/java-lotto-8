package lotto;

import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class OutputView {

    public void printPurchasedCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.sortedNumbers());
        }
    }

    public void printStatistics(Map<Rank, Integer> stats) {
        NumberFormat nf = NumberFormat.getInstance(Locale.KOREA);
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s원) - %d개%n", nf.format(Rank.FIFTH.prize()), stats.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (%s원) - %d개%n", nf.format(Rank.FOURTH.prize()), stats.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (%s원) - %d개%n", nf.format(Rank.THIRD.prize()), stats.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n", nf.format(Rank.SECOND.prize()), stats.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (%s원) - %d개%n", nf.format(Rank.FIRST.prize()), stats.getOrDefault(Rank.FIRST, 0));
    }

    public void printYield(double yieldPercent) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yieldPercent);
    }
}
