package subway.constant.message;

public enum ErrorMessage {

    INVALID_FORMAT("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    NOT_FOUND_STATION("존재하지 않는 역 이름입니다. 다시 입력해 주세요."),
    SAME_STATION("출발역과 도착역이 동일합니다."),
    NOT_CONNECTED_STATION("출발역과 도착역이 연결되어 있지 않습니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
