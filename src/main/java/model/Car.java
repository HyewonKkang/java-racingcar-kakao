package model;

import java.util.Objects;

public class Car {
    private int position;
    private final String name;

    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void run(int number) {
        if (number >= MOVE_THRESHOLD) {
            position += 1;
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isAtPosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
