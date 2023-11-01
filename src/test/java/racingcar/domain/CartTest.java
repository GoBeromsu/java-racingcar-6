package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest {

    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = Car.create("pobi");
    }

    @Test
    @DisplayName("입력으로 들어온 위치와 현재 자동차의 위치가 같다면 true를 반환한다.")
    void givenSamePosition_thenReturnTrue() {
        // given
        Car diffCar = Car.create("crong");
        // when
        boolean isSamePosition = testCar.isSamePosition(diffCar);
        // then
        assertThat(isSamePosition).isTrue();
    }

    @Test
    @DisplayName("입력으로 들어온 위치와 현재 자동차의 위치가 다르다면 false를 반환한다.")
    void givenSampPosition_thenReturnFalse() {
        // given
        Car diffCar = Car.create("crong");
        diffCar.move(5);
        // when
        boolean isSamePosition = testCar.isSamePosition(diffCar);
        // then
        assertThat(isSamePosition).isFalse();
    }
}
