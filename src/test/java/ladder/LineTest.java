package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        // give
        List<Point> points = Arrays.asList(new Point(Boolean.FALSE), new Point(Boolean.TRUE), new Point(Boolean.FALSE));
        line = new Line(points);
    }

    @Test
    @DisplayName("하나의 라인에 포인트 체크")
    void checkPointOfLineTest() {
        // when
        List<Boolean> types = line.types();

        // then
        assertThat(types).containsExactly(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
    }

    @Test
    @DisplayName("사다리 움직임 테스트")
    void movePointInLineTest() {
        // when
        int moveResultIndexZero = line.move(0);
        int moveResultIndexOne = line.move(1);
        int moveResultIndexTwo = line.move(2);

        // then
        assertThat(moveResultIndexZero).isEqualTo(0);
        assertThat(moveResultIndexOne).isEqualTo(1);
        assertThat(moveResultIndexTwo).isEqualTo(-1);
    }
}
