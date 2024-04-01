package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    @Test
    @DisplayName("시도 횟수는 1 이상이어야 한다")
    void validateTryNumberTest() {
        int tryNumber = 0;

        assertThatThrownBy(() -> new RacingGame(Arrays.asList(new Car("first")), tryNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가장 포지션 값이 높은 차(또는 차들)가 우승한다")
    void winnerExistsTest() {
        Car first = new Car("a");
        Car second = new Car("b");
        Car third = new Car("c");

        RacingGame racingGame = new RacingGame(Arrays.asList(first, second, third), 1);
        NumberGenerator selectiveRandomGenerator = new RandomNumberGenerator() {
            private int callCount = 0;

            @Override
            public int generate() {
                callCount++;
                if (callCount % 2 == 0) {
                    return 4;
                } else {
                    return 3;
                }
            }
        };

        racingGame.moveCars(selectiveRandomGenerator);

        assertThat(racingGame.getWinners()).containsExactly(second);
    }
}
