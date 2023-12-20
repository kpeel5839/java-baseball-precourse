package baseball.repository.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final int BALLS_SIZE = 3;
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls from(List<Integer> inputBall) {
        validateBallsSize(inputBall);
        validateDuplicateBall(inputBall);

        List<Ball> balls = inputBall.stream()
                .map(Ball::from)
                .collect(Collectors.toList());

        return new Balls(balls);
    }

    private static void validateBallsSize(List<Integer> balls) {
        if (balls.size() == BALLS_SIZE) {
            return;
        }

        throw new IllegalArgumentException("숫자는 총 3개여야합니다.");
    }

    private static void validateDuplicateBall(List<Integer> balls) {
        long countOfDistinct = balls.stream()
                .distinct()
                .count();

        if (countOfDistinct == BALLS_SIZE) {
            return;
        }

        throw new IllegalArgumentException("중복된 숫자가 들어가서는 안됩니다.");
    }

    public List<Ball> getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + balls +
                '}';
    }

}
