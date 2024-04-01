package view;

import model.Car;
import model.RacingGame;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private final Scanner sc = new Scanner(System.in);

    public String getCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public int getTryNumberInput() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return sc.nextInt();
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    private void printCarResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printCarsResult(List<Car> cars) {
        cars.forEach(this::printCarResult);
        System.out.println();
    }

    public void printWinnerMessage(RacingGame racingGame) {
        String winners = racingGame.getWinners().stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
