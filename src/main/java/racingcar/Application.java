package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String[] carNames = Console.readLine().split(",");
        System.out.print("시도할 회수는 몇회인가요? ");
        int rounds = Integer.parseInt(Console.readLine());

        CarRacingGame carRacingGame = new CarRacingGame(carNames, rounds);
        carRacingGame.race();
    }
}
