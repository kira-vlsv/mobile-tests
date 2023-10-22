package driver;

public enum Drivers {

    LOCAL("local"),
    BROWSER_STACK("browserstack");

    private final String value;

    Drivers(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
