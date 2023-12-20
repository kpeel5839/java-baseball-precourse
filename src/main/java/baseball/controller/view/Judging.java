package baseball.controller.view;

import baseball.repository.domain.MatchingResult;
import java.util.Arrays;

public enum Judging {

    NOTHING(0, 0, "낫싱"),

    ZERO_BALL_ONE_STRIKE(0, 1, "1스트라이크"),
    ZERO_BALL_TWO_STRIKE(0, 2, "2스트라이크"),
    ALL_STRIKE(0, 3, "3스트라이크"),

    ONE_BALL_ZERO_STRIKE(1, 0, "1볼"),
    ONE_BALL_ONE_STRIKE(1, 1, "1볼 1스트라이크"),
    ONE_BALL_TWO_STRIKE(1, 2, "1볼 2스트라이크"),

    TWO_BALL_ZERO_STRIKE(2, 0, "2볼"),
    TWO_BALL_ONE_STRIKE(2, 1, "2볼 1스트라이크"),

    ALL_BALL(3, 0, "3볼"),
    ;

    private final int ballCount;
    private final int strikeCount;
    private final String status;

    Judging(int ballCount, int strikeCount, String status) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.status = status;
    }

    public static Judging from(MatchingResult matchingResult) {
        return Arrays.stream(values())
                .filter(judging -> isaBoolean(judging, matchingResult))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 심사 결과가 존재하지 않습니다."));
    }

    private static boolean isaBoolean(Judging value, MatchingResult matchingResult) {
        return value.ballCount == matchingResult.getBallCount()
                && value.strikeCount == matchingResult.getStrikeCount();
    }

    public String getStatus() {
        return status;
    }

}
