package baseball.controller.view;

import baseball.repository.domain.Balls;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static Balls requestBalls() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine().trim();
        try {

            List<Integer> balls = Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            return Balls.from(balls);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static GameProgress requestRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        try {
            return GameProgress.from(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("재시작시에는 숫자를 입력해야합니다.");
        }
    }

}
