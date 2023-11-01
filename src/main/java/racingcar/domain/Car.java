package racingcar.domain;


import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;
    private int position;

    private Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(final int power) {
        if (power >= 4) {
            this.position++;
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
        return position - diffCar.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
