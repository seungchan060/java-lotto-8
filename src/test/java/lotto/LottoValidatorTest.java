package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoValidatorTest {
    @Test
    void 구입금액_검증() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount("999"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(LottoValidator.validatePurchaseAmount(" 2000 ")).isEqualTo(2000);
    }

    @Test
    void 당첨번호_검증() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers("1,2,3,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(LottoValidator.validateWinningNumbers("1, 2, 3, 4, 5, 6"))
                .containsExactly(1,2,3,4,5,6);
    }

    @Test
    void 보너스번호_검증() {
        List<Integer> winning = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber("", winning))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber("46", winning))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber("6", winning))
                .isInstanceOf(IllegalArgumentException.class);

        int bonus = LottoValidator.validateBonusNumber("7", winning);
        assertThat(bonus).isEqualTo(7);
    }
}
