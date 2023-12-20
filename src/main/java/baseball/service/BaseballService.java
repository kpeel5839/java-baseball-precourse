package baseball.service;

import baseball.repository.BallsGenerator;
import baseball.repository.domain.Balls;
import baseball.repository.domain.MatchingResult;

public class BaseballService {

    private final BallsGenerator ballsGenerator;

    public BaseballService() {
        this.ballsGenerator = new BallsGenerator();
    }

    public Balls generateBalls() {
        try {
            return ballsGenerator.generate();
        } catch (IllegalArgumentException illegalArgumentException) {
            return generateBalls();
        }
    }

    public MatchingResult judge(Balls balls, Balls generatedBalls) {
        return MatchingResult.of(balls, generatedBalls);
    }

}
