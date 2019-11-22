package reladder;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int index) {
        return this.points.get(index).move();
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
