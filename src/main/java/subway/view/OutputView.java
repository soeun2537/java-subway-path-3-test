package subway.view;

import static subway.constant.message.OutputMessage.*;

import java.util.List;

public class OutputView {

    public static void printMainOptionGuidance() {
        printNewLine();
        println(MAIN_OPTION_GUIDANCE.getMessage());
        println(MAIN_OPTION_ONE_GUIDANCE.getMessage());
        println(MAIN_OPTION_Q_GUIDANCE.getMessage());
        printNewLine();
        println(MAIN_OPTION_CHOOSE_GUIDANCE.getMessage());
    }

    public static void printStandardOptionGuidance() {
        printNewLine();
        println(STANDARD_OPTION_GUIDANCE.getMessage());
        println(STANDARD_OPTION_ONE_GUIDANCE.getMessage());
        println(STANDARD_OPTION_TWO_GUIDANCE.getMessage());
        println(STANDARD_OPTION_B_GUIDANCE.getMessage());
        printNewLine();
        println(STANDARD_OPTION_CHOOSE_GUIDANCE.getMessage());
    }

    public static void printDepartureStationGuidance() {
        printNewLine();
        println(DEPARTURE_STATION_GUIDANCE.getMessage());
    }

    public static void printArrivalStationGuidance() {
        printNewLine();
        println(ARRIVAL_STATION_GUIDANCE.getMessage());
    }

    public static void printResult(int distance, int time, List<String> stations) {
        printNewLine();
        println(RESULT_GUIDANCE.getMessage());
        println(RESULT_LINE.getMessage());
        println(RESULT_TOTAL_DISTANCE.getMessage(distance));
        println(RESULT_TOTAL_TIME.getMessage(time));
        println(RESULT_LINE.getMessage());
        for (String station : stations) {
            println(RESULT_STATION.getMessage(station));
        }
    }

    public static void printErrorMessage(RuntimeException e) {
        printNewLine();
        println(e.getMessage());
    }

    private static void println(String content) {
        System.out.println(content);
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
