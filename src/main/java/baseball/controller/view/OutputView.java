package baseball.controller.view;

public class OutputView {

    private OutputView() {
    }

    public static void printMatchingResult(Judging judging) {
        System.out.println(judging.getStatus());
    }


    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
