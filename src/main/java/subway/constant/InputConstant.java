package subway.constant;

public enum InputConstant {

    CHARACTER_PATTERN("^[가-힣]+$"),
    MAIN_OPTION_PATTER("^(1|Q)$"),
    STANDARD_OPTION_PATTERN("^(1|2|B)$"),

    LINE_SEPARATOR("_"),
    ;

    private final String content;

    InputConstant(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
