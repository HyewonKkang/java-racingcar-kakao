import controller.RacingController;
import model.NumberGenerator;
import util.RandomNumberGenerator;
import view.View;

public class RacingApplication {
    public static void main(String[] args) {
        View view = new View();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingController racingController =
                new RacingController(view, randomNumberGenerator);

        racingController.start();
    }
}
