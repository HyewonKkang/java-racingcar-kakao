package model;

import util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public RacingGame(List<Car> cars, int tryNumber) {
        validateTryNumber(tryNumber);
        this.cars = cars;
    }

    public List<String> generateRacingMessage() {
        return cars.stream()
                .map(Car::generateMessage)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car -> car.run(RandomNumberGenerator.generate()));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .reduce(0, Integer::max);

        return cars.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public void validateTryNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
