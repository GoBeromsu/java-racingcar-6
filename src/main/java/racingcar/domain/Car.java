package racingcar.domain;


import java.util.Objects;
import racingcar.domain.wrapper.CarName;
import racingcar.domain.wrapper.CarPosition;

public class Car implements Comparable<Car> {

    private final CarName name;
    private final CarPosition position;

    private Car(final String name) {
        this.name = CarName.create(name);
        this.position = CarPosition.create();
    }

    public void move(final int power) {
        if (power >= 4) {
            position.addPosition();
        }
    }

    public static Car create(final String name) {
        return new Car(name);
    }

    public boolean isSamePosition(final Car diffCar) {
        return this.position == diffCar.position;
    }

    @Override
    public boolean equals(final Object diffCar) {
        if (this == diffCar) {
            return true;
        }
        if (diffCar == null || getClass() != diffCar.getClass()) {
            return false;
        }
        Car car = (Car) diffCar;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car diffCar) {
        return position.getPosition() - diffCar.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
