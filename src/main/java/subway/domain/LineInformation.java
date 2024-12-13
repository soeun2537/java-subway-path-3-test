package subway.domain;

import java.util.ArrayList;
import java.util.List;

public enum LineInformation {
    교대역_강남역(2, 3),
    강남역_역삼역(2, 3),
    교대역_남부터미널역(3, 2),
    남부터미널역_양재역(6, 5),
    양재역_매봉역(1, 1),
    강남역_양재역(2, 8),
    양재역_양재시민의숲역(10, 3),
    ;

    private final int distance;
    private final int time;

    LineInformation(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public static List<String> getLineInformation() {
        List<String> lineInformation = new ArrayList<>();
        for (LineInformation value : values()) {
            lineInformation.add(value.name());
        }
        return lineInformation;
    }

    public static int findDistanceByName(String name) {
        for (LineInformation value : values()) {
            if (value.name().equals(name)) {
                return value.distance;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int findTimeByName(String name) {
        for (LineInformation value : values()) {
            if (value.name().equals(name)) {
                return value.time;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int sumDistance(List<String> paths) {
        int sum = 0;
        for (int i = 0; i < paths.size() - 1; i++) {
            LineInformation lineInformation = findLineInformation(paths.get(i), paths.get(i + 1));
            sum += lineInformation.distance;
        }
        return sum;
    }

    public static int sumTime(List<String> paths) {
        int sum = 0;
        for (int i = 0; i < paths.size() - 1; i++) {
            System.out.println("i = " + i);
            LineInformation lineInformation = findLineInformation(paths.get(i), paths.get(i + 1));
            sum += lineInformation.time;
        }
        return sum;
    }

    public static LineInformation findLineInformation(String departureStation, String arrivalStation) {
        for (LineInformation value : values()) {
            if (value.name().equals(departureStation + "_" + arrivalStation)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
