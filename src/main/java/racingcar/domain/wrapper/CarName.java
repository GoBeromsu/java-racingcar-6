package racingcar.domain.wrapper;

import java.util.Objects;

public class CarName {

    private final String name;

    private CarName(final String name) {
        // todo: validate name
        this.name = name;
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
