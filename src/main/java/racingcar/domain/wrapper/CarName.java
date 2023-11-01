package racingcar.domain.wrapper;

import static racingcar.domain.constant.CarCostant.CAR_NAME_MAX_LENGTH;

import java.util.Objects;

public class CarName {

    private final String name;

    private CarName(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static CarName create(final String name) {
        return new CarName(name);
    }

    @Override
    public boolean equals(Object diffCarName) {
        if (this == diffCarName) {
            return true;
        }
        if (diffCarName == null || getClass() != diffCarName.getClass()) {
            return false;
        }
        CarName carName = (CarName) diffCarName;
        return Objects.equals(name, carName.name);
    }

    public String getName() {
        return name;
    }

}
