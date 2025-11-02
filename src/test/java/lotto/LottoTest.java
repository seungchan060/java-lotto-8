package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void 로또_번호_범위_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("등수 계산: 5개+보너스=2등, 5개=3등")
    @Test
    void 등수_계산_검증() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        Rank rank = ticket.determineRank(winning);
        assertThat(rank).isEqualTo(Rank.SECOND);

        Lotto ticket3rd = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(ticket3rd.determineRank(winning)).isEqualTo(Rank.THIRD);
    }
}
