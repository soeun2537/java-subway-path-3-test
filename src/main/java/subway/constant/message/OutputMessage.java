package subway.constant.message;

public enum OutputMessage {
    MAIN_OPTION_GUIDANCE("## 메인 화면"),
    MAIN_OPTION_ONE_GUIDANCE("1. 경로 조회"),
    MAIN_OPTION_Q_GUIDANCE("Q. 종료"),
    MAIN_OPTION_CHOOSE_GUIDANCE("## 원하는 기능을 선택하세요."),

    STANDARD_OPTION_GUIDANCE("## 경로 기준"),
    STANDARD_OPTION_ONE_GUIDANCE("1. 최단 거리"),
    STANDARD_OPTION_TWO_GUIDANCE("2. 최소 시간"),
    STANDARD_OPTION_B_GUIDANCE("B. 돌아가기"),
    STANDARD_OPTION_CHOOSE_GUIDANCE("## 원하는 기능을 선택하세요."),

    DEPARTURE_STATION_GUIDANCE("## 출발역을 입력하세요."),

    ARRIVAL_STATION_GUIDANCE("## 도착역을 입력하세요."),

    RESULT_GUIDANCE("## 조회 결과"),
    RESULT_LINE("[INFO] ---"),
    RESULT_TOTAL_DISTANCE("[INFO] 총 거리: %dkm"),
    RESULT_TOTAL_TIME("[INFO] 총 소요 시간: %d분"),
    RESULT_STATION("[INFO] %s"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
