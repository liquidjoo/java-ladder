package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        // give
        Point point = Point.firstNext(true);
        Point point1 = point.next(false);
        Point point2 = point1.next(true);
        List<Point> points1 = Arrays.asList(point, point1, point2, point2.lastNext());
        ladderLine = new LadderLine(points1);
    }

    @Test
    @DisplayName("포인트들 포인트 이동 여부 테스트")
    void pointsMoveTest() {
        // when
        int moveResultFirstIndex = ladderLine.move(0);
        int moveResultLastIndex = ladderLine.move(3);
        // then
        assertThat(moveResultFirstIndex).isEqualTo(1);
        assertThat(moveResultLastIndex).isEqualTo(2);
    }
}
