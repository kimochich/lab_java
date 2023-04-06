package lab12.lab12_5;

import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public PolyLine() {
        points = new ArrayList<>();
    }

    public void appendPoint(Point point) {
        points.add(point);
    }

    public void appendPoint(int x, int y) {
        Point point = new Point(x, y);
        points.add(point);
    }

    public double getLength() {
        double totalLength = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            int j = i + 1;
            totalLength += Math.sqrt(Math.pow(points.get(j).getX() - points.get(i).getX(), 2) + Math.pow(points.get(j).getY() - points.get(i).getY(), 2));
        }
        return totalLength;
    }


}

