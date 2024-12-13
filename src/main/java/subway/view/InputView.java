package subway.view;

import java.util.Scanner;
import subway.util.Validator;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView from(Scanner scanner) {
        return new InputView(scanner);
    }

    public String readMainOption() {
        String input = input();
        Validator.validateNotNull(input);
        Validator.validateMainOption(input);
        return input;
    }

    public String readStandardOption() {
        String input = input();
        Validator.validateNotNull(input);
        Validator.validateStandardOption(input);
        return input;
    }

    public String readDepartureStation() {
        String input = input();
        Validator.validateNotNull(input);
        Validator.validateCharacter(input);
        Validator.validateExist(input);
        return input;
    }

    public String readArrivalStation(String departureStation) {
        String input = input();
        Validator.validateNotNull(input);
        Validator.validateCharacter(input);
        Validator.validateExist(input);
        Validator.validateDuplicate(departureStation, input);
        return input;
    }

    private String input() {
        return scanner.nextLine();
    }
}
