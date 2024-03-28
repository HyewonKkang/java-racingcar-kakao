package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    void validateCarNameTest() {
        String carName = "longlonglong";
        assertThrows(IllegalArgumentException.class,
                () -> new Car(carName));
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 경우 전진한다")
    void forwardTest() {
        Car car = new Car("helen");
        car.run(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 3 이하일 경우 멈춘다")
    void stopTest() {
        Car car = new Car("eve");
        car.run(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
