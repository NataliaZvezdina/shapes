package by.zvezdina.shapes.comparator;

import by.zvezdina.shapes.entity.Ellipse;
import by.zvezdina.shapes.entity.Point;

import java.util.Comparator;

public class EllipticityComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        Point point1Ellipse1 = o1.getPoint1();
        Point point2Ellipse1 = o1.getPoint2();

        double semiaxisX1 = Math.abs(point1Ellipse1.getX() - point2Ellipse1.getX()) / 2;
        double semiaxisY1 = Math.abs(point1Ellipse1.getY() - point2Ellipse1.getY()) / 2;
        double ellipticity1 = semiaxisX1 / semiaxisY1;

        Point point1Ellipse2 = o2.getPoint1();
        Point point2Ellipse2 = o2.getPoint2();

        double semiaxisX2 = Math.abs(point1Ellipse2.getX() - point2Ellipse2.getX()) / 2;
        double semiaxisY2 = Math.abs(point1Ellipse2.getY() - point2Ellipse2.getY()) / 2;
        double ellipticity2 = semiaxisX2 / semiaxisY2;

        return Double.compare(ellipticity1, ellipticity2);
    }
}
