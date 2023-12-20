package baseball.controller;

import static baseball.controller.view.GameProgress.PROGRESS;
import static baseball.controller.view.Judging.ALL_STRIKE;
import static baseball.controller.view.Judging.NOTHING;

import baseball.controller.view.GameProgress;
import baseball.controller.view.InputView;
import baseball.controller.view.Judging;
import baseball.controller.view.OutputView;
import baseball.repository.domain.Balls;
import baseball.repository.domain.MatchingResult;
import baseball.service.BaseballService;

public class BaseballController {

    private final BaseballService baseballService;
    private GameProgress gameProgress;

    public BaseballController() {
        this.baseballService = new BaseballService();
        this.gameProgress = PROGRESS;
    }

    public void gameStart() {
        while (gameProgress == PROGRESS) {
            Balls generatedBalls = baseballService.generateBalls();
            progress(generatedBalls);
        }
    }

    private void progress(Balls generatedBalls) {
        Judging judging = NOTHING;

        while (judging != ALL_STRIKE) {
            Balls balls = InputView.requestBalls();
            MatchingResult matchingResult = baseballService.judge(balls, generatedBalls);
            judging = Judging.from(matchingResult);
            OutputView.printMatchingResult(judging);
        }

        gameEnd();
    }

    private void gameEnd() {
        OutputView.printGameEnd();
        gameProgress = InputView.requestRestart();
    }

}
