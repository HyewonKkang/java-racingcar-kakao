package model;


import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int tryNumber;
    private int currentRound;

    public RacingGame(List<Car> cars, int tryNumber) {
        validateTryNumber(tryNumber);
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void moveCars(NumberGenerator randomNumberGenerator) {
        cars.forEach(car -> car.run(randomNumberGenerator.generate()));
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

    public boolean isGameOver() {
        return currentRound >= tryNumber;
    }

    public List<Car> getCars() {
        return cars;
    }
}
