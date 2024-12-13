package subway;

import java.util.Scanner;
import subway.controller.SubwayController;
import subway.service.SubwayService;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = InputView.from(scanner);

        SubwayService subwayService = new SubwayService();
        SubwayController subwayController = new SubwayController(inputView, subwayService);
        subwayController.run();
    }
}
