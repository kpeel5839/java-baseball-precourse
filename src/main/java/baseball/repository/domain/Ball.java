package baseball.repository.domain;

import java.util.Objects;

public class Ball {

    private final Integer count;

    private Ball(Integer count) {
        this.count = count;
    }

    public static Ball from(Integer count) {
        validateNull(count);
        validateRangeOfCount(count);

        return new Ball(count);
    }

    private static void validateNull(Integer count) {
        if (Objects.nonNull(count)) {
            return;
        }

        throw new IllegalArgumentException("숫자 입력은 필수입니다.");
    }

    private static void validateRangeOfCount(Integer count) {
        if (1 <= count && count <= 9) {
            return;
        }

        throw new IllegalArgumentException("숫자는 1 ~ 9 사이의 숫자여야합니다.");
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ball ball = (Ball) o;
        return Objects.equals(count, ball.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "count=" + count +
                '}';
    }

}
