package controller;

import model.Car;
import model.RacingGame;
import model.NumberGenerator;
import view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final View view;
    private final NumberGenerator randomNumberGenerator;

    public RacingController(View view, NumberGenerator randomNumberGenerator) {
        this.view = view;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            start();
        }
    }

    private void play() {
        int tryNumber = view.getTryNumberInput();
        RacingGame racingGame = new RacingGame(createCars(), tryNumber);

        view.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            racingGame.moveCars(randomNumberGenerator);
            view.printCarResult(racingGame.generateRacingMessage());
        }

        view.printWinnerMessage(racingGame);
    }

    private List<Car> createCars() {
        String carNamesInput = view.getCarNameInput();
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
