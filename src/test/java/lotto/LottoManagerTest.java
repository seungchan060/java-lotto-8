package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {
    @Test
    void judge_집계와_calculateYield_수익률() {
        LottoManager manager = new LottoManager();

        // 티켓 2장 (의도적으로 생성)
        Lotto t1 = new Lotto(List.of(2, 6, 11, 16, 23, 43));  // 4등
        Lotto t2 = new Lotto(List.of(2, 3, 5, 31, 40, 44));   // 5등
        List<Lotto> tickets = List.of(t1, t2);

        WinningLotto winning = new WinningLotto(List.of(2,3,5,6,11,44), 43);

        Map<Rank,Integer> stats = manager.judge(tickets, winning);
        assertThat(stats.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(stats.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(stats.get(Rank.THIRD)).isEqualTo(0);
        assertThat(stats.get(Rank.SECOND)).isEqualTo(0);
        assertThat(stats.get(Rank.FIRST)).isEqualTo(0);

        double yield = manager.calculateYield(stats, 2000); // 55,000 / 2,000 * 100 = 2750.0
        assertThat(yield).isEqualTo(2750.0);
    }
}
