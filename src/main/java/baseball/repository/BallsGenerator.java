package baseball.repository;

import baseball.repository.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallsGenerator { // Caching 해도됨, 아니 해야지 Repository 의 의미가 생김

    public Balls generate() {
        List<Integer> balls = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            balls.add(Randoms.pickNumberInRange(1, 9));
        }

        return Balls.from(balls);
    }

}
