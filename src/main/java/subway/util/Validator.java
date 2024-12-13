package subway.util;

import static subway.constant.InputConstant.*;
import static subway.constant.message.ErrorMessage.*;

import subway.domain.StationInformation;

public class Validator {

    private Validator() {
    }

    public static void validateNotNull(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    public static void validateCharacter(String input) {
        if (!input.matches(CHARACTER_PATTERN.getContent())) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    public static void validateMainOption(String input) {
        if (!input.matches(MAIN_OPTION_PATTER.getContent())) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    public static void validateStandardOption(String input) {
        if (!input.matches(STANDARD_OPTION_PATTERN.getContent())) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    public static void validateExist(String input) {
        if (!StationInformation.checkExistence(input)) {
            throw new IllegalArgumentException(NOT_FOUND_STATION.getMessage());
        }
    }

    public static void validateDuplicate(String input1, String input2) {
        if (input1.equals(input2)) {
            throw new IllegalArgumentException(SAME_STATION.getMessage());
        }
    }
}
