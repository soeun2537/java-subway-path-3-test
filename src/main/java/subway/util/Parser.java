package subway.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private Parser() {
    }

    public static List<String> separateBySeparator(String input, String separator) {
        return Arrays.stream(input.split(separator))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
