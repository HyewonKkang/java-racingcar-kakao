package model;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> generateRacingMessage() {
        return cars.stream().map(Car::generateMessage)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car -> car.run(RandomNumberGenerator.generate()));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .reduce(0, Integer::max);

        List<Car> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .forEach(winners::add);

        return winners;
    }
}
