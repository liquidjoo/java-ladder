package reladder.domain;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    private void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("경로를 찾을 수 없습니다.");
        }
    }

    public Direction last() {
        return of(this.right, false);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction next(boolean nextRight) {
        if (this.right) {
            return of(true, false);
        }
        return of(false, nextRight);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
