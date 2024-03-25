package car;

import java.util.Objects;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void run(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
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