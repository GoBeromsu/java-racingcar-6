package racingcar.domain.wrapper;

public class CarPosition {

    private int position;

    private CarPosition(final int position) {
        this.position = position;
    }

    public static CarPosition create() {
        return new CarPosition(1);
    }

    public void addPosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

}
