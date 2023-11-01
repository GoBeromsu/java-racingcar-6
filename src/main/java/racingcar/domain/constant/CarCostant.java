package racingcar.domain.constant;

public enum CarCostant {
    INIT_POSITION(1),
    CAR_MOVE_CONDITION(4),
    CAR_NAME_MAX_LENGTH(5);

    private final int number;

    CarCostant(int number) {
        this.number = number;
    }

    public String getKey() {
        return name();
    }

    public int getValue() {
        return number;
    }
}