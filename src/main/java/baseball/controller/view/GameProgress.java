package baseball.controller.view;

import java.util.Arrays;

public enum GameProgress {

    PROGRESS(1),
    QUIT(2),
    ;

    private final int value;

    GameProgress(int value) {
        this.value = value;
    }

    public static GameProgress from(int input) {
        return Arrays.stream(values())
                .filter(gameProgress -> gameProgress.value == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 숫자를 입력하셨습니다."));
    }

}
