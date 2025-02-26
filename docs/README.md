# 🚀 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

# ✔️ 기능 명세서
## 경주할 자동차 이름 입력받기
- [ ] 메시지 출력하기: 사용자에게 자동차 이름을 입력하라는 메시지를 출력
- [ ] `,`를 기준으로 이름을 구분하기
    - 사용자가 입력한 문자열에서 쉼표(,)를 기준으로 자동차의 이름을 구분
- [ ] 이름 앞뒤에 공백이 들어있을 경우 제거
    - 각 자동차의 이름에서 앞뒤에 있는 공백을 제거
- [ ] 입력받은 이름의 길이가 5자 이하인지 체크하기
    - 각 자동차의 이름이 5자 이하인지 확인
    - 5자를 초과하는 이름이 있으면 `IllegalArgumentException`을 발생
- [ ] 입력받은 이름이 공백인지 체크하기
    - 각 자동차의 이름이 공백이 아닌지 확인
    - 공백인 이름이 있으면 `IllegalArgumentException`을 발생
- [ ] 입력받은 이름에 중복이 존재하는지 체크하기
    - 입력받은 자동차의 이름 중 중복된 이름이 있는지 확인
    - 중복된 이름이 있으면 `IllegalArgumentException`을 발생

## 시도할 횟수 입력받기
- [ ] 메시지 출력하기: 사용자에게 시도할 횟수를 입력하라는 메시지를 출력
- [ ] int 범위의 값이 들어오는지 체크하기
    - 사용자가 입력한 값이 int 범위 내에 있는지 확인
    - 그렇지 않으면 `IllegalArgumentException`을 발생
- [ ] 1 이상의 값인지 체크하기
    - 사용자가 입력한 값이 1 이상인지 확인
    - 그렇지 않으면 `IllegalArgumentException`을 발생

## 자동차 경주 진행하기
- [ ] 전진하는 조건에 대해서 0~9 사이의 값을 구하는 제너레이터 만들기
    - 전진 여부를 결정하기 위해 0에서 9 사이의 무작위 값을 생성하는 제너레이터를 구현
- [ ] 모든 자동차의 초기 상태에 대해서 출력하기
    - 모든 자동차의 초기 상태를 출력
- [ ] 4 이상이면 전진, 3 이하면 멈추도록 해서 자동차 움직이기
    - 각 자동차에 대해 무작위 값을 생성하고, 값이 4 이상이면 전진, 3 이하면 멈춤
- [ ] 자동차 경주 결과에 대해 출력하기
    - 각 라운드마다 자동차의 상태를 출력

## 최종적으로 우승한 자동차 이름을 출력하기
- [ ] 가장 많이 전진한 자동차를 판단하고, 최종 결과 출력하기
    - 모든 라운드를 마치고 나서, 가장 많이 전진한 자동차를 찾아 최종 결과를 출력
    - 만약 우승자가 여러 명이면 쉼표(,)를 이용하여 구분하여 출력

# ✔️ 도메인 설계

## Controller
- **RaceController**: 자동차 경주에 대한 컨트롤러를 관리

## Domain
### Constant
- **CarConstant**: Car에 대한 상수를 관리
- **CarsConstant**: Cars에 대한 상수를 관리
- **RaceConstant**: Race에 대한 상수를 관리

### Dto
- **CarRaceDto**: 개별 자동차의 경주 결과를 담는 DTO
- **RaceResultDto**: 사용자의 시도 횟수만큼의 전체 경주 결과를 담는 DTO

### Wrapper
- **CarName**: 자동차의 이름에 대한 래퍼 클래스
    - 자동차 이름에 대한 validate
    - 자동차 이름에는 공백이 들어올 수 없다.
    - 자동차 이름은 5글자 이하여야 한다.
- **CarPosition**: 자동차의 위치에 대한 래퍼 클래스
- **RaceCount**: 사용자의 시도 횟수 (경주 횟수)에 대한 래퍼 클래스
    - 시도할 횟수에 대한 validate
    - n은 int 범위의 값만 들어와야 한다.
    - n의 범위는 1 이상이어야 한다.

### Entity
- **Car**: 자동차의 정보를 관리하는 클래스
    - 필드
        - 자동차 이름
        - 자동차 위치
    - 메서드
        - 자동차 이동시키기
            - 4 이상의 값을 인자로 받으면 자동차의 위치를 1 증가시킨다.
        - 위치 비교하기
            - 현재 자동차의 위치와 인자로 들어온 자동차의 위치를 비교한다.
- **Cars**: 생성한 Car 리스트를 관리하는 일급 컬렉션
    - 필드
        - Car 리스트
    - 메서드
        - 전체 자동차 이름에 대한 validate
            - ,를 기준으로 자동차 이름 리스트를 split 한다.
            - 중복된 자동차 이름이 존재하는지 검증한다.
    - 자동차 리스트에 있는 모든 자동차를 경주시킨다.
    - 가장 먼 위치에 있는 자동차를 뽑는다.
- **Race**: 경주에 대해 관리하는 클래스.
    - 필드
        - 사용자의 시도 횟수 (경주 횟수)
    - 메서드
        - 경주가 시도 횟수만큼 진행되었는지 확인한다.

### Util
- **RaceNumberGenerator**: 레이스를 위해 필요한 0~9 사이의 값을 랜덤하게 뽑는 클래스
- **WinnerCar**: 우승한 자동차에 대해 관리하는 클래스.
    - 메서드
        - 모든 자동차와 가장 먼 자동차를 비교하여 우승한 자동차의 이름을 리턴한다.

### enumType
- **ExceptionMessage**: 예외 메시지를 관리
- **InputMessage**: 입력값에 대한 메시지를 관리
- **OutputMessage**: 출력값에 대한 메시지를 관리

### Exception
- **InputValidationException**: 사용자의 잘못된 입력에 대해 처리하는 `IllegalArgumentException`을 상속받은 커스텀 예외 클래스
    - `IllegalArgumentException`을 상속받아 사용자의 잘못된 입력을 처리
    - 사용자가 잘못된 값을 입력할 경우, `InputValidationException`이 발생하며 애플리케이션은 종료

## Service
- **CarsService**: Cars의 정보를 컨트롤러에게 전달하기 위한 중간 서비스 클래스.
- **RaceService**: Race의 정보를 컨트롤러에게 전달하기 위한 중간 서비스 클래스.
- **WinnerCarService**: WinnerCar의 정보를 컨트롤러에게 전달하기 위한 중간 서비스 클래스.

## Util
- **EnumUtil**: Enum에 대해 편리하게 getter를 할 수 있도록 제공하는 유틸 클래스.
- **NumberGenerator**: 랜덤값을 생성하는 인터페이스.

## View
- **InputView**: 콘솔을 통해 사용자에게 값을 입력받고, 에러 발생 시 재입력하도록 제공하는 클래스.
- **OutputView**: 콘솔에 대한 출력을 담당하는 클래스.

