package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 유효성_검증() {
        // 개수
        assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5), 7))
                .isInstanceOf(IllegalArgumentException.class);

        // 중복
        assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,3,4,5), 7))
                .isInstanceOf(IllegalArgumentException.class);

        // 범위
        assertThatThrownBy(() -> new WinningLotto(List.of(0,2,3,4,5,6), 7))
                .isInstanceOf(IllegalArgumentException.class);

        // 보너스 범위
        assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,6), 0))
                .isInstanceOf(IllegalArgumentException.class);

        // 보너스 중복
        assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
