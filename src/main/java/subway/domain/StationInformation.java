package subway.domain;

import java.util.ArrayList;
import java.util.List;

public enum StationInformation {
    교대역,
    강남역,
    역삼역,
    남부터미널역,
    양재역,
    양재시민의숲역,
    매봉역,
    ;

    public static List<String> getStationInformation() {
        List<String> stationInformation = new ArrayList<>();
        for (StationInformation value : values()) {
            stationInformation.add(value.name());
        }
        return stationInformation;
    }

    public static boolean checkExistence(String station) {
        for (StationInformation value : values()) {
            if (value.name().equals(station)) {
                return true;
            }
        }
        return false;
    }
}
