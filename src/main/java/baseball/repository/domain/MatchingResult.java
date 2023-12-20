package baseball.repository.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatchingResult {

    private final int ballCount;
    private final int strikeCount;

    public MatchingResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static MatchingResult of(Balls balls, Balls generatedBalls) {
        int ballCount = calculateBallCount(balls.getBalls(), generatedBalls.getBalls());
        int strikeCount = calculateStrikeCount(balls.getBalls(), generatedBalls.getBalls());

        return new MatchingResult(ballCount, strikeCount);
    }

    private static int calculateBallCount(List<Ball> balls, List<Ball> generatedBalls) {
        int ballCount = 0;

        for (int i = 0; i < balls.size(); i++) {
            ballCount = getBallCount(balls, generatedBalls, ballCount, i);
        }

        return ballCount;
    }

    private static int getBallCount(
            List<Ball> balls,
            List<Ball> generatedBalls,
            int ballCount,
            int i
    ) {
        Set<Integer> sameCountFinder = new HashSet<>();

        for (int j = 0; j < balls.size(); j++) {
            addCountInSameCountFinder(generatedBalls, i, sameCountFinder, j);
        }

        if (sameCountFinder.contains(balls.get(i).getCount())) {
            return ballCount + 1;
        }

        return ballCount;
    }

    private static void addCountInSameCountFinder(
            List<Ball> generatedBalls,
            int i,
            Set<Integer> set,
            int j
    ) {
        if (i == j) {
            return;
        }

        set.add(generatedBalls.get(j).getCount());
    }

    private static int calculateStrikeCount(List<Ball> balls, List<Ball> generatedBalls) {
        int strikeCount = 0;

        for (int i = 0; i < balls.size(); i++) {
            strikeCount = getStrikeCount(balls.get(i), generatedBalls.get(i), strikeCount);
        }

        return strikeCount;
    }

    private static int getStrikeCount(
            Ball firstBall,
            Ball secondBall,
            int strikeCount
    ) {
        if (firstBall.equals(secondBall)) {
            return strikeCount + 1;
        }

        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
